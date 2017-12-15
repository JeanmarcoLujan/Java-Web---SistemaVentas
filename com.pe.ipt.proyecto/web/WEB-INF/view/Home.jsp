<%-- 
    Document   : Dashboard
    Created on : 24/11/2017, 04:23:17 PM
    Author     : Dikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                Bienvenido.
                            </h1>
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
