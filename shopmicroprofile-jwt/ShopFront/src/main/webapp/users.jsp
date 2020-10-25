<%-- 
    Document   : users
    Created on : 28 Oct, 2010, 11:43:50 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.util.List" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> 
            Hello  <%= session.getAttribute("uname")%> belonging to 
            <%
                List groups = (List) session.getAttribute("groups");
                
                out.println(groups.toString());
                
                %>
            
        </h1>

        <a href="/ShopFront/ShopServlet">  Shop Store </a>
        <br><br><br><a href="logout.jsp">Log out </a>
    </body>
</html>
