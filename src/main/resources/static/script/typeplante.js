$(document)
    .ready(
        function() {

            table = $('#ttypePlante')
                .DataTable({
                    ajax: {
                        url: "typeplant/all",
                        dataSrc: ''
                    },
                    columns: [{
                            data: "id"
                        },
                        {
                            data: "libelle"
                        },
                        {
                            data: "humiditeMax"
                        },
                        {
                            data: "humiditeMin"
                        },
                        {
                            data: "temperatureMin"
                        },
                        {
                            data: "temperatureMax"
                        },
                        {
                            data: "luminosite"
                        },
                        {
                            data: "etat"
                        },

                        {
                            "render": function() {
                                return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
                            }
                        },
                        {
                            "render": function() {
                                return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
                            }
                        }
                    ]

                });


            //button ajouter parcelle
            $('#btn').click(
                function() {
                    var libelle = $("#libelle");
                    var humiditeMin = $("#hummin");
                    var humiditeMax = $("#hummax");
                    var temperatureMax = $("#tempmax");
                    var temperatureMin = $("#tempmin");
                    var luminosite = $("#uminosite");
                    var etat = $("#etat");

                    if ($('#btn').text() == 'Add') {
                        var m = {
                            libelle: libelle.val(),
                            humiditeMax: humiditeMax.val(),
                            humiditeMin: humiditeMin.val(),
                            temperatureMin: temperatureMin.val(),
                            temperatureMax: temperatureMax.val(),
                            luminosite: luminosite.val(),
                            etat: etat.val()

                        };
                        $.ajax({
                            url: 'typeplant/save',
                            contentType: "application/json",
                            dataType: "json",
                            data: JSON.stringify(m),
                            type: 'POST',
                            async: false,
                            success: function(data, textStatus,
                                jqXHR) {
                                table.ajax.reload();
                            },
                            error: function(jqXHR, textStatus,
                                errorThrown) {
                                console.log(textStatus);
                            }
                        });
                        $("#main-content").load(
                            "./page/typeplante.html");
                    }
                });
            $('#table-content')
                .on(
                    'click',
                    '.supprimer',
                    function() {

                        var id = $(this).closest('tr').find(
                            'td').eq(0).text();
                        var oldLing = $(this).closest('tr')
                            .clone();
                        var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">' +
                            id +
                            '</th><td colspan="16" style="height: 100%;">';
                        newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette plante ? </h4>';
                        newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
                        newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

                        $(this).closest('tr').replaceWith(
                            newLigne);
                        $('.annuler').click(
                            function() {
                                $(this).closest('tr')
                                    .replaceWith(
                                        oldLing);
                            });
                        $('.confirmer')
                            .click(
                                function(e) {
                                    e.preventDefault();
                                    $
                                        .ajax({
                                            url: 'typeplant/delete/' +
                                                id,
                                            data: {},
                                            type: 'DELETE',
                                            async: false,
                                            success: function(
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
                                            error: function(
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
                function() {
                    var btn = $('#btn');
                    var id = $(this).closest('tr').find('td').eq(0)
                        .text();;
                    var code = $(this).closest('tr').find('td').eq(
                        1).text();
                    var libelle = $(this).closest('tr').find('td')
                        .eq(2).text();

                    btn.text('Modifier');
                    $("#code").val(code);
                    $("#libelle").val(libelle);
                    $("#id").val(id);

                    btn.click(function(e) {
                        e.preventDefault();
                        var m = {
                            id: $("#id").val(),
                            code: $("#code").val(),
                            libelle: $("#libelle").val()
                        };
                        if ($('#btn').text() == 'Modifier') {
                            $.ajax({
                                url: 'plante/save',
                                contentType: "application/json",
                                dataType: "json",
                                data: JSON.stringify(m),
                                type: 'POST',
                                async: false,
                                success: function(data,
                                    textStatus, jqXHR) {
                                    table.ajax.reload();

                                    btn.text('Add');
                                },
                                error: function(jqXHR, textStatus,
                                    errorThrown) {
                                    console.log(textStatus);
                                }
                            });
                            $("#main-content").load(
                                "./page/plante.html");
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