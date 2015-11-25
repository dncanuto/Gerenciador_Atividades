<%-- 
    Document   : dados-projeto
    Created on : 25/11/2015, 12:20:33
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="div-modal-projeto">            
    <%@include file="modal/cad-projeto.jsp" %>        
</div>  

<c:choose>
    <c:when test="${projeto == null}">        

        <div class="panel panel-default">
            <div class="panel-body">
                <a href="javascript:novoProjeto()" class="linkProjeto">
                    <span class="glyphicon glyphicon-plus">
                        Clique aqui para adicionar as informações do projeto
                    </span>
                </a>
            </div>
        </div>

    </c:when>
    <c:otherwise>

        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">${projeto.nome}

                    <a href="javascript:alterarProjeto(${projeto.id})" class="linkProjeto pull-right">
                        <span class="glyphicon glyphicon-pencil">Clique aqui para alterar as informações</span>
                    </a>

                </h3>
            </div>
            <div class="panel-body">${projeto.descricao}</div>
        </div>

    </c:otherwise>
</c:choose>
