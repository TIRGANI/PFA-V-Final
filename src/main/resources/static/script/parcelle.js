$(document)
    .ready(
        function () {

            table = $('#tparcelle')
                .DataTable({
                    ajax: {
                        url: "parcelle/all",
                        dataSrc: ''
                    },
                    columns: [{
                        data: "id"
                    },
                        {
                            data: "surface"
                        },
                        {
                            data: 'photo',
                            "render": function (data, type, row, meta) {
                                return '<img src="' + data + '" alt="' + data + '"height="16" width="16"/>';

                            }
                        },
                        {
                            data: "ferme.id"
                        },
                        {
                            data: "typeSole.libelle"
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
            //list des fermes
            $.ajax({
                url: '/ferme/all',
                type: 'GET',
                success: function (data) {
                    var option = '';
                    data.forEach(e => {
                        option += '<option value =' + e.id + '>' + e.id + '</option>';
                    });

                    $('#fermes').append(option);
                },
                error: function (jqXHR, textStatus,
                                 errorThrown) {
                    console.log(textStatus);
                }

            });
            //list des soles
            $.ajax({
                url: '/typesole/all',
                type: 'GET',
                success: function (data) {
                    var option = '';
                    data.forEach(e => {
                        option += '<option value =' + e.id + '>' + e.libelle + '</option>';
                    });

                    $('#typesoles').append(option);
                },
                error: function (jqXHR, textStatus,
                                 errorThrown) {
                    console.log(textStatus);
                }
            });
            //button ajouter parcelle
            $('#btn').click(
                function () {
                    var surface = $("#surface");

                    var fermes = $("#fermes");
                    var typesoles = $("#typesoles");

                    if ($('#btn').text() == 'Add') {
                        //upload file
                        var file = $('#photo')[0].files[0]
                        var fd = new FormData();
                        fd.append('file', file);
                     /*   $.ajax({
                            url: '/load-parcelle',
                            type: 'POST',
                            processData: false,
                            contentType: false,
                            data: fd,
                            success: function (photo, status, jqxhr) {*/


                                var m = {

                                    surface: surface.val(),
                                    photo: "img/parcelle/photo.jpg",
                                    ferme: {
                                        id: fermes.val(),
                                    },
                                    typeSole: {
                                        id: typesoles.val(),
                                    }
                                };
                                $.ajax({
                                    url: 'parcelle/saves',
                                    contentType: "application/json",
                                    dataType: "json",
                                    data: JSON.stringify(m),
                                    type: 'POST',
                                    async: false,
                                    success: function (dat, textStatus,
                                                       jqXHR) {

                                        table.ajax.reload();
                                    },
                                    error: function (datas, textStatus,
                                                     errorThrown) {

                                        console.log(textStatus);
                                    }
                                });
                                $("#main-content").load(
                                    "./page/parcelle.html");
                            }
                      /*  });
                    }*/
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
                            '</th><td colspan="10" style="height: 100%;">';
                        newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer ce produit ? </h4>';
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
                                            url: 'parcelle/delete/' +
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
                    var libelle = $(this).closest('tr').find('td')
                        .eq(2).text();

                    btn.text('Modifier');
                    $("#code").val(code);
                    $("#libelle").val(libelle);
                    $("#id").val(id);

                    btn.click(function (e) {
                        e.preventDefault();
                        var m = {
                            id: $("#id").val(),
                            code: $("#code").val(),
                            libelle: $("#libelle").val()
                        };
                        if ($('#btn').text() == 'Modifier') {
                            $.ajax({
                                url: 'parcelle/save',
                                contentType: "application/json",
                                dataType: "json",
                                data: JSON.stringify(m),
                                type: 'POST',
                                async: false,
                                success: function (data,
                                                   textStatus, jqXHR) {
                                    table.ajax.reload();

                                    btn.text('Add');
                                },
                                error: function (jqXHR, textStatus,
                                                 errorThrown) {
                                    console.log(textStatus);
                                }
                            });
                            $("#main-content").load(
                                "./page/marque.html");
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