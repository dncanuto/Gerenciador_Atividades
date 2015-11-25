<%-- 
    Document   : gridAtividade
    Created on : 18/11/2015, 21:52:00
    Author     : Programador
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="div-modal-atividade">            
    <%@include file="modal/cad-atividade.jsp" %>        
</div>

<div class="table-responsive">
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Nome da Atividade</th>    
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
                    <a href="javascript:alterarAtividade(${a.id})" class="linkProjeto">
                        <span class="glyphicon glyphicon-edit">
                            Editar Atividade
                        </span>
                    </a>   
                </td>
            </tr>
        </c:forEach>
    </table>
</div>