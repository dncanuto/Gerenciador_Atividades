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
                        <input type="hidden" id="operacao" name="operacao" value="${operacao}">
                        <input type="hidden" id="atividadeId" name="id" value="${atividade.id}">
                        <input type="hidden" id="sprintId" name="sprintId" value="${sprint.id}">
                        <input type="hidden" id="projetoId" name="projetoId" value="${sprint.projeto.id}">
                    </div>

                    <div class="form-group col-lg-12">
                        <label for="atividadeNome">Nome da Atividade</label>
                        <input type="text" id="atividadeNome" name="atividadeNome" class="form-control" value="${atividade.nome}">
                    </div>

                    <div>
                        <div class="form-group col-lg-6">
                            <label for="tpprioridade">Tipo de Prioridade</label>
                            <select name="tpprioridade" class="form-control" id="tpprioridade">
                                <option></option>
                                <c:forEach items="${listaPrioridade}" var="itemPrioridade">
                                    <option value="${itemPrioridade.id}" ${itemPrioridade.id == atividade.tpprioridade.id ? "selected" : ""}>${itemPrioridade.label}</option>
                                </c:forEach> 
                            </select>                        
                        </div>

                        <div class="form-group col-lg-6">
                            <label for="tptempoByTptempoestimadoid">Tempo estimado <small>(aproximado)</small></label>
                            <select name="tptempoByTptempoestimadoid" class="form-control" id="tptempoByTptempoestimadoid">
                                <option></option>
                                <c:forEach items="${listaTempo}" var="tempo">
                                    <option value="${tempo.id}" ${tempo.id == atividade.tptempoByTptempoestimadoid.id ? "selected" : ""}>${tempo.label}</option>
                                </c:forEach> 
                            </select>                        
                        </div>
                    </div>

                    <div class="form-group col-lg-12">
                        <label class="control-label" for="atividadeDescricao">Descrição</label>
                        <textarea id="atividadeDescricao" name="descricao" class="form-control" rows="4" maxlength="100">
                            ${atividade.descricao}
                        </textarea>
                    </div>

                    <div id="funcionario-atividade" class="form-group col-lg-12">
                        <%@include file="funcionarioAtividade.jsp" %>
                    </div>

                    <div class="form-group col-lg-12">
                        <label for="sitatividade">Situação da Atividade</label>
                        <select name="sitatividade" class="form-control" id="sitatividade" onchange="setConclusao(this)">
                            <option></option>
                            <c:forEach items="${listaSituacao}" var="stAtividade">
                                <option value="${stAtividade.id}" ${stAtividade.id == atividade.sitatividade.id ? "selected" : ""}>${stAtividade.label}</option>
                            </c:forEach> 
                        </select>
                    </div>

                    <div id="aConcluida" class="${atividade.sitatividade.id == "3" ? "" : "hidden"}">
                        <div class="form-group col-lg-12">
                            <label for="tptempoByTptempoconclusaoid">Tempo de conclusão <small>(aproximado)</small></label>
                            <select name="tptempoByTptempoconclusaoid" class="form-control" id="tptempoByTptempoconclusaoid">
                                <option></option>
                                <c:forEach items="${listaTempo}" var="tempo">
                                    <option value="${tempo.id}" ${tempo.id == atividade.tptempoByTptempoconclusaoid.id ? "selected" : ""}>${tempo.label}</option>
                                </c:forEach> 
                            </select>
                        </div>

                        <div class="form-group col-lg-12">
                            <label class="control-label" for="descconclusao">Observaões conslusão</label>
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
