/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.Model.Projeto;
import VO.Model.Tag;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
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

    List<Tag> data = new ArrayList<Tag>();

    controladorProjeto() {
        // init data for testing
        data.add(new Tag(1, "ruby"));
        data.add(new Tag(2, "rails"));
        data.add(new Tag(7, "javascript"));
        data.add(new Tag(8, "jscript"));

    }

    @RequestMapping("novo-projeto")
    public ModelAndView novoProjeto() {
        return modalCadProjeto(null, "I");
    }

    @RequestMapping("alterar-projeto")
    public ModelAndView alterarProjeto(int id) {
        try {
            Projeto p = null;
            return modalCadProjeto(p, "A");
        } catch (Exception erro) {
            return null;
        }
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

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();

        JsonElement listaFuncionariosEmJson = gson.toJsonTree(simulateSearchResult(tagName));
        myObj.add("lista", listaFuncionariosEmJson);
        return myObj.toString();
    }

    private List<Tag> simulateSearchResult(String tagName) {

        List<Tag> result = new ArrayList<Tag>();

        // iterate a list and filter by tagName
        for (Tag tag : data) {
            if (tag.getTagName().contains(tagName)) {
                result.add(tag);
            }
        }

        return result;
    }

}
