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
        <title>JSP Page</title>
       
        <script src="recursos/js/jquery-2.1.1.js" type="text/javascript"></script>        
        <script src="recursos/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>        
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>        
        
        <script src="recursos/js/funcoes-globais.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-funcionario.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-projeto.js" type="text/javascript"></script>        
        
        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/autocomplete/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Funcionou!</h1>        

        <button type="button" class="btn btn-info btn-lg" onclick="novoFuncionario()">Novo Funcionário</button>

        <div id="div-modal-funcionario">            
            <%@include file="modal/cad-funcionario.jsp" %>        
        </div>
        <br>

        <div id="tbFuncionario">
            <%@include file="gridFuncionario.jsp" %>  
        </div>
        <br>

        <button type="button" class="btn btn-info btn-lg" onclick="novoProjeto()">Novo Projeto</button>
        <div id="div-modal-projeto">            
            <%@include file="modal/cad-projeto.jsp" %>        
        </div>
        <br>
        
        <div id="tbProjeto">
            <%@include file="gridProjeto.jsp" %>  
        </div>
        <br>
    </body>
</html>
