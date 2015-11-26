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

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Meus Projetos

                        <a href="dados-projeto-restrito?projetoId=0" class="linkProjeto pull-right">
                            <span class="glyphicon glyphicon-pencil">Clique aqui para adicionar um novo projeto</span>
                        </a>

                    </h3>
                </div>
                <div id="tbProjeto">
                    <%@include file="gridProjeto.jsp" %>  
                </div>
            </div>
            <br>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Minhas Atividades</h3>
                </div>
                
                <div id="tbAtividades">
                    <%@include file="atividade-funcionario.jsp" %>  
                </div>
            </div>
        </div>                  
    </body>
</html>
