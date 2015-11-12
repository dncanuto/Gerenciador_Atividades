<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalCadSprint" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${operacao == "I" ? "Cadastrar Novo Sprint " : "Editar Sprint "}(${projeto.nome})</h4>
            </div>
            <div class="modal-body">
                <form id="frmCadSprint" class="" name="frmCad" method="post" action="salva-funcionario">
                    <div>        
                        <input type="hidden" name="operacao" value="${operacao}">
                        <input type="hidden" id="id" name="id" value="${sprint.id}">
                        <input type="hidden" id="projetoId" name="projetoId" value="${projeto.id}">
                    </div>
                    <div class="form-group">
                        <label for="nome">Nome do Sprint (Módulo de Desenvolvimento)</label>
                        <input type="text" id="nome" name="nome" class="form-control" value="${sprint.nome}">
                    </div>
                    <br>

                    <div class="form-group">
                        <label class="control-label" for="descricao">Descrição</label>
                        <textarea id="descricao" name="descricao" class="form-control" rows="5" maxlength="1000">
                            ${sprint.descricao}
                        </textarea>
                    </div>
                    <br>

                    <div class="form-group">
                        <label for="sitsprint">Situação Sprint</label>
                        <select name="sitsprint" class="form-control" id="sitsprint">
                            <option></option>
                            <c:forEach items="${situacoes}" var="stSprint">
                                <option value="${stSprint.id}" ${stSprint.id == sprint.sitsprint.id ? "selected" : ""}>${stSprint.label}</option>
                            </c:forEach> 
                        </select>
                        <br>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="salvarSprint()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>