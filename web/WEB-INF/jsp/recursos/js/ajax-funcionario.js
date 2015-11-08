function alterarFuncionario(id)
{
    $.ajax({
        type: "POST",
        url: "altera-funcionario?id=" + id,
        success: function (data) {
            var div = $("#div-modal-funcionario");
            div.html(data);
            $("#modalCadFuncionario").modal("show");
        }
    });
}

function novoFuncionario()
{
    $.ajax({
        type: "POST",
        url: "novo-funcionario",
        success: function (data) {
            var div = $("#div-modal-funcionario");
            div.html(data);
            $("#modalCadFuncionario").modal("show");
        }
    });
}

function refreshFuncionarioGrid() {
    $.ajax({
        type: "POST",
        url: "lista-funcionario",
        success: function (data) {
            var div = $("#tbFuncionario");
            div.html(data);
        }
    });
}

function salvarFuncionario()
{
    //o código abaixo é para enviar TODO o form para o controller (servidor)
    var dataString = $("#frmCad").serialize();
    $.ajax({
        type: "POST",
        url: "salva-funcionario",
        data: dataString,
        dataType: "json",
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadFuncionario").modal("hide");
            }
            else {
                //limpa os erros    
                limpaErros();
                //preenche automaticamente os erros com os dados retorndos pelo controller    
                exibeErros(dados);
            }
        },
        error: function () {
            $("#status").html("Ocorreu um erro na gravação.");
        },
        beforeSend: function () {
            $('#btnSalvar').attr("disabled", true);
            $("#status").html("<b><i>Aguarde....</i></b>");
        },
        complete: function () {
            $('#btnSalvar').attr("disabled", false);
            $("#status").html("");

            refreshFuncionarioGrid();
        }

    });
}

