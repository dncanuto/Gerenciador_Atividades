function limpaErros() {
    $("span").each(function () {
        $(this).html("");
    });
}

function exibeErros(dados) {
    $.each(dados.erros,
            function (key, value)
            {
                $("#" + key).html(value);
            });
}


