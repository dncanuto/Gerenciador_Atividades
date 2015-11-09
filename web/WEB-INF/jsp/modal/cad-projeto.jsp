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
                    <div id="autocomplete" class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" id="w-input-search" name="nome" class="form-control" placeholder="Digite o nome do funcionário">                        
                    </div>
                    <br>                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="salvarFuncionario()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>

