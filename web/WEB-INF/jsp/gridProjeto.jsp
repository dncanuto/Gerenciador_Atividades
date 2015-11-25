<%-- 
    Document   : gridProjeto
    Created on : 10/11/2015, 15:05:59
    Author     : Daniel
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Nome do Projeto</th>        
            <th>Opções</th>
        </tr>
        <c:forEach items="${listaProjeto}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.nome}</td>            
                <td>
                    <a href="dados-projeto-restrito?projetoId=${p.id}">
                        <span class="glyphicon-edit">
                            Ver Dados
                        </span>      
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
