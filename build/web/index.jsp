<%-- 
    Document   : index
    Created on : Nov 19, 2021, 7:09:50 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
        <link href="Recursos/bootstrap-4.5.3-dist/bootstrap-4.5.3-dist/css/bootstrap-reboot.min.css" rel="stylesheet" type="text/css"/>
        <link href="Recursos/bootstrap-4.5.3-dist/bootstrap-4.5.3-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="Recursos/js/JQuery.js" type="text/javascript"></script>
        <script src="Recursos/js/Alertas.js" type="text/javascript"></script>
        <script src="Recursos/js/datatables.min.js" type="text/javascript"></script>
        <script src="Recursos/bootstrap-4.5.3-dist/bootstrap-4.5.3-dist/js/bootstrap.js" type="text/javascript"></script>
        <script src="Recursos/bootstrap-4.5.3-dist/bootstrap-4.5.3-dist/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="Recursos/js/CrearPersona.js" type="text/javascript"></script>
    </head>
    <script src="Recursos/js/CrearPersona.js" type="text/javascript"></script>
    <body>
        <div class="container" id="datos">
            <form id="formUsuario" method="post" action="" >
                <input name="id" id="id" type="hidden">
                <h1>Crear persona</h1>
                <div class="row">
                    <div class=" col-sm">
                        <label>Nombre completo</label>
                        <input value="" name="Nombrec" id="Nombrec" class="input-group">
                    </div>
                    <div class=" col-sm">
                        <label>Fecha de nacimiento</label>
                        <input type="date" value="" name="Fecha" id="Fecha" class="input-group">
                    </div>
                </div>
            </form>
            <br>
            <div id="Botones">
                <button id="Crear" id="Crear" value="1" class="btn-info btn">Crear</button>
                <button name="Lista" id="Lista"  class="btn-info btn">Lista</button>
            </div>
            <table class="table table-dark" id="listaPersonas"  >
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre Completo</th>
                        <th scope="col">Fecha</th>                
                    </tr>
                </thead>            
            </table>
        </div>
    </body>


</html>
