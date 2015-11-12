<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table-bordered table-responsive table-condensed">
    <tr>
        
        <th>ID</th>
        <th>Nome</th>
        <th>Cargo</th>
        <th>Opções</th>
    </tr>
    <c:forEach items="${lista}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.nome}</td>
            <td>${f.tpcargo.label}</td>
            <td>
                <a href="javascript:alterarFuncionario(${f.id})"><span class="glyphicon-edit"></span></a>
            </td>
        </tr>
    </c:forEach>
</table>
