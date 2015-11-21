<%-- 
    Document   : funcionarioProjeto
    Created on : 20/11/2015, 16:21:52
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${f == null}">
        <div id="autocomplete-funcionario">                       
            <div>
                <input id="func-projeto-id" type="hidden" value="">
                <label class="control-label" for="search-funcionarios">Funcionário responsável</label>
                <input type="text" id="search-funcionarios" name="funcName" class="form-control" placeholder="Digite o nome do funcionário" >                
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="BoxWhite">
            <input type="hidden" id="funcionarioId" name="funcionarioId" value="${f.id}">
            <div>${f.nome}</div>
            <div><small>${f.email}</small></div>    
        </div>
    </c:otherwise>
</c:choose>



