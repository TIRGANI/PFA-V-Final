<script>
    $(document).ready(function () {
        // alert($('button[data-toggle="collapse"]').eq(0).text());
        // alert();
        $('button[data-target="#collapseOne"]').click(function () {
            if ($('#collapseOne').hasClass("collapse show")) {
                $(this).eq(0).find('i').eq(1).removeClass("fa-angle-down pt-2").addClass("fa-angle-left pt-1");
            } else if ($('#collapseOne').hasClass("collapse")) {
                $(this).eq(0).find('i').eq(1).removeClass("fa-angle-left pt-1").addClass("fa-angle-down pt-2");
            }
        });
        $('button[data-target="#collapseTwo"]').click(function () {
            if ($('#collapseTwo').hasClass("collapse show")) {
                $(this).eq(0).find('i').eq(1).removeClass("fa-angle-down pt-2").addClass("fa-angle-left pt-1");
            } else if ($('#collapseTwo').hasClass("collapse")) {
                $(this).eq(0).find('i').eq(1).removeClass("fa-angle-left pt-1").addClass("fa-angle-down pt-2");
            }
        });
    });


</script>
<div class = "col-lg-3 col-md-4 col-sm-5 mt-5 leftSide">
    
    <div class="accordion h-100 w-100" id="accordionExample">
        <div class="card">
            <div class="" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn rounded-0 w-100 text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        <i class="fa fa-bar-chart-o fa-fw"></i> Gestions <i class="fa fa-angle-down float-right pt-2"></i>
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="">
                    <ul class = "list-group list-group-flush ">
                        <a href = "Employe.php"> <li class = "list-group-item"> <i class="fa fa-table fa-fw"></i>  Gestion des employés</li></a>
                        <a href = "Fonction.php"><li class = "list-group-item"><i class="fa fa-table fa-fw"></i> Gestion des fonctions</li></a>
                        <a href = "Departement.php"><li class = "list-group-item active"><i class="fa fa-table fa-fw"></i> Gestion des departements</li></a>
                        <a href = "Pointage.php"><li class = "list-group-item"><i class="fa fa-table fa-fw"></i> Gestion des pointages</li></a>
                    </ul>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn rounded-0 w-100 text-left" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        <i class="fa fa-bar-chart-o fa-fw"></i> Gestions <i class="fa fa-angle-left float-right pt-1"></i>
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="">
                    <ul class = "list-group list-group-flush ">
                        <a href = "historique.php"> <li class = "list-group-item">Historique de pointage</li></a>
                        <a href = "statistiques.php"><li class = "list-group-item">Statistiques de Pointage</li></a>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

