<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <%
        HttpSession s = request.getSession();
        if (s.getAttribute("usuario")==null)
            response.sendRedirect(request.getContextPath()+"/home");
        
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.addHeader("Cache-Control", "pre-check=0, post-check=0");
            response.setHeader("Pragma", "No-cache"); // HTTP 1.0.
            response.setHeader("Expires", "0"); // Proxies.
        %>
        <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="font-family: arial" onunload="">

        <h3>Bienvenido a Spring</h3>
        <%
        out.println("Usuario: "+s.getAttribute("usuario")+"<br/>");
        out.println("Nombre: "+s.getAttribute("nombre")+"<br/>");
        out.println("Correo: "+s.getAttribute("correo")+"<br/>");
        out.println("Rol: "+s.getAttribute("idrol")+"<br/>");
        %>
        <a href="<c:url value='/usuarios'/>">Listado de Usuarios</a><br/>
        <a href="<c:url value='/cerrarsesion'/>">Cerrar Sesion</a>
    </body>
</html>

