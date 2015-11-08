function novoProjeto()
{
    $.ajax({
        type: "POST",
        url: "novo-projeto",
        success: function (data) {
            var div = $("#div-modal-projeto");
            div.html(data);
            $("#modalCadProjeto").modal("show");

            teste();
        }
    });
}
function teste() {
    $('#w-input-search').autocomplete({
        serviceUrl: 'getTags',
        paramName: "tagName", // ?tagName='user input'
        delimiter: ",",
        transformResult: function (response) {debugger

            return {
                suggestions: $.map($.parseJSON(response), function (item) {
                    return {value: item.tagName, data: item.id};
                })

            };

        }
    });
}