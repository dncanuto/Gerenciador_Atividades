<%-- 
    Document   : atividades-projeto
    Created on : 25/11/2015, 14:13:04
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="sprintAtividade" value="${sprintAtividade}">

<c:if test="${listaAtividade != null}">    

    <div class="panel panel-primary">
        
        <div class="panel-heading">
            <h3 class="panel-title">Atividades do Sprint ${sprintAtividade.nome}

                <a href="javascript:novaAtividade(${sprintAtividade.id})" class="linkProjeto pull-right">
                    <span class="glyphicon glyphicon-plus">Clique aqui para adicionar uma nova atividade para o sprint</span>
                </a>

            </h3>
        </div>

        <!-- Table -->
        <div id="tb-atividades-projeto">
            <%@include file="gridAtividade.jsp" %>            
        </div>
    </div>

</c:if>
