$(document).ready(function () {
    const ajax = (ir_a, llevar, hacer) => {
        $.ajax({
            url: ir_a,
            encoding: "UTF-8",
            data: llevar,
            type: 'POST',
            dataType: 'html',
            contentType: "application/x-www-form-urlencoded;charset=ISO-8859-15",
            success: function (data) {
                hacer(data);
            },
            error: function (xhr, status) {
                swal({
                    type: 'error',
                    title: 'Oops...',
                    background: 'linear-gradient(#2BD9DD , #6ACF28)',
                    html: status + ":" + xhr + 'Porvar contate con el administrador'
                });
            }
        });
    };
    const me = (dato) => {
        if (dato === "2") {
            swal({
                type: 'success',
                title: 'Persona Modificado!',
                showConfirmButton: false,
                background: 'linear-gradient(#FF0101 , #01FFBC)',
                timer: 2150
            });

        } else if (dato === "Error2") {
            swal({
                type: 'error',
                title: 'Oops...',
                background: 'linear-gradient(#2BD9DD , #6ACF28)',
                html: 'Porvar contate con el administrador'
            });
        }


        if (dato === "1") {
            swal({
                type: 'success',
                title: 'Persona Registrado!',
                showConfirmButton: false,
                background: 'linear-gradient(#FF0101 , #01FFBC)',
                timer: 2150
            });

        } else if (dato === "Error") {
            swal({
                type: 'error',
                title: 'Oops...',
                background: 'linear-gradient(#2BD9DD , #6ACF28)',
                html: 'Porvar contate con el administrador'
            });
        }
    };
    $("#Crear").click(function () {
        let llevar = $("#formUsuario").serialize();
        const Crear = $("#Crear").val();
        let ir_a;
        ir_a = "CrearPersona";

        let hacer = function (data) {
            me(data);
        };
        ajax(ir_a, llevar, hacer);

    });
    $("#Lista").click(function () {
        let ir_a = "ListaPersonas";
        let llevar;
        let hacer = (data) => {
            const datos = JSON.parse(data);
            const tbody2 = $("<tbody>").attr("id", "listaventa");
            $("#listaPersonas").html(tbody2);
            var total = 0;
            datos.forEach(element => {
                let tr = $("<tr>");
                tr.append(th(element.Id)).attr("id", "tabla" + element.Id);
                tr.append(input(element.Id, "Persona" + element.Id));
                tr.append(th(element.NombreCompleta));
                tr.append(th(element.Fecha));
                let btnmo = $("<button>").addClass("btn btn-danger ");
                tr.append(btnmo.html("Ver mas"));
                btnmo.click(function () {
                    $("#Nombrec").val(element.NombreCompleta);
                    $("#Fecha").val(element.Fecha);
                    $("#id").val(element.Id);
                    let btnmo2 = $("<button>").addClass("btn btn-info ").html("Modificar");
                    $("#Botones").append(btnmo2);
                    btnmo2.click(function () {
                        let llevar = $("#formUsuario").serialize();
                        ir_a = "ModificarPersona";
                        let hacer = function (data) {
                            me(data);
                        };
                        ajax(ir_a, llevar, hacer);
                    });

                });
                btnmo.html("Ver mas");
                tbody2.append(tr);
            });
            $("#listaPersonas").append(tbody2);
            ;
            $("#listaPersonas").DataTable();

        };
        ajax(ir_a, llevar, hacer);
    });

    const th = (pdato) => {
        return $("<th scope='col'>").html(pdato);
    };
    const input = (pdato, id) => {
        return $("<input name='NumeroE' value ='" + pdato + "'>").attr("id", id).hide();
    };
});