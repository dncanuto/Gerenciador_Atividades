var imagemPerfil;

function Funcionario()
{
    Funcionario.id;
    Funcionario.tpcargo;
    Funcionario.nome;
    Funcionario.sobrenome;
    Funcionario.email;
    Funcionario.password;
    Funcionario.imgperfil;
    Funcionario.dtcriacao;
    Funcionario.isAtivo;
}

function Tpcargo()
{
    Tpcargo.id;
    Tpcargo.label;
    Tpcargo.order;
    Tpcargo.isAtivo;
}

function preencheFuncionario()
{
    var _funcionario = new Funcionario();
    var _tpCargo = new Tpcargo();

    _tpCargo.id = parseInt($("#funcionarioTpcargo").val());

    _funcionario.id = parseInt($("#funcionarioId").val());
    _funcionario.nome = $("#funcionarioNome").val();
    _funcionario.sobrenome = $("#funcionarioSobrenome").val();
    _funcionario.email = $("#funcionarioEmail").val();
    _funcionario.password = $("#funcionarioPassword").val();
    //_funcionario.imgperfil = imagemPerfil;    
    //_funcionario.dtcriacao = $("#funcionarioDtCriacao").val();
    _funcionario.isAtivo = $("#funcionarioIsAtivo").val();
    _funcionario.tpcargo = _tpCargo;
    
    if($("#funcionarioDtCriacao").val()){
        _funcionario.dtcriacao = $("#funcionarioDtCriacao").val();
    }

    return _funcionario;
}

function alterarFuncionario(id)
{
    $.ajax({
        type: "POST",
        url: "altera-funcionario-restrito?id=" + id,
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
        url: "novo-funcionario-restrito",
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
        url: "lista-funcionario-restrito",
        success: function (data) {
            var div = $("#tbFuncionario");
            div.html(data);
        }
    });
}

function salvarFuncionario()
{
    var funcionarioJson = preencheFuncionario();
    var funcionarioOperacao = $("#funcionarioOperacao").val();

    $.ajax({
        type: "POST",
        url: "salva-funcionario-restrito",
        data: {
            funcionarioJson: JSON.stringify(funcionarioJson),
            operacao: funcionarioOperacao,
            img: JSON.stringify(imagemPerfil)
        },
        dataType: "json",
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadFuncionario").modal("hide");
            }
            else {
                limpaErros();
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

function previewFile()
{
    var preview = document.querySelector('img');
    var file = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();

    reader.onloadend = function ()
    {
        preview.src = reader.result;
        imagemPerfil = reader.result;
    };

    if (file)
    {
        reader.readAsDataURL(file);
    }
    else
    {
        preview.src = "";
    }
}

function selecionaImg()
{
    $("#imgPerfil").click();
}





