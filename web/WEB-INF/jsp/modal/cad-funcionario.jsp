<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalCadFuncionario" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${operacao == "I" ? "Cadastrar Novo Funcionário" : "Editar Funcionário"}</h4>
            </div>
            <div class="modal-body">
                <form id="frmCad" class="" name="frmCad" method="post" action="salva-funcionario">
                    <div>        
                        <input type="hidden" name="operacao" value="${operacao}">
                        <input type="hidden" name="id" value="${funcionario.id}">
                    </div>
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" id="nome" name="nome" class="form-control" value="${funcionario.nome}">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="sobrenome">Sobrenome</label>
                        <input type="text" id="sobrenome" name="sobrenome" class="form-control" value="${funcionario.sobrenome}">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" name="email" class="form-control" value="${funcionario.email}">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="password">Senha de acesso</label>
                        <input type="text" id="password" name="password" class="form-control" value="${funcionario.password}">
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="tpcargo">Cargo</label>
                        <select name="tpcargo" class="form-control" id="tpcargo">
                            <option></option>
                            <c:forEach items="${Cargos}" var="cargo">
                                <option value="${cargo.id}" ${cargo.id == funcionario.tpcargo.id ? "selected" : ""}>${cargo.label}</option>
                            </c:forEach> 
                        </select>
                        <br>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="salvarFuncionario()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>
