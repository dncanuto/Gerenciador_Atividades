/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import VO.Model.Funcionario;
import org.springframework.stereotype.Controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author William
 */

@Controller
public class ControladorLogin {

    @RequestMapping("exibe-login")
    public ModelAndView exibeLogin(
            HttpServletRequest request,
            @CookieValue(value = "loginCookie", defaultValue = "") String loginCookie, // se usar request nao precisa desse parâmetro
            @CookieValue(value = "senhaCookie", defaultValue = "") String senhaCookie) {  // nem desse!

        ModelAndView mv = new ModelAndView("login");

        Cookie c = obterCookie("loginCookie", request);
        if (c != null) {
            mv.addObject("loginCookie", c.getValue());
        }

        c = obterCookie("senhaCookie", request);
        if (c != null) {
            mv.addObject("senhaCookie", c.getValue());
        }

        /*
         mv.addObject("loginCookie", loginCookie );
         mv.addObject("senhaCookie", senhaCookie );        
         */
        return mv;
    }

    private Cookie obterCookie(String nomeCookie, HttpServletRequest request) {
        Cookie[] lista = request.getCookies();
        for (Cookie c : lista) {
            if (c.getName().equals(nomeCookie)) {
                return c;
            }
        }
        return null;
    }

    @RequestMapping("efetua-logoff")
    public String logOff(HttpSession sessao) {
        sessao.setAttribute("logado", false);
        return "redirect:index";
    }

    @RequestMapping("efetua-login")
    public ModelAndView efetuaLogin(
            String usuario, String senha, boolean ckSalvaLogin,
            HttpSession sessao,
            HttpServletResponse response) {

        ModelAndView mv;

        Funcionario f = DAO.Model.FuncionarioDAO.autenticacaoLogin(usuario, senha);
        
        if (f != null) {
            
            if (ckSalvaLogin) {
                Cookie c = new Cookie("loginCookie", usuario);
                c.setMaxAge(60); // em segundos
                response.addCookie(c);

                c = new Cookie("senhaCookie", senha);
                c.setMaxAge(60); // em segundos
                response.addCookie(c);
            }

            sessao.setAttribute("logado", true);
            sessao.setAttribute("funcionario", f);

            if (sessao.getAttribute("endereco") == null) {
                mv = new ModelAndView("redirect:index");
            } else {
                String endereco = sessao.getAttribute("endereco").toString();
                endereco = endereco.substring(endereco.lastIndexOf("/") + 1);
                mv = new ModelAndView("redirect:" + endereco);
            }

            sessao.removeAttribute("endereco");
        } else {
            sessao.setAttribute("logado", false);
            mv = new ModelAndView("redirect:exibe-login");
        }
        return mv;
    }
}
