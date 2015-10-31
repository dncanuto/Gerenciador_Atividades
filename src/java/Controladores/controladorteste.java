/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.Dados.FuncionarioVO;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorteste {
    
    @RequestMapping("/index")
    public ModelAndView minhaHome() throws SQLException {
        ModelAndView mv = new ModelAndView("home"); // abrir a home        
        return mv;
    }  
    
    @RequestMapping(value="dados-funcionario", produces = "text/html; charset=UTF-8")
    public ModelAndView dadosFuncionario(){
        FuncionarioVO f = new FuncionarioVO();
        f.setNome("teste");
        f.setEmail("teste@teste.com");
        f.setSobrenome("teste");
        
        ModelAndView mv = new ModelAndView("modal/cad-funcionario");
        mv.addObject("funcionario", f);
        return mv;
    }
}
