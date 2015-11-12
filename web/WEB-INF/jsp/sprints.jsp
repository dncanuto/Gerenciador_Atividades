<%-- 
    Document   : sprints
    Created on : 12/11/2015, 16:22:45
    Author     : William
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sprints</title>
        <script src="recursos/js/jquery-2.1.1.js" type="text/javascript"></script>        
        <script src="recursos/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>        
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>        

        <script src="recursos/js/funcoes-globais.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-funcionario.js" type="text/javascript"></script>
        <script src="recursos/js/ajax-projeto.js" type="text/javascript"></script>   
        <script src="recursos/js/ajax-sprint.js" type="text/javascript"></script>

        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/autocomplete/main.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %> 
        </header>
        <h1>Sprints</h1>
         <div id="tbSprint">
            <%@include file="gridSprint.jsp" %>  
        </div>
        
        <div id="div-modal-sprint">            
            <%@include file="modal/cad-sprint.jsp" %>        
        </div>
    </body>
</html>
