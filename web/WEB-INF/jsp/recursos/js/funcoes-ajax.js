function preencheFuncionario()
{
    $.ajax({
        type: "POST",
        url: "dados-funcionario",
        success: function (data) {

            var div = $("#div-modal-funcionario");
            div.html(data);
        }
    });
}

function alterar(id)
{
    $.ajax({
        type: "POST",
        url: "altera-funcionario",
        data: "id" + id,
        success: function (data) {

            var div = $("#frmCad");
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
                $("#btnFechar").click();

                $('#frmCad').each(function () {
                    this.reset();
                });
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

                /*
                 if (dados.erros["erroCodigo"])
                 {
                 var erroCodigo = document.getElementById("erroCodigo");
                 erroCodigo.innerHTML = dados.erros["erroCodigo"];
                 }
                 
                 if (dados.erros["erroNome"])
                 {
                 var erroNome = $("#erroNome");
                 erroNome.html(dados.erros["erroNome"]);
                 }
                 */
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
        }

    });
}

