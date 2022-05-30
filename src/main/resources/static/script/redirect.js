$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("page/statistiques.html");

function show(page) {

    if (page == "statistiques") {
        $('a').removeClass('active');
        $('a:contains(Statistical)').addClass('active');
        $("#main-content").load("page/statistiques.html");
        event.preventDefault();
    }
    if (page == 'gestionusers') {
        $('a').removeClass('active');
        $('a:contains(User Management)').addClass('active');
        $("#main-content").load("page/gestionusers.html");

        event.preventDefault();
    }
    if (page == 'ferme') {
        $('a').removeClass('active');
        $('a:contains(Farms)').addClass('active');
        $("#main-content").load("page/ferme.html");

        event.preventDefault();
    }

    if (page == "parcelle") {
        $('a').removeClass('active');
        $('a:contains(Plots)').addClass('active');
        $("#main-content").load("page/parcelle.html");
        event.preventDefault();
    }
    //--
    if (page == "plante") {
        $('a').removeClass('active');
        $('a:contains(Plants)').addClass('active');
        $("#main-content").load("page/plante.html");
        event.preventDefault();
    }
    if (page == "typeplante") {
        $('a').removeClass('active');
        $('a:contains(Types of plants)').addClass('active');
        $("#main-content").load("page/typeplante.html");
        event.preventDefault();
    }
    if (page == "plantages") {
        $('a').removeClass('active');
        $('a:contains(Planting)').addClass('active');
        $("#main-content").load("page/plantages.html");
        event.preventDefault();
    }


    if (page == "typeSole") {
        $('a').removeClass('active');
        $('a:contains(Type of Soil)').addClass('active');
        $("#main-content").load("page/typeSole.html");
        event.preventDefault();
    }
    if (page == "alerte") {
        $('a').removeClass('active');
        $('a:contains(Alerts)').addClass('active');
        $("#main-content").load("page/alert.html");
        event.preventDefault();
    }



}