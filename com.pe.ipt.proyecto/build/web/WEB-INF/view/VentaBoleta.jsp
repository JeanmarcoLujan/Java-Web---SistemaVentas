<%-- 
    Document   : Dashboard
    Created on : 24/11/2017, 04:23:17 PM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyectocore.be.Boleta"%>
<%@page import="com.pe.ipt.proyectocore.be.Producto"%>
<%@page import="com.pe.ipt.proyectocore.be.Cliente"%>
<%@page import="com.pe.ipt.proyecto.modelo.VentaBoletaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% VentaBoletaModel modelo = (VentaBoletaModel) request.getAttribute("modelo");%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Home</title>
        <jsp:include page="partial/_HEAD.jspf" />
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
                                Nueva Boleta.
                            </h1>
                            <div class="panel-body">
                                <form method="POST" action="VentaBoleta" role="form">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <br/>
                                            <div class="form-group">
                                                <label>Número</label>
                                                <input type="text" name="txtNumero" class="form-control" value="<%= modelo.getNumero()%>" >
                                            </div>
                                            <div class="form-group">
                                                <label>Cliente</label>
                                                <select class="form-control" name="cmbCliente" >
                                                    <% for (Cliente c : modelo.getClientes()) {%>
                                                    <option <%= (c.getDocumento().compareTo(modelo.getCliente()) == 0 ? "selected" : "")%>  value="<%= c.getDocumento()%>" ><%= c.getNombre() + " " + c.getApellido()%></option>
                                                    <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Producto</label>
                                                <select class="form-control" name="cmbProducto" >
                                                    <% for (Producto c : modelo.getProductos()) {%>
                                                    <option <%= (c.getCodigo().toString().compareTo(modelo.getProducto()) == 0 ? "selected" : "")%>  value="<%= c.getCodigo()%>" ><%= c.getNombre()%></option>
                                                    <% }%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Cantidad</label>
                                                <input type="number" name="txtCantidad" class="form-control" value="<%= modelo.getCantidad()%>" min="1" max="200" >
                                            </div>

                                            <div class="form-group">
                                                <input type="submit" value="Agrega Producto" name="btnAgregar" class="btn btn-default"
                                        </div>


                                    </div>
                                </div>
                                <div class="row"
                                     <div class="col-lg-12">
                                        <!-- Advanced Tables -->
                                        <div class="panel panel-default">
                                            
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover" id="lista">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 10%" ></th>
                                                                <th style="width: 10%" >Cantidad</th>
                                                                <th style="width: 40%">Producto</th>
                                                                <th style="width: 10%">Unidad</th>
                                                                <th style="width: 15%">P. Unit.</th>
                                                                <th style="width: 15%">Total</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <% for (Boleta.DetalleVentaProducto p : modelo.getDetalle()) {%>
                                                            <tr class="gradeA">
                                                                <td>
                                                                    <button class="btn btn-default" onclick="if (confirm('¿Seguro de eliminar?')) {
                                                                                alert('Falta implementar');
                                                                            }" ><i class=" fa fa-trash-o"></i> Borrar</button>

                                                                </td>
                                                                <td><%= p.getCantidad()%></td>
                                                                <td><%= p.getProducto().getNombre()%></td>
                                                                <td><%= p.getProducto().getUnidad()%></td>
                                                                <td><%= p.getProducto().getPrecioUnitario()%></td>
                                                                <td><%= p.getPrecioTotal()%></td>
                                                            </tr>
                                                            <% }%>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <br/>
                                            <label>Total</label>
                                            <label><%= modelo.getTotal()%></label>
                                        </div>
                                        <div class="form-group" >
                                            <br/>
                                            <input type="submit" value="Grabar" name="btnGrabar" class="btn btn-success" />
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div> 
                <jsp:include page="partial/_footer.jspf" />
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <jsp:include page="partial/_JS.jspf"/>

</body>
</html>
