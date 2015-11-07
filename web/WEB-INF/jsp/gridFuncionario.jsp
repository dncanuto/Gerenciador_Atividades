<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Opções</th>
    </tr>
    <c:forEach items="${lista}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.nome}</td>
            <td>
                <a href="javascript:alterarFuncionario(${f.id})">Alterar</a>
            </td>
        </tr>
    </c:forEach>
</table>
