function sprint() {
    sprint.id;
    sprint.nome;
    sprint.descricao;
    sprint.projeto;
    sprint.sitsprint;
}

function sitSprint() {
    sitSprint.id;
}

function projeto() {
    projeto.id;
    projeto.sitprojeto;
    projeto.nome;
    projeto.descricao;
}

function novoSprint(projetoId)
{
    $.ajax({
        type: "POST",
        url: "novo-sprint-restrito?projetoId=" + projetoId,
        success: function (data) {
            $("#div-modal-sprint").html(data);            
            $("#modalCadSprint").modal("show");
        }
    });
}

function alterarSprint(sprintId, projetoId)
{
    $.ajax({
        type: "POST",
        url: "alterar-sprint-restrito?sprintId=" + sprintId + "&projetoId=" + projetoId,
        success: function (data) {
            $("#div-modal-sprint").html(data);            
            $("#modalCadSprint").modal("show");
        }
    });
}

function refreshSprint(projetoId) {
    $.ajax({
        type: "POST",
        url: "lista-sprint-restrito?projetoId="+projetoId,
        success: function (data) {
            var div = $("#tb-sprint-projeto");
            div.html(data);
        }
    });
}

function getAtividadesSprint(sprintId)
{
    $.ajax({
        type: "POST",
        url: "get-atividades-sprint?sprintId="+sprintId,        
        success: function (data) {
            $("#atividades-sprint").html(data);
        }
    });
}

function salvarSprint()
{    
    /*var _projeto = new projeto();
    _projeto.id = parseInt($("#projetoId").val());
    
    var _sitSprint = new sitSprint();
    _sitSprint.id = parseInt($("#sitsprint").val());
    
    var _sprint = new sprint();
    _sprint.id = parseInt($("#id").val());
    _sprint.nome = $("#nome").val();
    _sprint.descricao = $("#descricao").val();
    _sprint.sitsprint = _sitSprint;
    _sprint.projeto = _projeto; */
    
    
    var dataForm = $("#frmCadSprint").serialize();//JSON.stringify(_sprint); 
    var projetoId = $("#sprintProjetoId").val();

    $.ajax({
        type: "POST",
        url: "salvar-sprint-restrito",
        data: dataForm,
        dataType: "json",
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadSprint").modal("hide");  
                refreshSprint(projetoId);
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
        }
    });
}

