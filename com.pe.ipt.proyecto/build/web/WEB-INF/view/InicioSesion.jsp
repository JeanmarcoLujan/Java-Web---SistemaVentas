<%-- 
    Document   : InicioSesion
    Created on : 24/11/2017, 03:40:56 PM
    Author     : Dikas
--%>

<%@page import="com.pe.ipt.proyecto.modelo.InicioSesionModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    InicioSesionModel model = (InicioSesionModel)request.getAttribute("modelo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="InicioSesion" method="POST" class="login">
            <h1 class="login-title">Sistema de Ventas</h1>
            <input name="txtCodigo" type="text" class="login-input" placeholder="Código" autofocus value="<%= model.getCodigo() %>" required >
            <input name="txtClave" type="password" class="login-input" placeholder="Password" value="<%= model.getClave() %>" required >
            <input type="submit" value="Iniciar Sesión" class="login-button" name="btnIniciar" >
            <p class="login-lost">
                <% if(model.getMensaje().compareTo("")!=0){ %>
                <div class="alert alert-danger">
                    <%= model.getMensaje() %>
                </div>
                <%}%>
            </p>
            </form>
    </body>
</html>
