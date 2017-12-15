<%-- 
    Document   : ListaProductos
    Created on : 25/11/2017, 02:48:55 AM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyecto.modelo.ListaProductosModel"%>
<%@page import="com.pe.ipt.proyectocore.be.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ListaProductosModel modelo = (ListaProductosModel)request.getAttribute("modelo"); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Lista de Productos</title>
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
                                Lista de Productos.
                            </h1>
                        </div>                        
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Productos 
                                    <button class="btn btn-default" onclick="window.location='Producto?ope=new'" ><i class=" fa fa-plus"></i> Nuevo</button>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="lista">
                                            <thead>
                                                <tr>
                                                    <th style="width: 20%" ></th>
                                                    <th style="width: 15%" >Código</th>
                                                    <th style="width: 35%">Nombre</th>
                                                    <th style="width: 15%">Unidad</th>
                                                    <th style="width: 15%">Precio Unitario</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for(Producto p : modelo.getData()){ %>
                                                <tr class="gradeA">
                                                    <td>
                                                        <button class="btn btn-default" onclick="window.location='Producto?ope=upd&id=<%= p.getCodigo() %>'" ><i class=" fa fa-edit "></i> Editar</button>&nbsp;
                                                        <button class="btn btn-default" onclick="if(confirm('¿Seguro de eliminar?')){window.location='Producto?ope=del&id=<%= p.getCodigo() %>';}" ><i class=" fa fa-trash-o"></i> Borrar</button>
                                                        
                                                    </td>
                                                    <td><%= p.getCodigo() %></td>
                                                    <td><%= p.getNombre() %></td>
                                                    <td class="center"><%= p.getUnidad() %></td>
                                                    <td class="center"><%= p.getPrecioUnitario() %></td>
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
