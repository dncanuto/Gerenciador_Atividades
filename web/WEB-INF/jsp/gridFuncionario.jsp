

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
                <a href="javascript:alterar(${f.id})">Alterar</a>
            </td>
        </tr>
    </c:forEach>
</table>
