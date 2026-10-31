<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "WEB-INF/jsp/error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Testing Page</title>
    </head>
    <body>
        <h1>Error Testing Page</h1>
        <% 
            int a = 10;
            int b = 0; //deliberately putting val 0
            
            int div = a/b;
        %> 
        
        <h2>Result: <%= div %></h2>
    </body>
</html>
