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

