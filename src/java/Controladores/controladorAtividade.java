/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.AtividadeDAO;
import DAO.Model.DicionarioDAO;
import VO.Model.Atividade;
import VO.Model.Sitatividade;
import VO.Model.Tpprioridade;
import VO.Model.Tptempo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
public class controladorAtividade {

    @RequestMapping("nova-atividade-restrito")
    public ModelAndView novaAtividade() {
        return montaCadAtividade(new Atividade(), "I");
    }

    private ModelAndView montaCadAtividade(Atividade a, String operacao) {
        ModelAndView mv = new ModelAndView("modal/cad-atividade");
        mv.addObject("atividade", a);
        mv.addObject("operacao", operacao);
        mv.addObject("listaPrioridade", DicionarioDAO.listarDadosEntidade(Tpprioridade.class));
        mv.addObject("listaTempo", DicionarioDAO.listarDadosEntidade(Tptempo.class));
        mv.addObject("listaSituacao", DicionarioDAO.listarDadosEntidade(Sitatividade.class));
        return mv;
    }

    @RequestMapping(value="salvar-atividade", produces = "text/html; charset=UTF-8")     
    @ResponseBody
    public String salvarAtividade(String obj) {

        try{
            Atividade atividade = new Gson().fromJson(obj, Atividade.class);
            
            HashMap<String, String> erros = new HashMap<String, String>();            
            
            if(atividade.getNome().trim().length() == 0)
                erros.put("erroNome","Informe um nome para a atividade!");
            
            if(atividade.getDescricao().trim().length() == 0)
                erros.put("erroDescricao","Informe uma descrição para a atividade!");     
            
            if(atividade.getTpprioridade().getId() == 0)
                erros.put("erroTpPrioridade","Selecione uma prioridade para a atividade!");
            
            if(atividade.getSitatividade().getId() == 0)
                erros.put("erroSitAtividade","Selecione uma situação para a atividade!");
            
            if(atividade.getTpprioridade().getId() == 0)
                erros.put("erroTpPrioridade","Selecione uma prioridade para a atividade!");
            
            if(atividade.getTptempoByTptempoestimadoid().getId() == 0)
                erros.put("erroTempoEstimado","Selecione o tempo estimado de conclusção da atividade!");
            
            if(erros.isEmpty()){
                AtividadeDAO.salvarAtividade(atividade);
            }
            
            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            myObj.addProperty("sucesso", erros.isEmpty());
            JsonElement objetoErrosEmJson = gson.toJsonTree(erros);
            myObj.add("erros", objetoErrosEmJson);
            
        }catch(Exception erro){
            erro.printStackTrace();            
        }
        
        return null;
    }

}