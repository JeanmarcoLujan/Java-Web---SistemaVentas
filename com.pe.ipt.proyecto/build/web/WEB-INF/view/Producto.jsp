<%-- 
    Document   : Producto
    Created on : 24/11/2017, 04:23:17 PM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyecto.modelo.ProductoModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ProductoModel model = (ProductoModel)request.getAttribute("modelo");
%>

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
                                Producto
                            </h1>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form method="POST" action="Producto" role="form">
                                            <div class="form-group">
                                                <label>Código</label>
                                                <input type="text" name="txtCodigo" class="form-control" value="<%= model.getCodigo() %>" readonly >
                                            </div>
                                            <div class="form-group">
                                                <label>Nombre</label>
                                                <input type="text" name="txtNombre" class="form-control" value="<%= model.getNombre() %>" required  >
                                            </div>
                                            <div class="form-group">
                                                <label>Unidad</label>
                                                <input type="text" name="txtUnidad" class="form-control" value="<%= model.getUnidad() %>" required >
                                            </div>
                                            <div class="form-group">
                                                <label>Precio</label>
                                                <input type="text" name="txtPrecio" class="form-control" value="<%= model.getPrecio() %>" required pattern="^\d+(\.|\,)\d{2}$" title="Ejemplo: 99.99" >
                                            </div>
                                            <div class="form-group">
                                                <input type="submit" name="btnGrabar" class="btn btn-success" value="Grabar" >
                                                <input type="button" class="btn btn-default" value="Cancelar" onclick="window.location='ListaProductos'" >
                                            </div>
                                            <input type="hidden" name="operacion" value="<%= model.getOperacion() %>" />                                       
                                        </form>
                                    </div>
                                </div>
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
