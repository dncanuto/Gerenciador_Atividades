

function novoProjeto()
{
    $.ajax({
        type: "POST",
        url: "novo-projeto-restrito",
        success: function (data) {
            var div = $("#div-modal-projeto");
            div.html(data);
            $("#modalCadProjeto").modal("show");

            runAutocomplete();            
        }
    });
}

function refreshProjeto(projetoId)
{
    $.ajax({
        type: "POST",
        url: "get-projeto?projetoId="+projetoId,
        success: function (data) {
            var div = $("#dadosProjeto");
            div.html(data);
        }
    });
}

function alterarProjeto(id)
{
    $.ajax({
        type: "POST",
        url: "alterar-projeto-restrito?id=" + id,
        success: function (data) {
            var div = $("#div-modal-projeto");
            div.html(data);
            $("#modalCadProjeto").modal("show");

            runAutocomplete();       
            showTooltip();
        }
    });
}

function addFuncToProjeto()
{
    var tagId = $("#tagId").val();
    var tagName = $("#w-input-search").val();
    $.ajax({
        type: "POST",
        url: "add-func-projeto-restrito?tagId=" + tagId + "&tagName=" + tagName,
        success: function (data) {
            $("#list-funcionario-projeto").html(data);
            $("#autocomplete input:text").val("");
            $('#addFunc').attr("disabled", true); 
            
            $("#modalCadProjeto").resize();
            showTooltip();
        }
    });
}

function removeFuncDoProjeto(funcionarioId, projetoId)
{
    $.ajax({
        type: "POST",
        url: "remove-func-projeto-restrito?id=" + funcionarioId + "&projetoId=" + projetoId,
        success: function (data) {
            $("#list-funcionario-projeto").html(data);
            $("#autocomplete input:text").val("");
            $('#addFunc').attr("disabled", true);
            
            showTooltip();
        }
    });
}

function runAutocomplete() {
    $('#w-input-search').autocomplete({
        serviceUrl: 'getTags',
        paramName: "tagName", // ?tagName='user input'
        minChars: 3,
        delimiter: ",",
        transformResult: function (response) {

            return {
                suggestions: $.map($.parseJSON(response), function (item) {
                    return {value: item.tagName, data: item.tagId};
                })
            };
        },
        onSelect: function (suggestion) {
            $("#tagId").val(suggestion.data);
            $('#addFunc').attr("disabled", false);
        }
    });
}

function salvarProjeto()
{   
    var dataForm = $("#frmCadProjeto").serialize();
    var projetoId = $("#projetoId").val();

    $.ajax({
        type: "POST",
        url: "salvar-projeto-restrito",
        data: dataForm,
        dataType: "json",
        success: function (dados) {debugger
            if (dados.sucesso) {
                $("#modalCadProjeto").modal("hide");
                
                if(dados.projetoId){
                    projetoId = dados.projetoId;
                }
                
                refreshProjeto(projetoId);   
                refreshDivSprint(projetoId);
            }
            else {                   
                limpaErros();                  
                exibeErros(dados);
            }
        },        
        beforeSend: function () {
            $('#btnSalvar').attr("disabled", true);            
        },
        complete: function () {
            $('#btnSalvar').attr("disabled", false);            
        }
    });
}

function refreshDivSprint(projetoId)
{
    $.ajax({
        type: "POST",
        url: "get-sprints-projeto-restrito?projetoId="+projetoId,
        success: function (data) {
            $("#sprints-projeto").html(data);
        }
    });
}

