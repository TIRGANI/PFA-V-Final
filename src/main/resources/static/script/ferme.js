$(document)
    .ready(
        function () {
            table = $('#tproduit')
                .DataTable({
                    ajax: {
                        url: "ferme/all",
                        dataSrc: ''
                    },
                    columns: [{
                        data: "id"
                    },
                        {
                            data: "numParcel"
                        },
                        {
                            data: 'photo',
                            "render": function (data, type, row, meta) {
                                return '<img src="' + data + '" alt="' + data + '"height="16" width="16"/>';

                            }
                        },
                        {
                            "render": function () {
                                return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
                            }
                        },
                        {
                            "render": function () {
                                return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
                            }
                        }
                    ]

                });

            $('#btn').click(
                function () {
                    $.ajax({
                        url: "/userid",
                        type: "GET",
                        success: function (userid) {
                            var nbrparcelle = $("#nbrparcelle");
                            if ($('#btn').text() == 'Add') {
                                //upload file
                                var file = $('#photo')[0].files[0]
                                var fd = new FormData();
                                fd.append('file', file);
                                $.ajax({
                                    url: '/load-ferme',
                                    type: 'POST',
                                    processData: false,
                                    contentType: false,
                                    data: fd,
                                    success: function (photo, status, jqxhr) {

                                        var p = {
                                            numParcel: nbrparcelle.val(),
                                            photo: photo,
                                            user: {
                                                userId: userid
                                            }
                                        };
                                        $.ajax({
                                            url: 'ferme/saves',
                                            contentType: "application/json",
                                            dataType: "json",
                                            data: JSON.stringify(p),
                                            type: 'POST',
                                            async: true,
                                            success: function (data, textStatus,
                                                               jqXHR) {
                                                table.ajax.reload();
                                            },
                                            error: function (jqXHR, textStatus,
                                                             errorThrown) {
                                                console.log(textStatus);
                                            }
                                        });

                                        //  table.ajax.reload();
                                    },
                                    error: function (jqxhr, status, msg) {
                                        //error code
                                    }
                                });


                            }
                            $("#main-content").load(
                                "./page/ferme.html");

                        }
                    });
                });

            $('#table-content')
                .on(
                    'click',
                    '.supprimer',
                    function () {

                        var id = $(this).closest('tr').find(
                            'td').eq(0).text();
                        var oldLing = $(this).closest('tr')
                            .clone();
                        var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">' +
                            id +
                            '</th><td colspan="6" style="height: 100%;">';
                        newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette ferme ? </h4>';
                        newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
                        newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

                        $(this).closest('tr').replaceWith(
                            newLigne);
                        $('.annuler').click(
                            function () {
                                $(this).closest('tr')
                                    .replaceWith(
                                        oldLing);
                            });
                        $('.confirmer')
                            .click(
                                function (e) {
                                    e.preventDefault();
                                    $
                                        .ajax({
                                            url: 'ferme/delete/' +
                                                id,
                                            data: {},
                                            type: 'DELETE',
                                            async: false,
                                            success: function (
                                                data,
                                                textStatus,
                                                jqXHR) {
                                                if (data
                                                    .includes("error") == true) {
                                                    $(
                                                        "#error")
                                                        .modal();
                                                } else {
                                                    table.ajax
                                                        .reload();
                                                }
                                            },
                                            error: function (
                                                jqXHR,
                                                textStatus,
                                                errorThrown) {
                                                $(
                                                    "#error")
                                                    .modal();
                                            }
                                        });

                                });

                    });

            $('#table-content').on(
                'click',
                '.modifier',
                function () {
                    var btn = $('#btn');
                    var id = $(this).closest('tr').find('td').eq(0)
                        .text();
                    ;
                    var code = $(this).closest('tr').find('td').eq(
                        1).text();
                    var nom = $(this).closest('tr').find('td')
                        .eq(2).text();
                    var prix = $(this).closest('tr').find('td').eq(
                        4).text();
                    var dateAchat = $(this).closest('tr')
                        .find('td').eq(3).text().replace(" ",
                            "T");
                    btn.text('Modifier');
                    $("#code").val(code);
                    $("#nom").val(nom);
                    $("#id").val(id);
                    $("#prix").val(prix);
                    $("#date").val(dateAchat);
                    btn.click(function (e) {
                        e.preventDefault();
                        var p = {
                            id: $("#id").val(),
                            code: $("#code").val(),
                            nom: $("#nom").val(),
                            dateAchat: $("#date").val(),
                            prix: $("#prix").val()
                        };
                        if ($('#btn').text() == 'Modifier') {
                            $.ajax({
                                url: 'ferme/save',
                                contentType: "application/json",
                                dataType: "json",
                                data: JSON.stringify(p),
                                type: 'POST',
                                async: false,
                                success: function (data,
                                                   textStatus, jqXHR) {
                                    table.ajax.reload();
                                    $("#code").val('');
                                    $("#nom").val('');
                                    btn.text('Add');
                                },
                                error: function (jqXHR, textStatus,
                                                 errorThrown) {
                                    console.log(textStatus);
                                }
                            });
                            $("#main-content").load(
                                "./page/ferme.html");
                        }
                    });
                });

            // function remplir(data) {
            // var contenu = $('#table-content');
            // var ligne = "";
            // for (i = 0; i < data.length; i++) {
            // ligne += '<tr><th scope="row">' + data[i].id + '</th>';
            // ligne += '<td>' + data[i].code + '</td>';
            // ligne += '<td>' + data[i].nom + '</td>';
            // ligne += '<td>' + data[i].prix + '</td>';
            // ligne += '<td>' + data[i].dateAchat + '</td>';
            // ligne += '<td><button type="button" class="btn
            // btn-outline-danger
            // supprimer">Supprimer</button></td>';
            // ligne += '<td><button type="button" class="btn
            // btn-outline-secondary
            // modifier">Modifier</button></td></tr>';
            // }
            // contenu.html(ligne);
            // }

            // $.ajax({
            // url: 'produits/all',
            // data: {op: ''},
            // type: 'GET',
            // async: false,
            // success: function (data, textStatus, jqXHR) {
            // console.log(data);
            // remplir(data);
            // },
            // error: function (jqXHR, textStatus, errorThrown) {
            // console.log(textStatus);
            // }
            // });
        });