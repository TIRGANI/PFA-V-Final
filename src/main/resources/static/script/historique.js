$(document)
    .ready(
        //load current user
        function () {
            $.ajax({
                url: "/userid",
                type: "GET",
                success: function (data) {
                    $("#userId").val(data);
                    $.ajax({
                        url: 'users/getuser/'+data,
                        contentType: "application/json",
                        dataType: "json",
                        data: '',
                        type: 'GET',
                        async: false,
                        success: function (data, textStatus,
                                           jqXHR) {
                            $("#username").val(data.username);
                            $("#email").val(data.email);
                            $("#password").val(data.password);
                        },
                        error: function (jqXHR, textStatus,
                                         errorThrown) {
                            console.log(textStatus);
                        }
                    });
                }
            });
            //button update user
            $('#btn').click(
                function () {
                    var userId = $("#userId");
                    var password = $("#password");
                    var username = $("#username");
                    var email = $("#email");
                    //  alert(username.val()+"|"+password.val()+"|"+username.val()+"|"+email.val())
                    if ($('#btn').text() == 'Update') {
                        var m = {
                            userId: userId.val(),
                            username: username.val(),
                            password: password.val(),
                            email: email.val(),

                        };
                        $.ajax({
                            url: 'users/update',
                            contentType: "application/json",
                            dataType: "json",
                            data: JSON.stringify(m),
                            type: 'POST',
                            async: false,
                            success: function (data, textStatus,
                                               jqXHR) {
                                table.ajax.reload();
                            },
                            error: function (jqXHR, textStatus,
                                             errorThrown) {
                                console.log(textStatus);
                            }
                        });

                    }

                    $("#main-content").load(
                        "./page/alert.html");

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
                                            url: 'admin/deleteticket/' +
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


        });