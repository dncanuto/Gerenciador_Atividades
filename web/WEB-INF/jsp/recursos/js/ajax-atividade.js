//Classes
function Atividade()
{
    Atividade.id;
    Atividade.sitatividade;
    Atividade.sprint;
    Atividade.tpprioridade;
    Atividade.tptempoByTptempoconclusaoid;
    Atividade.tptempoByTptempoestimadoid;
    Atividade.nome;
    Atividade.dtcriacao;
    Atividade.descricao;
    Atividade.dtalteracao;
    Atividade.descconclusao;
    Atividade.funcionarioprojeto;
}

function Sprint()
{
    Sprint.id;
    Sprint.projeto;
    Sprint.sitsprint;
    Sprint.nome;
    Sprint.descricao;
    Sprint.dtcriacao;
    Sprint.dtalteracao;
    Sprint.atividades;
}

function Sitatividade()
{
    Sitatividade.id;
    Sitatividade.label;
    Sitatividade.order;
    Sitatividade.isAtivo;
    Sitatividade.atividades;
}

function Tpprioridade()
{
    Tpprioridade.id;
    Tpprioridade.label;
    Tpprioridade.order;
    Tpprioridade.isAtivo;
    Tpprioridade.atividades;
}

function Tptempo()
{
    Tptempo.id;
    Tptempo.label;
    Tptempo.order;
    Tptempo.isAtivo;
}

function Funcionarioprojeto()
{
    Funcionarioprojeto.id;
    Funcionarioprojeto.funcionario;
    Funcionarioprojeto.projeto;
    Funcionarioprojeto.isAdm;
    Funcionarioprojeto.dtcriacao;
    Funcionarioprojeto.dtalteracao;
    Funcionarioprojeto.isAtivo;
    Funcionarioprojeto.atividades;
}

function preparaObjeto()
{
    //inicializa objetos...
    var _atividade = new Atividade();
    var _sprint = new Sprint();
    var _tpPrioridade = new Tpprioridade();
    var _sitAtividade = new Sitatividade();
    var _tpTempoEstimado = new Tptempo();
    var _tpTempoConclusao = new Tptempo();
    var _funcionarioProjeto = new Funcionarioprojeto();

    //popula objetos relacionados...
    _sprint.id = parseInt($("#atividadeSprintId").val());
    _tpPrioridade.id = parseInt($("#tpprioridade").val());
    _sitAtividade.id = parseInt($("#sitatividade").val());
    _tpTempoEstimado.id = parseInt($("#tptempoByTptempoestimadoid").val());
    _tpTempoConclusao.id = parseInt($("#tptempoByTptempoconclusaoid").val());
    _funcionarioProjeto.id = parseInt($("#funcionarioProjetoId").val());

    //popula objeto principal..
    _atividade.id = parseInt($("#atividadeId").val());
    _atividade.nome = $("#atividadeNome").val();
    _atividade.descricao = $("#atividadeDescricao").val().trim();

    if ($("#dtcriacao").val()) {
        _atividade.dtcriacao = $("#dtcriacao").val();
    }

    _atividade.sprint = _sprint;
    _atividade.tpprioridade = _tpPrioridade;
    _atividade.sitatividade = _sitAtividade;
    _atividade.tptempoByTptempoestimadoid = _tpTempoEstimado;
    _atividade.funcionarioprojeto = _funcionarioProjeto;

    if (_sitAtividade.id === 3) {
        _atividade.tptempoByTptempoconclusaoid = _tpTempoConclusao;
        _atividade.descconclusao = $("#descconclusao").val().trim();
    }

    return _atividade;
}


//funções da atividade

function novaAtividade(sprintId)
{
    $.ajax({
        url: "nova-atividade-restrito?sprintId=" + sprintId,
        type: "POST",
        success: function (data) {
            $("#div-modal-atividade").html(data);
            $("#modalCadAtividade").modal("show");

            runAutocompleteAtividade();
        }
    });
}

function alterarAtividade(atividadeId)
{
    $.ajax({
        url: "alterar-atividade-restrito?atividadeId=" + atividadeId,
        type: "POST",
        success: function (data) {
            $("#div-modal-atividade").html(data);
            $("#modalCadAtividade").modal("show");

            runAutocompleteAtividade();
        }
    });
}

function salvarAtividade()
{
    var atividadeJson = JSON.stringify(preparaObjeto());
    var operacaoJson = $("#operacaoAtividade").val();

    $.ajax({
        url: "salvar-atividade",
        type: 'POST',
        data: {
            atividadeJson: atividadeJson,
            operacao: operacaoJson
        },
        dataType: 'json',
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadAtividade").modal("hide");
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

            refreshGridAtividade();
        }
    });
}

function refreshGridAtividade()
{
    $.ajax({
        type: "POST",
        url: "lista-atividade-restrito",
        success: function (data) {
            var div = $("#tbAtividade");
            div.html(data);
        }
    });
}

function setConclusao(situacao)
{
    if (situacao.value === "3")
        $("#aConcluida").removeClass("hidden");
    else {
        if (!$("#aConcluida").hasClass("hidden")) {
            $("#aConcluida").addClass("hidden");
            $("#tptempoByTptempoconclusaoid").val("");
            $("#descconclusao").val("");
        }
    }

    $("#modalCadAtividade").resize();
}

function runAutocompleteAtividade() {

    $('#search-funcionarios').autocomplete({
        serviceUrl: "get-funcionarios-projeto",
        minChars: 3,
        delimiter: ",",
        params: {
            projetoId: $("#atividadeProjetoId").val()
        },
        paramName: "funcName",
        transformResult: function (response) {

            return {
                suggestions: $.map($.parseJSON(response), function (item) {
                    return {value: item.tagName, data: item.tagId};
                })
            };
        },
        onSelect: function (suggestion) {

            $.ajax({
                url: "get-funcionario-atividade-restrito?funcionarioProjetoId=" + suggestion.data,
                type: "POST",
                success: function (data) {
                    $("#funcionario-atividade").html(data);
                }
            });
        }
    });
}

function removeFuncionarioAtividade()
{
    $.ajax({
        url: "remove-funcionario-atividade-restrito",
        type: "POST",
        success: function (data) {
            $("#funcionario-atividade").html(data);

            runAutocompleteAtividade();
        }
    });
}
