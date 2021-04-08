<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des utilisateurs</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 850px; margin: 15px auto">
    <div class="row mb-2">
        <h5 class="col-6">
            Liste des utilisateurs
        </h5>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>
                Prénom
            </th>
            <th>
                Nom
            </th>
            <th>
                Mail
            </th>
            <th>
               Validé
            </th>
            <th>
                Désactivé
            </th>
            <th>

            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${utilisateurs}" var="utilisateur">
            <tr>
                <td>
                    <c:out value="${utilisateur.prenom}" />
                </td>
                <td>
                    <c:out value="${utilisateur.nom}" />
                </td>
                <td>
                    <c:out value="${utilisateur.email}" />
                </td>
                <td class="text-center">
                    <c:if test="${utilisateur.valide}">
                        <i class="fas fa-check" style="color: #337d36"></i>
                    </c:if>
                    <c:if test="${!utilisateur.valide}">
                        <i class="fas fa-times" style="color: #b51919"></i>
                    </c:if>
                </td>
                <td class="text-center">
                    <c:if test="${utilisateur.desactive}">
                        <i class="fas fa-check" style="color: #337d36"></i>
                    </c:if>
                    <c:if test="${!utilisateur.desactive}">
                        <i class="fas fa-times" style="color: #b51919"></i>
                    </c:if>
                </td>
                <td class="text-right">
                    <a href="/utilisateurs/edit?id=<c:out value="${utilisateur.id}"/>">
                        <i class="fas fa-edit" style="color: #109dc4"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
