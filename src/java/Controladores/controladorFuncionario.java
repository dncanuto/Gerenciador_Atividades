/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.DicionarioDAO;
import DAO.Model.FuncionarioDAO;
import DAO.Model.ProjetoDAO;
import DAO.Model.SprintDAO;
import VO.Model.Funcionario;
import VO.Model.Tpcargo;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorFuncionario {

    @RequestMapping("/index")
    public ModelAndView minhaHome(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        
        ModelAndView mv;
        
        if (request.getSession().getAttribute("logado") == null
                || (boolean) request.getSession().getAttribute("logado") == false) {

            mv = new ModelAndView("login");
            return mv;
        } else {

            mv = new ModelAndView("home");
            mv.addObject("lista", FuncionarioDAO.listarFuncionarios());
            mv.addObject("listaProjeto", ProjetoDAO.listarProjetos());
            mv.addObject("listaSprint", SprintDAO.listarSprints());
            return mv;
        }
    }

    @RequestMapping("lista-funcionario-restrito")
    public ModelAndView listaFuncionario() throws SQLException {
        ModelAndView mv = new ModelAndView("gridFuncionario");
        mv.addObject("lista", FuncionarioDAO.listarFuncionarios());
        return mv;
    }

    @RequestMapping("novo-funcionario-restrito")
    public ModelAndView novoFuncionario() {
        return modalCadFuncionario(new Funcionario(), "I");
    }

    @RequestMapping("altera-funcionario-restrito")
    public ModelAndView alterarFuncionario(int id) {
        try {
            Funcionario f = FuncionarioDAO.pesquisaFuncionario(id);
            return modalCadFuncionario(f, "A");
        } catch (Exception erro) {
            return null;
        }
    }

    private ModelAndView modalCadFuncionario(Funcionario f, String operacao) {

        try {
            ModelAndView mv = new ModelAndView("modal/cad-funcionario");
            mv.addObject("funcionario", f);
            mv.addObject("operacao", operacao);
            mv.addObject("Cargos", DicionarioDAO.listarCargos());
            return mv;
        } catch (Exception erro) {
            return null;
        }
    }

    @RequestMapping(value = "salva-funcionario-restrito", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String salvaFuncionario(
            Funcionario funcionario,
            BindingResult result,
            HttpServletRequest request,
            String operacao) {

        try {
            HashMap<String, String> erros = new HashMap<String, String>();

            if (funcionario.getNome().trim().length() == 0) {
                erros.put("erronome", null);
            }

            if (funcionario.getSobrenome().trim().length() == 0) {
                erros.put("errosobrenome", null);
            }

            if (funcionario.getEmail().trim().length() == 0) {
                erros.put("erroemail", null);
            }

            if (funcionario.getPassword().trim().length() == 0) {
                erros.put("erropassword", null);
            }

            String cargoSelecionado = request.getParameter("tpcargo");
            funcionario.setTpcargo(new Tpcargo());

            if (cargoSelecionado.equalsIgnoreCase("")) {
                erros.put("erropassword", null);
            } else {
                funcionario.getTpcargo().setId(Integer.parseInt(cargoSelecionado));
            }

            if (erros.isEmpty()) {
                FuncionarioDAO.salvarFuncionario(funcionario, operacao);
            }

            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();

            myObj.addProperty("sucesso", erros.isEmpty());
            JsonElement objetoErrosEmJson = gson.toJsonTree(erros);
            myObj.add("erros", objetoErrosEmJson);

            /*JsonElement listaFuncionariosEmJson = gson.toJsonTree(FuncionarioDAO.listarFuncionarios());
             myObj.add("lista", listaFuncionariosEmJson);*/
            return myObj.toString();
        } catch (Exception erro) {
            return null;
        }
    }
    
    @RequestMapping("tabela-funcionarios-restrito")
    public ModelAndView tabelaFuncionario() {
        try{
            ModelAndView mv = new ModelAndView("usuarios");
            return mv;
        }catch(Exception erro) {
            return null;
        }
    }
}
