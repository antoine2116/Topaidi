<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Se connecter</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<form method="post" action="/connexion" style="width: 100%; max-width: 400px; padding: 15px;  margin: 0 auto;">
    <div class="text-center">
        <h1 class="h3 mb-3 font-weight-normal">Connexion</h1>

        <div class="form-group">
            <input type="email" name="email" class="form-control" placeholder="Adresse email" required="" value="${email}" autofocus>
        </div>
        <div class="form-group">
            <input type="password" name="motdepasse" class="form-control" placeholder="Mot de passe" required="">
        </div>

        <c:if test="${not empty erreurMessage}">
            <div class="alert alert-danger" role="alert">
                ${erreurMessage}
            </div>
        </c:if>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
    </div>
    <div class="mt-3">
        <label class="text-secondary">
            Pas de compte ?
            <a href="/nouveauCompte">S'inscrire</a>
        </label>
    </div>
</form>


</body>
</html>
