<%-- 
    Document   : atividade-funcionario
    Created on : 25/11/2015, 23:36:13
    Author     : Daniel
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
            <th>Projeto</th>
            <th>Sprint</th>
            <th>Prioridade</th> 
            <th>Situação</th>
            <th>Opções</th>
        </tr>
        <c:forEach items="${listaAtividade}" var="a">
            <tr>
                <td>${a.id}</td>
                <td>${a.nome}</td>  
                <td>${a.sprint.projeto.nome}</td>
                <td>${a.sprint.nome}</td>                
                <td>${a.tpprioridade.label}</td>
                <td>${a.sitatividade.label}</td>
                <td>
                    <a href="javascript:alterarAtividadeFuncionario(${a.id})" class="linkProjeto">
                        <span class="glyphicon glyphicon-edit">
                            Editar Atividade
                        </span>
                    </a>   
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
