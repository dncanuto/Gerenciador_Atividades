

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

function refreshListaProjeto()
{
    $.ajax({
        type: "POST",
        url: "lista-projeto-restrito",
        success: function (data) {
            var div = $("#tbProjeto");
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

    $.ajax({
        type: "POST",
        url: "salvar-projeto-restrito",
        data: dataForm,
        dataType: "json",
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadProjeto").modal("hide");
                refreshListaProjeto();
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

