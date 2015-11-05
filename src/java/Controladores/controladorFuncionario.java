/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Dados.FuncionarioDAO;
import VO.Dados.Funcionario;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.HashMap;
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
public class controladorFuncionario {

    @RequestMapping("/index")
    public ModelAndView minhaHome() throws SQLException {
        ModelAndView mv = new ModelAndView("home"); // abrir a home 
        mv.addObject("lista", FuncionarioDAO.listarFuncionarios());
        return mv;
    }    
    
    @RequestMapping("lista-funcionario")
    public ModelAndView listaFuncionario() throws SQLException {
        ModelAndView mv = new ModelAndView("gridFuncionario"); // abrir a home 
        mv.addObject("lista", FuncionarioDAO.listarFuncionarios());
        return mv;
    }   
    
    @RequestMapping("altera-funcionario")
    public ModelAndView alterarFuncionario(int id){
        ModelAndView mv = new ModelAndView("modal/cad-funcionario"); // abrir a home 
        mv.addObject("funcionario", FuncionarioDAO.pesquisaFuncionario(id));
        return mv;
    }

    @RequestMapping(value = "salva-funcionario", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String salvaFuncionario(
            Funcionario funcionario,
            BindingResult result) {

        try{
            HashMap<String, String> erros = new HashMap<String, String>();
                        
            if(funcionario.getNome().trim().length() == 0){
                erros.put("erronome", null);
            }
            
            if(funcionario.getSobrenome().trim().length() == 0){
                erros.put("errosobrenome", null);
            }
            
            if(funcionario.getEmail().trim().length() == 0){
                erros.put("erroemail", null);
            }
            
            if(funcionario.getPassword().trim().length() == 0){
                erros.put("erropassword", null);
            }
            
            if(erros.isEmpty()){
                FuncionarioDAO.criaFuncionario(funcionario);
            }

            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            myObj.addProperty("sucesso", erros.isEmpty());
            JsonElement objetoErrosEmJson = gson.toJsonTree(erros);
            myObj.add("erros", objetoErrosEmJson);
            
            /*JsonElement listaFuncionariosEmJson = gson.toJsonTree(FuncionarioDAO.listarFuncionarios());
            myObj.add("lista", listaFuncionariosEmJson);*/
            
            return myObj.toString();
        }
        catch(Exception erro){
            return null;
        }
    }
}
