/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.DicionarioDAO;
import VO.Model.Atividade;
import VO.Model.Sitatividade;
import VO.Model.Tpprioridade;
import VO.Model.Tptempo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

    @RequestMapping(value="salvar-atividade", method=RequestMethod.POST, consumes="application/json", produces = "text/html; charset=UTF-8")     
    public @ResponseBody String salvarAtividade(@ModelAttribute Atividade atividade) {

        String myObj = new Gson().toJson(atividade);               

        return myObj;
    }

}
