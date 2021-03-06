$(document)
    .ready(
        function () {
            $.ajax({
                url: "/userid",
                type: "GET",
                success: function (userid) {

                    table = $('#tusers')
                        .DataTable({
                            ajax: {
                                url: "users/allforAdmin/"+userid,
                                dataSrc: ''
                            },
                            columns: [{
                                data: "userId"
                            },
                                {
                                    data: "username"
                                },
                                {
                                    data: "email"
                                },
                                {
                                    data: "password"
                                },
                                {
                                    data: "role.nome"
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
                    //list des roles
                    $.ajax({
                        url: '/roles/all',
                        type: 'GET',
                        success: function (data) {
                            var option = '';
                            data.forEach(e => {
                                option += '<option value =' + e.id + '>' + e.nome + '</option>';
                            });

                            $('#role').append(option);
                        },
                        error: function (jqXHR, textStatus,
                                         errorThrown) {
                            console.log(textStatus);
                        }
                    });

                    //----------------------------------------------------------------
                    //button ajouter parcelle
                    $('#btn').click(
                        function () {
                            var email = $('#email');
                            var password = $('#password');
                            var username = $('#username');
                            var id = $('#role');

                            if ($('#btn').text() == 'Add') {

                                var m = {

                                    email: email.val(),
                                    password: password.val(),
                                    username: username.val(),
                                    role: {
                                        id: id.val()
                                    }
                                };
                                $.ajax({
                                    url: 'users/saves',
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
                                    "./page/gestionusers.html");
                            }

                        });
                    // ---------------------------------------------------------------

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
                                newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer ce user ? </h4>';
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
                                                    url: 'users/delete/' +
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
                }
            });
        });