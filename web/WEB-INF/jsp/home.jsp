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
        <script src="recursos/js/jquery-1.11.2.js" type="text/javascript"></script>
        <script src="recursos/js/funcoes-ajax.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>        
        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Funcionou!</h1>        
        
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Novo Funcionário</button>
        
        <div id="div-modal-funcionario">            
            <%@include file="modal/cad-funcionario.jsp" %>        
        </div>
        
        <table id="tbFuncionario">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Opções</th>
            </tr>
            <c:forEach items="${lista}" var="f">
                <tr>
                    <td>${f.id}</td>
                    <td>${f.nome}</td>
                    <td>
                        <a href="javascript:alterar(${f.id})" data-toggle="modal" data-target="#myModal">Alterar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
