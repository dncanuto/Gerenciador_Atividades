/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author William
 */
public class AutorizadorAcesso extends  HandlerInterceptorAdapter{
    
     @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response,
            Object controller) throws Exception {
        
        String uri = request.getRequestURI();

        if (uri.toUpperCase().contains("RESTRITO")) {
            if (request.getSession().getAttribute("logado") == null
                    || (boolean) request.getSession().getAttribute("logado") == false) {

                
                if (request.getQueryString() != null) {
                    uri += "?" + request.getQueryString();
                }
                
                request.getSession().setAttribute("endereco", uri);
                
                RequestDispatcher dispacher = request.getRequestDispatcher("exibe-login");
                dispacher.forward(request, response);
                return false;
            }
        }
        return true;
    } 
    
    
}
