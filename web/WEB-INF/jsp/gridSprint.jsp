<%-- 
    Document   : gridSprint
    Created on : 11/11/2015, 22:23:03
    Author     : Daniel
--%>


<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="div-modal-sprint">            
    <%@include file="modal/cad-sprint.jsp" %>        
</div>

<div class="table-responsive">
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Nome do Sprint</th>       
            <th>Situação</th> 
            <th>Atividades</th> 
            <th>Opções</th>
        </tr>
        <c:forEach items="${listaSprint}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.nome}</td>  
                <td>${s.sitsprint.label}</td>
                <td>
                    <a href="javascript:getAtividadesSprint(${s.id})"> 
                        <span class="glyphicon glyphicon-folder-open">
                            Ver Atividades
                        </span>
                    </a>
                </td>
                <td>
                    <a href="javascript:alterarSprint(${s.id}, ${s.projeto.id})" class="linkProjeto">
                        <span class="glyphicon glyphicon-edit">
                            Editar Sprint
                        </span>
                    </a> 
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

