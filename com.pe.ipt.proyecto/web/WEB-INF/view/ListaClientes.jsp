<%-- 
    Document   : ListaClientes
    Created on : 25/11/2017, 02:48:55 AM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyectocore.be.Cliente"%>
<%@page import="com.pe.ipt.proyecto.modelo.ListaClientesModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ListaClientesModel modelo = (ListaClientesModel)request.getAttribute("modelo"); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Lista de Clientes</title>
        <jsp:include page="partial/_HEAD.jspf" />
        <!-- TABLE STYLES-->
        <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="partial/_header.jsp" />
            <jsp:include page="partial/_menu.jspf" />
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-header">
                                Lista de Clientes.
                            </h1>
                        </div>                        
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Clientes 
                                    <button class="btn btn-default" onclick="window.location='Cliente?ope=new'" ><i class=" fa fa-plus"></i> Nuevo</button>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="lista">
                                            <thead>
                                                <tr>
                                                    <th style="width: 20%" ></th>
                                                    <th style="width: 10%">RUC</th>
                                                    <th style="width: 10%">Razón Social</th>
                                                    <th style="width: 10%">Nombre</th>
                                                    <th style="width: 10%">Apellido</th>
                                                    <th style="width: 10%">Documento</th>
                                                    <th style="width: 10%">Dirección</th>
                                                    <th style="width: 10%">Teléfono</th>
                                                    <th style="width: 10%">Ciudad</th>
                                                    <!--
                                                    <th style="width: 10%">Fecha Nacimiento</th>
                                                    -->
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for(Cliente p : modelo.getData()){ %>
                                                <tr class="gradeA">
                                                    <td>
                                                        <button class="btn btn-default" onclick="window.location='Cliente?ope=upd&id=<%= p.getRuc() %>'" ><i class=" fa fa-edit "></i> Editar</button>&nbsp;
                                                        <button class="btn btn-default" onclick="if(confirm('¿Seguro de eliminar?')){window.location='Cliente?ope=del&id=<%= p.getRuc() %>';}" ><i class=" fa fa-trash-o"></i> Borrar</button>
                                                        
                                                    </td>
                                                    <td><%= p.getRuc() %></td>
                                                    <td><%= p.getRazonSocial() %></td>
                                                    <td><%= p.getNombre() %></td>
                                                    <td><%= p.getApellido() %></td>
                                                    <td><%= p.getDocumento() %></td>
                                                    <td><%= p.getDireccion() %></td>
                                                    <td><%= p.getTelefono() %></td>
                                                    <td><%= p.getCiudad() %></td>
                                                    <!--
                                                    <td><%= p.getFechaNacimiento() %></td>
                                                    -->
                                                </tr>
                                                <% } %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /. PAGE INNER  -->
                <jsp:include page="partial/_footer.jspf" />                
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <jsp:include page="partial/_JS.jspf"/>
        <!-- DATA TABLE SCRIPTS -->
        
        <script src="assets/js/dataTables/jquery.dataTables.js"></script>
        <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function(){
                $('#lista').dataTable({
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "No se encontró registros",
                        "info": "Página _PAGE_ de _PAGES_",
                        "infoEmpty": "Ningún registro disponible",
                        "infoFiltered": "(filtrado de _MAX_ registros)",
                        "search": "Buscar: ",
                        "paginate": {
                            "previous": "Anterior",
                            "next": "Siguiente"
                        }
                    }
                }  );
            });
        </script>
    </body>
</html>
