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
    Atividade.atividadefuncionarios;
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

function preparaObjeto()
{
    //inicializa objetos...
    var _atividade = new Atividade();
    var _sprint = new Sprint();
    var _tpPrioridade = new Tpprioridade();
    var _sitAtividade = new Sitatividade();
    var _tpTempoEstimado = new Tptempo();
    var _tpTempoConclusao = new Tptempo();

    //popula objetos relacionados...
    _sprint.id = $("#sprintId").val();
    _tpPrioridade.id = $("#tpprioridade").val();
    _sitAtividade.id = $("#sitatividade").val();
    _tpTempoEstimado.id = $("#tptempoByTptempoestimadoid").val();
    _tpTempoConclusao.id = $("#tptempoByTptempoconclusaoid").val();

    //popula objeto principal..
    _atividade.sprint = _sprint;
    _atividade.tpprioridade = _tpPrioridade;
    _atividade.sitatividade = _sitAtividade;
    _atividade.tptempoByTptempoestimadoid = _tpTempoEstimado;
    _atividade.tptempoByTptempoconclusaoid = _tpTempoConclusao;

    _atividade.id = 1;//$("#id").val();
    _atividade.nome = "teste";//$("#AtividadeNome").val();
    _atividade.descricao = "teste";//$("#atividadeDescricao").val();
    _atividade.descconclusao = "teste";//$("#descconclusao").val();
    _atividade.dtcriacao = "2015/07/21";//$("#dtcriacao").val();
    _atividade.dtalteracao = "2015/07/21";//$("#dtalteracao").val();

    return _atividade;
}

//funções da atividade

function novaAtividade()
{
    $.ajax({
        url: "nova-atividade-restrito",
        type: "POST",
        success: function (data) {
            $("#div-modal-atividade").html(data);
            $("#modalCadAtividade").modal("show");
        }
    });
}

function salvarAtividade()
{
    debugger
    var _atividade = new Atividade();
    var _sprint = new Sprint();
    var _tpPrioridade = new Tpprioridade();
    var _sitAtividade = new Sitatividade();
    var _tpTempoEstimado = new Tptempo();
    var _tpTempoConclusao = new Tptempo();

    //popula objetos relacionados...
    _sprint.id = $("#sprintId").val();
    _tpPrioridade.id = $("#tpprioridade").val();
    _sitAtividade.id = $("#sitatividade").val();
    _tpTempoEstimado.id = $("#tptempoByTptempoestimadoid").val();
    _tpTempoConclusao.id = $("#tptempoByTptempoconclusaoid").val();

    //popula objeto principal..
    _atividade.sprint = _sprint;
    _atividade.tpprioridade = _tpPrioridade;
    _atividade.sitatividade = _sitAtividade;
    _atividade.tptempoByTptempoestimadoid = _tpTempoEstimado;
    _atividade.tptempoByTptempoconclusaoid = _tpTempoConclusao;

    _atividade.id = 1;//$("#id").val();
    _atividade.nome = "teste";//$("#AtividadeNome").val();
    _atividade.descricao = "teste";//$("#atividadeDescricao").val();
    _atividade.descconclusao = "teste";//$("#descconclusao").val();
    _atividade.dtcriacao = "2015/07/21";//$("#dtcriacao").val();
    _atividade.dtalteracao = "2015/07/21";//$("#dtalteracao").val();

    $.ajax({
        url: "salvar-atividade",
        contentType: 'application/json',
        type: 'POST',
        dataType: 'json',
        cache: false,
        processData: false,
        data: _atividade,
        success: function (data) {

        }
    });
}

