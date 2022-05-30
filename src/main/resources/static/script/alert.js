$(document)
    .ready(
        //load current user
        function () {
            $.getJSON('parcelle/getAlerts', function(data) {
                $.each(data, function(index) {
                    if (data[index].humidite!=null)
                    {
                        //alert("Problém umidite dans la parcelle "+data[index].parcelle.id+" date : "+data[index].date);
                        var alert = document.querySelector("#alerte");
                        alert.innerHTML +="<div class='alert alert-danger' id='alerte' role='alert'>Problém umidite dans : la parcelle "+data[index].parcelle.id+' - au date : '+data[index].date+"</div>";
                    }
                    if (data[index].temperature!=null)
                    {
                        //alert("Problém umidite dans la parcelle "+data[index].parcelle.id+" date : "+data[index].date);
                        var alert = document.querySelector("#alerte");
                        alert.innerHTML +="<div class='alert alert-warning' id='alerte' role='alert'>Problém température dans : la parcelle "+data[index].parcelle.id+' - au date : '+data[index].date+"</div>";
                    }
                    if (data[index].luminosite!=null)
                    {
                        //alert("Problém umidite dans la parcelle "+data[index].parcelle.id+" date : "+data[index].date);
                        var alert = document.querySelector("#alerte");
                        alert.innerHTML +="<div class='alert alert-primary' id='alerte' role='alert'>Problém luminosite dans : la parcelle "+data[index].parcelle.id+' - au date : '+data[index].date+"</div>";
                    }
                });
            });
            $('#btn').click(
                function () {
                    document.querySelector("#alerte").innerHTML = "";

                });

        });