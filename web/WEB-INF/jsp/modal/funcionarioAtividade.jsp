<%-- 
    Document   : funcionarioProjeto
    Created on : 20/11/2015, 16:21:52
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${funcionario == null}">
        <div id="autocomplete">                       
            <div class="form-group">
                <input id="tagId" type="hidden" value="">
                <label class="control-label" for="w-input-search">Funcionário responsável</label>
                <input type="text" id="w-input-search" name="tagName" class="form-control" placeholder="Digite o nome do funcionário">                
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="BoxWhite">
            <input type="hidden" id="funcionarioId" name="funcionarioId" value="${funcionario.id}">
            <div>${funcionario.nome + " " + funcionario.sobrenome}</div>
            <div><small>${funcionario.email}</small></div>    
        </div>
    </c:otherwise>
</c:choose>



