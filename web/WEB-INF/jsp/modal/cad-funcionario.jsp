<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="modalCadFuncionario" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${operacao == "I" ? "Cadastrar Novo Funcionário" : "Editar Funcionário"}</h4>
            </div>
            <div class="modal-body">
                <form id="frmCad" class="" name="frmCad" method="post" action="salva-funcionario" autocomplete="off">

                    <div class="hidden">        
                        <input type="hidden" id="funcionarioOperacao" name="funcionarioOperacao" value="${funcionarioOperacao}">
                        <input type="hidden" id="funcionarioId" name="funcionarioId" value="${funcionario.id}">
                        <input type="file" id="imgPerfil" name="imgPerfil" onchange="previewFile()">
                        <input type="hidden" id="funcionarioIsAtivo" value="${funcionario.isAtivo}">

                        <fmt:parseDate value="${funcionario.dtcriacao}" var="dataConvertida" type="date" pattern="yyyy-mm-dd"/>
                        <fmt:formatDate pattern="dd/mm/yyyy" value="${dataConvertida}" var="dataFormatada" type="date"/>
                        <input type="hidden" id="funcionarioDtCriacao" value="${funcionario.dtcriacao}">
                    </div>
                    
                    <div class="col-lg-12">

                        <div class="col-lg-4 text-center">                            
                            <img id="imgPreview" src="${funcionario.imgperfil}" alt="" class="img-responsive img-rounded">                            
                            <span id="erroImg"></span>
                            <br>
                            <a href="javascript:selecionaImg()">Adicionar imagem</a>
                        </div>

                        <div class="col-lg-8">
                            <div class="form-group">
                                <label for="funcionarioNome">Nome</label>
                                <span id="erroNome" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                                <input type="text" id="funcionarioNome" name="funcionarioNome" class="form-control" value="${funcionario.nome}">                                
                            </div>

                            <div class="form-group">
                                <label for="funcionarioSobrenome">Sobrenome</label>
                                <span id="erroSobrenome" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                                <input type="text" id="funcionarioSobrenome" name="funcionarioSobrenome" class="form-control" value="${funcionario.sobrenome}">                                
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-lg-12">
                        <label for="funcionarioEmail">E-mail</label>
                        <span id="erroEmail" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <input type="email" id="funcionarioEmail" name="funcionarioEmail" class="form-control" value="${funcionario.email}" autocomplete="off">                        
                    </div>


                    <div class="form-group col-lg-12">
                        <label for="funcionarioPassword">Senha de acesso</label>
                        <span id="erroPassword" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <input type="password" id="funcionarioPassword" name="funcionarioPassword" class="form-control" value="${funcionario.password}" autocomplete="off">
                    </div>


                    <div class="form-group col-lg-12">
                        <label for="funcionarioTpcargo">Cargo</label>
                        <span id="erroTpCargo" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <select name="funcionarioTpcargo" class="form-control" id="funcionarioTpcargo">
                            <option></option>
                            <c:forEach items="${Cargos}" var="cargo">
                                <option value="${cargo.id}" ${cargo.id == funcionario.tpcargo.id ? "selected" : ""}>${cargo.label}</option>
                            </c:forEach> 
                        </select>                        
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
