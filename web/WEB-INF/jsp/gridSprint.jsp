<%-- 
    Document   : gridSprint
    Created on : 11/11/2015, 22:23:03
    Author     : Daniel
--%>


<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <th>ID</th>
        <th>Nome do Sprint</th>       
        <th>Situação</th> 
        <th>Projeto</th> 
        <th>Opções</th>
    </tr>
    <c:forEach items="${listaSprint}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.nome}</td>  
            <td>${s.sitsprint.label}</td>
            <td>${s.projeto.nome}</td>
            <td>
                <a href="javascript:alterarSprint(${s.id}, ${s.projeto.id})">Alterar</a>                
            </td>
        </tr>
    </c:forEach>
</table>

