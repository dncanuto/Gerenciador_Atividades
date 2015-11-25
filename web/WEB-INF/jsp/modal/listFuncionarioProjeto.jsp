<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="list-inline">
    <c:forEach items="${listaFuncProjeto}" var="f">

        <li style="margin-bottom: 10px;" class="list-group-item list-group-item-success"> 
            
            ${f.tagName}
            
            <a href="javascript:removeFuncDoProjeto(${f.tagId}, ${projeto == null ? "0" : projeto.id})" style="margin-left: 3px">
                <span class="glyphicon glyphicon-remove" aria-hidden="true" data-toggle="tooltip" data-placement="right" title="Remover Funcionário"></span>
            </a>
        </li>      

    </c:forEach>
</ul>

