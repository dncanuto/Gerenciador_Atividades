<%-- 
    Document   : cad-projeto
    Created on : 25/11/2015, 12:15:08
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciador de Atividades - Projeto</title>

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
        <div class="page-header">
            <h1>Dados do Projeto</h1>
        </div>
        
        <div id="dadosProjeto">
            <%@include file="dados-projeto.jsp" %>
        </div>
        
        <br>
        
        <div id="sprints-projeto">
            <%@include file="sprints-projeto.jsp" %>
        </div>
        
        <br>
        
        <div id="atividades-sprint">
            <%@include file="atividades-projeto.jsp" %>
        </div>
        
    </body>
</html>
