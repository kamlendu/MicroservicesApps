<%-- 
    Document   : index
    Created on : 16 Oct, 2008, 12:44:25 PM
    Author     : root
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
    </head>
    <body>
<%!
    String message="";
%>
        <%
            if(session.getAttribute("status")!=null){
            if(session.getAttribute("status").toString().equals("Login_Success"))
            {    

               RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
                    rd.forward(request, response);
            } 
            else if(session.getAttribute("status").toString().equals("Login_Failed"))
            {
                 message = session.getAttribute("statusmessage").toString();
            }
            }

        %>

        <form method="POST">
            <table>
                <tr>
                    <td colspan="2">Login:</td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"/></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>
        <br/>
        
        

       
    </body>
</html>