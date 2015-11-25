<%-- 
    Document   : funcionarioProjeto
    Created on : 20/11/2015, 16:21:52
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${funcProjeto == null}">
        <div id="autocomplete-funcionario">                       
            <div>                
                <label class="control-label" for="search-funcionarios">Funcionário responsável</label>
                <input type="text" id="search-funcionarios" name="funcName" class="form-control" placeholder="Digite o nome do funcionário" >                
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div style="margin-top: 5px;" class="BoxWhite">
            <div class="pull-right">
                <a href="javascript:removeFuncionarioAtividade()" style="color: red;" data-toggle="tooltip" data-placement="top" title="Remover Funcionário!">
                    <span class="glyphicon glyphicon-remove"></span>
                </a>
            </div>

            <input type="hidden" id="funcionarioProjetoId" name="funcionarioProjetoId" value="${funcProjeto.id}">

            <div class="row">
                <div class="col-xs-3 col-md-3">                    
                    <img style="max-height: 50px" class="img-responsive img-rounded" src="${funcProjeto.funcionario.imgperfil}" alt="...">
                </div>  

                <div>${funcProjeto.funcionario.nome} ${funcProjeto.funcionario.sobrenome}</div>

                <div><small>${funcProjeto.funcionario.email}</small></div> 
            </div>
        </div>
    </c:otherwise>
</c:choose>



