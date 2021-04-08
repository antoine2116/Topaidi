<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<form method="post" action="/inscription" style="width: 100%; max-width: 400px; padding: 15px;  margin: 0 auto;">
    <div class="text-center">
        <h1 class="h3 mb-3 font-weight-normal">Inscription</h1>
        <div class="form-row">
            <div class="form-group col-6">
                <input type="text" name="prenom" class="form-control" placeholder="Prénom" required autofocus="">
            </div>
            <div class="form-group col-6">
                <input type="text" name="nom" class="form-control" placeholder="Nom" required>
            </div>
        </div>
        <div class="form-group">
            <input type="email" name="email" class="form-control" placeholder="Adresse email" required>
        </div>
        <div class="form-group">
            <input type="password" name="motdepasse" class="form-control" placeholder="Mot de passe" required>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">S'inscrire</button>
    </div>

    <div class="mt-3">
        <label class="text-secondary">
            Déjà un compte ?
            <a href="/connexion">Se connecter</a>
        </label>
    </div>
</form>


</body>
</html>
