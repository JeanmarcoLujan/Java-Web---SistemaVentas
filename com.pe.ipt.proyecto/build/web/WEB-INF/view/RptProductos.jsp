<%-- 
    Document   : RptProductos
    Created on : 01/12/2017, 01:23:18 AM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyecto.modelo.RptProductosModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% RptProductosModel modelo = (RptProductosModel)request.getAttribute("modelo"); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Reporte de Productos</title>
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
                                Reporte de Productos
                            </h1>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form method="POST" action="RptProductos" role="form">
                                            <div class="form-group">
                                                <label>Filtro: </label>
                                                <input type="text" name="txtFiltro" class="form-control" value="<%= modelo.getFiltro() %>" >
                                            </div>
                                            <div class="form-group">
                                                <label>Activo </label>
                                                <input type="checkbox" name="chkEstado" checked="<%= modelo.isEstado() %>" value="1" >
                                            </div>
                                            <div class="form-group">
                                                <input type="submit" name="btnMostrar" class="btn btn-success" value="Mostrar" >                                                
                                            </div>
                                        </form>
                                        <% if(modelo.isMostrar()){ %>
                                        <iframe src="RptProductosRPT?filtro=<%= modelo.getFiltro() %>&estado=<%= modelo.isEstado() %>" width="700" height="500" framedorber="1"></iframe>    
                                        <% } %>
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
