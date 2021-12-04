<%-- 
    Document   : test
    Created on : Jul 21, 2021, 8:49:31 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                                        <% int y = 0; %>
<% int z = 0; %>

<% for(int x=0;x<3;x++) { %>
<% z++;++y;%>
<% }%>

<% if(z<y) {%>
<%= z%>
<% } else {%>
<%= z - 1%>
<% }%>
    </body>
</html>
