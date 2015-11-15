<%-- 
    Document   : cad-projeto
    Created on : 08/11/2015, 11:15:15
    Author     : Daniel
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalCadProjeto" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${operacao == "I" ? "Cadastrar Novo Projeto" : "Editar Projeto"}</h4>
            </div>
            <div class="modal-body" style="height: 300px;">
                <form id="frmCadProjeto" class="" name="frmCad" method="post" action="salva-funcionario">
                    <div>        
                        <input type="hidden" name="operacao" value="${operacao}">
                        <input type="hidden" name="id" value="${projeto.id}">
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="nome">Nome do Projeto</label>
                        <input id="nome" name="nome" class="form-control" value="${projeto.nome}">
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="descricao">Descrição</label>
                        <textarea id="descricao" name="descricao" class="form-control" rows="5" maxlength="500">
                            ${projeto.descricao}
                        </textarea>
                    </div>

                    <div id="autocomplete" class="form-group">
                        <label class="control-label" for="nome">Funcionário(s):</label>
                        <div class="form-inline">
                            <input id="tagId" type="hidden" value="">
                            <input type="text" id="w-input-search" name="tagName" class="form-control" placeholder="Digite o nome do funcionário">
                            <button id="addFunc" type="button" class="btn btn-info btn-sm" onclick="addFuncToProjeto()" disabled>
                                <span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
                                Adicionar Funcionário
                            </button>
                        </div>
                    </div>

                    <div id="list-funcionario-projeto">
                        <%@include file="listFuncionarioProjeto.jsp" %>
                    </div>
                    <br>  

                </form>
            </div>
            <br>

            <div class="modal-footer" style="margin-top: 50px;">
                <button type="button" class="btn btn-primary" onclick="salvarProjeto()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>

