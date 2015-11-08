/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.Model.Projeto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorProjeto {
    
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
    
}
