/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.AtividadeDAO;
import DAO.Model.DicionarioDAO;
import DAO.Model.ProjetoDAO;
import DAO.Model.SprintDAO;
import VO.Model.Projeto;
import VO.Model.Sitsprint;
import VO.Model.Sprint;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorSprint {

    @RequestMapping("novo-sprint-restrito")
    public ModelAndView novoSprint(int projetoId) throws Exception {
        return modalCadSprint(null, "I", projetoId);
    }

    @RequestMapping("alterar-sprint-restrito")
    public ModelAndView alterarSprint(int sprintId, int projetoId) throws Exception {
        Sprint s = SprintDAO.pesquisaSprint(sprintId);
        return modalCadSprint(s, "A", projetoId);
    }

    private ModelAndView modalCadSprint(Sprint s, String operacao, int projetoId) throws Exception {
        ModelAndView mv = new ModelAndView("modal/cad-sprint");
        mv.addObject("sprint", s);
        mv.addObject("operacao", operacao);
        mv.addObject("projeto", ProjetoDAO.pesquisaProjeto(projetoId));
        mv.addObject("situacoes", DicionarioDAO.listarSituacoesSprint());
        return mv;
    }

    @RequestMapping("lista-sprint-restrito")
    public ModelAndView listaFuncionario(int projetoId) throws SQLException, Exception {
        ModelAndView mv = new ModelAndView("gridSprint");
        Projeto p = ProjetoDAO.pesquisaProjeto(projetoId);
        mv.addObject("listaSprint", SprintDAO.listarSprints(p));
        return mv;
    }
    
    @RequestMapping("get-atividades-sprint")
    public ModelAndView atividadesSprint(int sprintId){       
        
        Sprint s = SprintDAO.pesquisaSprint(sprintId);
        
        ModelAndView mv = new ModelAndView("atividades-projeto");
        mv.addObject("sprintAtividade", s);
        mv.addObject("listaAtividade", AtividadeDAO.listarAtividades(s));
        return mv;        
    }

    @RequestMapping(value = "salvar-sprint-restrito", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String salvarSprint(
            Sprint sprint,
            BindingResult result,
            HttpSession sessao,
            HttpServletRequest request,
            String operacao) {

        try {
            HashMap<String, String> erros = new HashMap<String, String>();

            if (sprint.getNome().trim().length() == 0) {
                erros.put("erroNomeSprint", "Informe o nome do modulo a ser desenvolvido");
            }
            if (sprint.getDescricao().trim().length() == 0) {
                erros.put("erroDescricaoSprint", "Informe a descrição do modulo");
            }

            String projetoId = request.getParameter("projetoId");
            String sitsprint = request.getParameter("sitsprint");

            if (projetoId != "") {
                Projeto p = new Projeto();
                p.setId(Integer.parseInt(projetoId));
                sprint.setProjeto(p);
            }

            if (!sitsprint.equalsIgnoreCase("") & !sitsprint.equalsIgnoreCase("0")) {
                Sitsprint sit = new Sitsprint();
                sit.setId(Integer.parseInt(sitsprint));
                sprint.setSitsprint(sit);
            } else {
                erros.put("erroSitSprint", "Selecione a situação do sprint");
            }

            if (erros.isEmpty()) {
                if (operacao.equalsIgnoreCase("I")) {
                    sprint.setDtcriacao(new Date());
                } else {
                    sprint.setDtalteracao(new Date());
                }

                //sprint.setProjeto(projeto);
                SprintDAO.salvarSprint(sprint);
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
