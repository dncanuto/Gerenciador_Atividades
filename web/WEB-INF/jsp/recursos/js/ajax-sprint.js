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
        url: "novo-sprint?projetoId=" + projetoId,
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
        url: "alterar-sprint?sprintId=" + sprintId + "&projetoId=" + projetoId,
        success: function (data) {
            $("#div-modal-sprint").html(data);            
            $("#modalCadSprint").modal("show");
        }
    });
}

function refreshSprintGrid() {
    $.ajax({
        type: "POST",
        url: "lista-sprint",
        success: function (data) {
            var div = $("#tbSprint");
            div.html(data);
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

    $.ajax({
        type: "POST",
        url: "salvar-sprint",
        data: dataForm,
        dataType: "json",
        success: function (dados) {
            if (dados.sucesso) {
                $("#modalCadSprint").modal("hide");
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
            
            refreshSprintGrid();
        }
    });
}

