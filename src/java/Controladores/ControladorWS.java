/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.DicionarioDAO;
import DAO.Model.FuncionarioDAO;
import VO.Model.Tag;
import VO.Model.Tpprioridade;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel
 */
@RestController
public class ControladorWS {  
    
    @RequestMapping(value = "get-autocomplete-funcionarios", method = RequestMethod.GET, headers = "Accept=*/*", produces = "text/html; charset=UTF-8")
    public @ResponseBody
    String getTags(@RequestParam String tagName) {

        String searchList = new Gson().toJson(FuncionarioDAO.getFuncionarios(tagName));
        return searchList;
    }
}
