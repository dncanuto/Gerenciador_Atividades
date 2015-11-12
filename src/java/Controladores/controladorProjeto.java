/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.FuncionarioDAO;
import DAO.Model.ProjetoDAO;
import VO.Model.Funcionario;
import VO.Model.Projeto;
import VO.Model.Tag;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorProjeto {

    @RequestMapping("novo-projeto-restrito")
    public ModelAndView novoProjeto(HttpServletRequest request) {
        limpaSessaoFuncProjeto(request.getSession());
        return modalCadProjeto(null, "I");
    }

    @RequestMapping("alterar-projeto-restrito")
    public ModelAndView alterarProjeto(int id, HttpServletRequest request) {
        try {          
            limpaSessaoFuncProjeto(request.getSession());
            Projeto p = ProjetoDAO.pesquisaProjeto(id);
            ArrayList<Tag> funcProjeto = ProjetoDAO.getFuncSalvoToTag(p);
            request.getSession().setAttribute("funcProjeto", funcProjeto);
            ModelAndView mv = modalCadProjeto(p, "A");            
            mv.addObject("listaFuncProjeto", funcProjeto);            
            return mv;
        } catch (Exception erro) {
            return null;
        }
    }
    
    @RequestMapping("lista-projeto-restrito")
    public ModelAndView pagListaProjeto() throws Exception{
        ModelAndView mv = new ModelAndView("gridProjeto");
        mv.addObject("listaProjeto", ProjetoDAO.listarProjetos());
        return mv;
    }

    private ModelAndView modalCadProjeto(Projeto p, String operacao) {

        try {
            ModelAndView mv = new ModelAndView("modal/cad-projeto");
            mv.addObject("projeto", p);            
            mv.addObject("operacao", operacao);
            
            return mv;
        } catch (Exception erro) {
            return null;
        }
    }

    @RequestMapping(value = "getTags", method = RequestMethod.GET, headers = "Accept=*/*", produces = "text/html; charset=UTF-8")
    public @ResponseBody
    String getTags(@RequestParam String tagName) {

        String searchList = new Gson().toJson(FuncionarioDAO.getFuncionarios(tagName));
        return searchList;
    }   

    private ModelAndView listFuncProjeto(ArrayList<Tag> funcProjeto) {
        ModelAndView mv = new ModelAndView("modal/listFuncionarioProjeto");
        mv.addObject("listaFuncProjeto", funcProjeto);
        return mv;
    }

    @RequestMapping("add-func-projeto-restrito")
    public ModelAndView addFuncionarioToProjeto(
            int tagId,
            String tagName,
            HttpServletRequest request) {
        try {
            HttpSession sessao = request.getSession();
            ArrayList<Tag> funcProjeto = funcionariosProjeto(sessao);

            Tag f = pesquisaFuncionarioNoProjeto(tagId, funcProjeto);

            if (f == null) {
                funcProjeto.add(new Tag(tagId, tagName));
            }

            return listFuncProjeto(funcProjeto);
        } catch (Exception erro) {
            return null;
        }
    }

    private void limpaSessaoFuncProjeto(HttpSession sessao) {

        if (sessao.getAttribute("funcProjeto") != null) {
            sessao.removeAttribute("funcProjeto");
        }
    }

    private ArrayList<Tag> funcionariosProjeto(HttpSession sessao) {

        if (sessao.getAttribute("funcProjeto") == null) {
            ArrayList<Tag> funcProjeto = new ArrayList<Tag>();
            sessao.setAttribute("funcProjeto", funcProjeto);
        }

        ArrayList funcProjeto = (ArrayList<Tag>) sessao.getAttribute("funcProjeto");
        return funcProjeto;
    }

    private Tag pesquisaFuncionarioNoProjeto(int id, ArrayList<Tag> funcProjeto) {
        for (Tag funcionario : funcProjeto) {
            if (funcionario.getTagId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @RequestMapping("remove-func-projeto-restrito")
    public ModelAndView removeFuncProjeto(int id, int projetoId, HttpSession sessao, HttpServletRequest request) throws Exception {

        ArrayList<Tag> funcProjeto = funcionariosProjeto(sessao);
        Tag g = pesquisaFuncionarioNoProjeto(id, funcProjeto);
        
        Funcionario f = FuncionarioDAO.pesquisaFuncionario(id);
        Projeto p = ProjetoDAO.pesquisaProjeto(projetoId);

        if (g != null) {
            if(g.isIsExisteBD())
                ProjetoDAO.desabilitaFuncionarioProjeto(f, p);
            funcProjeto.remove(g);
        }

        return listFuncProjeto(funcProjeto);
    }

    @RequestMapping(value = "salvar-projeto-restrito", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String salvarProjeto(
            Projeto projeto,
            BindingResult result,
            HttpSession sessao,
            HttpServletRequest request,
            String operacao) {

        try {
            HashMap<String, String> erros = new HashMap<String, String>();
            ArrayList<Tag> funcProjeto = funcionariosProjeto(sessao);

            if (projeto.getNome().trim().length() == 0) {
                erros.put("", "");
            }
            if (projeto.getDescricao().trim().length() == 0) {
                erros.put("", "");
            }
            if (funcProjeto.isEmpty()) {
                erros.put("", "");
            }

            if (erros.isEmpty()) {
                if (operacao.equalsIgnoreCase("I")) {
                    projeto.setDtcriacao(new Date());
                } else {
                    projeto.setDtalteracao(new Date());
                }
                
                ProjetoDAO.salvarProjeto(projeto, funcProjeto, operacao);
            }

            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            myObj.addProperty("sucesso", erros.isEmpty());
            JsonElement objetoErrosEmJson = gson.toJsonTree(erros);
            myObj.add("erros", objetoErrosEmJson);

            return myObj.toString();
        } catch (Exception erro) {
            return null;
        }
    }
}
