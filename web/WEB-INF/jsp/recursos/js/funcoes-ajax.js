function alterarFuncionario(id)
{
    $.ajax({
        type: "POST",
        url: "altera-funcionario?id=" + id,
        success: function (data) {
            var div = $("#div-modal-funcionario");
            div.html(data);
            $("#myModal").modal("show");
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
            $("#myModal").modal("show");
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

function salva()
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


            }
            else {
                //limpa os erros    
                $("span").each(function () {
                    $(this).html("");
                });
                //preenche automaticamente os erros com os dados retorndos pelo controller    
                $.each(dados.erros,
                        function (key, value)
                        {
                            $("#" + key).html(value);
                        });
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
            $("#myModal").modal("hide");            

            refreshFuncionarioGrid();
        }

    });
}

