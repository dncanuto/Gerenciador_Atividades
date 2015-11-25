<%-- 
    Document   : sprints-projeto
    Created on : 25/11/2015, 13:05:49
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${projeto != null}">    

    <div class="panel panel-primary">
        
        <div class="panel-heading">
            <h3 class="panel-title">Sprints (Modulos de desenvolvimento) cadastrados

                <a href="javascript:novoSprint(${projeto.id})" class="linkProjeto pull-right">
                    <span class="glyphicon glyphicon-plus">Clique aqui para adicionar um novo sprint</span>
                </a>

            </h3>
        </div>

        <!-- Table -->
        <div id="tb-sprint-projeto">
            <%@include file="gridSprint.jsp" %>            
        </div>
    </div>

</c:if>
