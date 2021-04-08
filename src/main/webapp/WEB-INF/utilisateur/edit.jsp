<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title></title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 600px; margin: 15px auto">
    <h4 class="col-12">Modification de l'utilisateur</h4>
    <div class="col-12">
        <form method="post" action="/utilisateurs/edit" id="formUtilisateur">
            <input type="hidden" name="id" value="${utilisateur.id}" />
            <div class="card">
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-6 pl-0">
                            <label>Prénom</label>
                            <input type="text" name="prenom" class="form-control" value="${utilisateur.prenom}" readonly />
                        </div>
                        <div class="form-group col-6">
                            <label>Nom</label>
                            <input type="text" name="nom" class="form-control" value="${utilisateur.nom}" readonly />
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-12 pl-0">
                            <label>Email</label>
                            <input type="text" name="email" class="form-control" value="${utilisateur.email}" readonly />
                        </div>
                    </div>
                    <div class="form-check mb-2">
                        <input type="checkbox" name="valide" class="form-check-input" <c:if test="${utilisateur.valide}"> checked="checked" </c:if> />
                        <label class="form-check-label">
                            Validé
                        </label>
                    </div>
                    <div class="form-check">
                        <input type="checkbox" name="desactive" class="form-check-input" <c:if test="${utilisateur.desactive}"> checked="checked" </c:if> />
                        <label class="form-check-label">
                            Désactivé
                        </label>
                    </div>
                    <div class="form-row mt-3 float-right">
                        <button type="submit" class=" btn btn-success">Valider</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    $('#formUtilisateur').submit(function () {
        $('input[name="valide"]').val($('input[name="valide"]').is(':checked'));
        $('input[name="desactive"]').val($('input[name="desactive"]').is(':checked'));
    });
</script>
</body>
</html>
