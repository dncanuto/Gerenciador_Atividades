<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav navbar-left">
    <c:forEach items="${listaFuncProjeto}" var="f">

        <li>
            <a href="#">${f.tagName}</a>
            <a href="javascript:removeFuncDoProjeto(${f.tagId})" style="margin-left: 5px">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            </a>
        </li>      

    </c:forEach>
</ul>

