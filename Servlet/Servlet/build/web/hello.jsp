<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.Random, java.io.*" %>>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taglib Directive Example </title>
    </head>
    <body>
        <%@include file= "/WEB-INF/header.jsp" %>     
    <h1>Random Number: 
        <% Random rand = new Random();
           int randNum = rand.nextInt(10); 
        %>
            <%= randNum %>
            <br>
            <c:set var="name" value="Pratham Mittal"></c:set>
            <c:out value="${name}"></c:out>
        
    </h1>
    </body>
</html>
