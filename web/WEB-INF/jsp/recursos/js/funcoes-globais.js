function limpaErros() {
    $("span .ValidaErro").each(function () {
        $(this).html("");
        $(this).removeClass("ExibeErro");
        $(this).parent().removeClass("has-error");
    });
}

function exibeErros(dados) {
    $.each(dados.erros,
            function (key, value)
            {
                $("#" + key).attr('title', value);
                $("#" + key).addClass("ExibeErro");
                $("#" + key).parent().addClass("has-error");
            });

    showTooltip();
}

function showTooltip()
{
    $('[data-toggle="tooltip"]').tooltip(); 
}
