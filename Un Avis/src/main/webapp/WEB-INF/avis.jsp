<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@  page import="Metier.commenter"%>
<!DOCTYPE html>
<html>
<head>
    <title>Commentaires</title>
</head>
<body>

<% List<String> commenter = (List<String>)request.getAttribute("membres"); %>
    <form action="commenter" method="post">
        <input type="hidden" name="id_livre" value="<%= request.getParameter("id_livre") %>">
        <input type="text" name="commentaire" placeholder="Ajouter un commentaire">
        <button type="submit">Ajouter</button>
    </form>
    
    <% for(String commentaire : commenter) { %>
        <p><%= commentaire %></p>
     <% } %>
</body>
</html>







