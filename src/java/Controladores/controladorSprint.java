/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
    
    @RequestMapping("novo-sprint")
    public ModelAndView novoSprint(int projetoId) throws Exception{
        return modalCadSprint(null, "I", projetoId);
    }
    
    @RequestMapping("alterar-sprint")
    public ModelAndView alterarSprint(int sprintId, int projetoId) throws Exception{
        Sprint s = SprintDAO.pesquisaSprint(sprintId);
        return modalCadSprint(s, "A", projetoId);
    }
    
    private ModelAndView modalCadSprint(Sprint s, String operacao, int projetoId) throws Exception{
        ModelAndView mv = new ModelAndView("modal/cad-sprint");
        mv.addObject("sprint", s);
        mv.addObject("operacao", operacao);
        mv.addObject("projeto", ProjetoDAO.pesquisaProjeto(projetoId));
        mv.addObject("situacoes", DicionarioDAO.listarSituacoesSprint());
        return mv;
    }
    
    @RequestMapping("lista-sprint")
    public ModelAndView listaFuncionario() throws SQLException {
        ModelAndView mv = new ModelAndView("gridSprint");
        mv.addObject("listaSprint", SprintDAO.listarSprints());
        return mv;
    }
    
    @RequestMapping(value = "salvar-sprint", produces = "application/json; charset=UTF-8")
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
                erros.put("", "");
            }
            if (sprint.getDescricao().trim().length() == 0) {
                erros.put("", "");
            }    
            
            String projetoId = request.getParameter("projetoId");
            String sitsprint = request.getParameter("sitsprint");
            
            if(projetoId != ""){
                Projeto p = new Projeto();
                p.setId(Integer.parseInt(projetoId));
                sprint.setProjeto(p);
            }
            
            if(sitsprint != ""){
                Sitsprint sit = new Sitsprint();
                sit.setId(Integer.parseInt(sitsprint));
                sprint.setSitsprint(sit);
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
