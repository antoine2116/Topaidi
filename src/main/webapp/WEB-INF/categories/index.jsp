<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des catégories</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 600px; margin: 15px auto">
    <div class="row mb-2">
        <h5 class="col-6">
            Liste des categories
        </h5>
        <div class="col-6">
            <a href="/categories/create" class="btn btn-success float-right">
                Nouvelle catégorie
            </a>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>
                Libellé
            </th>
            <th>

            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="categorie">
            <tr>
                <td>
                    <c:out value="${categorie.libelle}" />
                </td>
                <td class="text-right">
                    <a href="/categories/delete?id=<c:out value="${categorie.id}"/>">
                        <i class="fas fa-trash-alt" style="color: #b51919" title="Supprimer la catégorie"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
