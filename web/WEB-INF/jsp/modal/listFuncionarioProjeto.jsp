<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-pills">
    <c:forEach items="${listaFuncProjeto}" var="f">

        <li>            
            <a href="javascript:removeFuncDoProjeto(${f.tagId}, ${projeto.id})" style="margin-left: 3px">
                ${f.tagName}<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </a>
        </li>      

    </c:forEach>
</ul>

