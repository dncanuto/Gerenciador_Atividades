<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Funcionário</h4>
            </div>
            <div class="modal-body">
                <form id="frmCad" name="frmCad" method="post" action="salva-funcionario">
                    <div>        
                        <input type="hidden" name="id" value="${funcionario.id}">
                    </div>
                    <div>
                        <label for="nome">Nome</label>
                        <input type="text" id="nome" name="nome" value="${funcionario.nome}">
                    </div>
                    <br>
                    <div>
                        <label for="sobrenome">Sobrenome</label>
                        <input type="text" id="sobrenome" name="sobrenome" value="${funcionario.sobrenome}">
                    </div>
                    <br>
                    <div>
                        <label for="email">E-mail</label>
                        <input type="email" id="email" name="email" value="${funcionario.email}">
                    </div>
                    <br>
                    <div>
                        <label for="password">Senha de acesso</label>
                        <input type="text" id="password" name="password" value="${funcionario.password}">
                    </div>
                    <br>
                    <div>
                        <label for="tpcargo">Cargo</label>
                        <select name="tpcargo" class="form-control" id="tpcargo">
                            <option></option>
                            <c:forEach items="${Cargos}" var="cargo">
                                <option value="${cargo.id}">${cargo.label}</option>
                            </c:forEach> 
                        </select>
                        <br>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="salva()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>
