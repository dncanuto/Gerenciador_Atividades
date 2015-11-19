<%-- 
    Document   : home
    Created on : 31/10/2015, 14:21:09
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <script src="recursos/js/jquery-2.1.1.js" type="text/javascript"></script>        
        <script src="recursos/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>        
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>        

        <script src="recursos/js/funcoes-globais.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-funcionario.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-projeto.js" type="text/javascript"></script>   
        <script src="recursos/js/ajax-sprint.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-atividade.js" type="text/javascript"></script>

        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/autocomplete/main.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>  
        </header>
        
        <div style="width: auto; margin-top: 100px;">
            <a href="javascript:novoFuncionario()">Novo Funcionario</a>
            <br>
            <section id="tbFuncionario">
                <%@include file="gridFuncionario.jsp"%>
            </section>
            <br>

            <a href="javascript:novoProjeto()">Novo Projeto</a>
            <br>
            <div id="tbProjeto">
                <%@include file="gridProjeto.jsp" %>  
            </div>
            <br>

            <div id="tbSprint">
                <%@include file="gridSprint.jsp" %>  
            </div>
            <br>
            
            <div id="tbAtividade">
                <%@include file="gridAtividade.jsp" %>  
            </div>
            <br>
        </div>

        <div id="div-modal-sprint">            
            <%@include file="modal/cad-sprint.jsp" %>        
        </div>
        <br>

        <div id="div-modal-funcionario">
            <%@include file="modal/cad-funcionario.jsp" %>      
        </div>
        <br>

        <div id="div-modal-projeto">            
            <%@include file="modal/cad-projeto.jsp" %>        
        </div>       

        <div id="div-modal-atividade">            
            <%@include file="modal/cad-atividade.jsp" %>        
        </div>

    </body>
</html>
