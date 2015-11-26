<%-- 
    Document   : cad-atividade
    Created on : 15/11/2015, 12:42:50
    Author     : Daniel
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="modalCadAtividade" class="modal fade" role="dialog">

    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${operacao == "I" ? "Cadastrar Nova Atividade " : "Editar Atividade "}<small>(${sprint.nome})</small></h4>
            </div>

            <div class="modal-body">

                <form id="frmCadAtividade" name="frmCadAtividade" method="post" action="salva-atividade">

                    <div class="hidden">        
                        <input type="hidden" id="operacaoAtividade" name="operacaoAtividade" value="${operacao}">
                        <input type="hidden" id="atividadeId" name="atividadeId" value="${atividade.id}">
                        <input type="hidden" id="atividadeSprintId" name="atividadeSprintId" value="${sprint.id}">
                        <input type="hidden" id="atividadeProjetoId" name="atividadeProjetoId" value="${sprint.projeto.id}">
                    </div>

                    <div class="form-group col-lg-12">
                        <label class="control-label" for="atividadeNome">Nome da Atividade</label>
                        <span id="erroAtividadeNome" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <input type="text" id="atividadeNome" name="atividadeNome" class="form-control" value="${atividade.nome}" ${operacao eq "U"? "disabled" : ""}>
                    </div>

                    <div>
                        <div class="form-group col-lg-6">
                            <label class="control-label" for="tpprioridade">Tipo de Prioridade</label>
                            <span id="erroTpPrioridade" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                            <select name="tpprioridade" class="form-control" id="tpprioridade" ${operacao eq "U"? "disabled" : ""}>
                                <option></option>
                                <c:forEach items="${listaPrioridade}" var="itemPrioridade">
                                    <option value="${itemPrioridade.id}" ${itemPrioridade.id == atividade.tpprioridade.id ? "selected" : ""}>${itemPrioridade.label}</option>
                                </c:forEach> 
                            </select>                        
                        </div>

                        <div class="form-group col-lg-6">
                            <label class="control-label" for="tptempoByTptempoestimadoid">Tempo estimado <small>(aproximado)</small></label>
                            <span id="erroTempoEstimado" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                            <select name="tptempoByTptempoestimadoid" class="form-control" id="tptempoByTptempoestimadoid" ${operacao eq "U"? "disabled" : ""}>
                                <option></option>
                                <c:forEach items="${listaTempo}" var="tempo">
                                    <option value="${tempo.id}" ${tempo.id == atividade.tptempoByTptempoestimadoid.id ? "selected" : ""}>${tempo.label}</option>
                                </c:forEach> 
                            </select>                        
                        </div>
                    </div>

                    <div class="form-group col-lg-12">
                        <label class="control-label" for="atividadeDescricao">Descrição</label>
                        <span id="erroAtividadeDescricao" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <textarea id="atividadeDescricao" name="descricao" class="form-control" rows="4" maxlength="100">
                            ${atividade.descricao}
                        </textarea>
                    </div>

                    <div id="funcionario-atividade" class="form-group col-lg-12">
                        <%@include file="funcionarioAtividade.jsp" %>
                    </div>

                    <div class="form-group col-lg-12">
                        <label class="control-label" for="sitatividade">Situação da Atividade</label>
                        <span id="erroSitAtividade" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                        <select name="sitatividade" class="form-control" id="sitatividade" onchange="setConclusao(this)">
                            <option></option>
                            <c:forEach items="${listaSituacao}" var="stAtividade">
                                <option value="${stAtividade.id}" ${stAtividade.id == atividade.sitatividade.id ? "selected" : ""}>${stAtividade.label}</option>
                            </c:forEach> 
                        </select>
                    </div>

                    <div id="aConcluida" class="${atividade.sitatividade.id == "3" ? "" : "hidden"}">
                        <div class="form-group col-lg-12">
                            <label class="control-label" for="tptempoByTptempoconclusaoid">Tempo de conclusão <small>(aproximado)</small></label>
                            <span id="erroTempoConclusao" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                            <select name="tptempoByTptempoconclusaoid" class="form-control" id="tptempoByTptempoconclusaoid">
                                <option></option>
                                <c:forEach items="${listaTempo}" var="tempo">
                                    <option value="${tempo.id}" ${tempo.id == atividade.tptempoByTptempoconclusaoid.id ? "selected" : ""}>${tempo.label}</option>
                                </c:forEach> 
                            </select>
                        </div>

                        <div class="form-group col-lg-12">
                            <label class="control-label" for="descconclusao">Observaões conslusão</label>
                            <span id="erroDescricaoConclusao" class="glyphicon glyphicon-alert ValidaErro" data-toggle="tooltip" data-placement="right" title=""></span>
                            <textarea id="descconclusao" name="descconclusao" class="form-control" rows="5" maxlength="500">
                                ${atividade.descconclusao}
                            </textarea>
                        </div>
                    </div>

                </form>
            </div>                            
            <br><br>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="salvarAtividade()" id="btnSalvar" >Salvar</button> &nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default" id="btnFechar" data-dismiss="modal">Fechar</button>
            </div>
        </div>

    </div>
</div>
