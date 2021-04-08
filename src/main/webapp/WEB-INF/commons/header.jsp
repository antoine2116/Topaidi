<%@ page import="fr.epsi.topaidi.entite.Utilisateur" %>
<%@ page import="fr.epsi.topaidi.entite.Administrateur" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <%--Imports CSS--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" />

    <%--Imports JS--%>
    <script src="https://kit.fontawesome.com/7b2ae56766.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <%
        HttpSession httpSession = request.getSession();
        Utilisateur currentUser= httpSession.getAttribute("currentUser") != null ? (Utilisateur) httpSession.getAttribute("currentUser") : null;
    %>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/topaidi-1.0-SNAPSHOT">Topaidi</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/meilleuresIdees">Les meilleures idées</a>
                </li>
                <% if (currentUser != null && currentUser instanceof Administrateur) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories">Catégories</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/utilisateurs">Utilisateurs</a>
                    </li>
                <% } %>
            </ul>
        </div>
        <% if (currentUser != null) { %>
            <div class="dropdown">
                <a class="btn btn-outline-light dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user mr-2"></i>
                    <%= currentUser.getPrenom() %> <%= currentUser.getNom() %>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a href="/deconnexion" class="dropdown-item">Se déconnecter</a>
                </div>
            </div>
        <% } else { %>
            <a href="/connexion" class="text-white mr-2">Se connecter</a>
            <a href="/inscription" class="btn btn-outline-light my-2 my-sm-0">S'inscrire</a>
        <% } %>


    </nav>
</head>

</html>

