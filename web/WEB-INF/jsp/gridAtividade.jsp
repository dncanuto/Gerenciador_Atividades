<%-- 
    Document   : gridAtividade
    Created on : 18/11/2015, 21:52:00
    Author     : Programador
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table-bordered table-condensed table-responsive">
    <tr>
        <th>ID</th>
        <th>Nome da Atividade</th>       
        <th>Sprint</th> 
        <th>Prioridade</th> 
        <th>Situação</th>
        <th>Opções</th>
    </tr>
    <c:forEach items="${listaAtividade}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.nome}</td>  
            <td>${a.sprint.nome}</td>
            <td>${a.tpprioridade.label}</td>
            <td>${a.sitatividade.label}</td>
            <td>
                <a href="javascript:alterarAtividade(${a.id})"><span class="glyphicon-edit"></span></a>   
            </td>
        </tr>
    </c:forEach>
</table>