<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style>
    .card-img-top {
        width: 100%;
        height: 150px;
        object-fit: cover;
    }
</style>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Topaidi</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 1200px; margin: 15px auto">
    <div class="row">
        <div class="col-4" id="classement-top">
            <div class="row">
                <h4>
                    Classement Top
                </h4>
            </div>
            <c:forEach items="${ideesTop}" var="idee">
                <div class="row mb-3">
                    <div class="card" style="width: 21rem; height: 250px">
                        <img class="card-img-top" src="data:image/jpeg;base64,<c:out value="${idee.imageBase64}" />" />
                        <div class="card-body d-flex flex-column p-2" style="height: 50px">
                            <h5 class="card-title mb-1">
                                <c:out value="${idee.titre}" />
                            </h5>
                            <p class="card-text text-right text-secondary font-italic m-2" style="font-size: 0.7em">
                                <c:out value="${idee.prenomUtilisateur}" />
                                <c:out value="${idee.nomUtilisateur}" />
                                <span>
                                    le
                                </span>
                                <c:out value="${idee.strDateCreation}" />
                            </p>
                            <div class="mt-auto ml-auto ">
                                <div class="text-success d-inline mr-2">
                                    <i class="fas fa-thumbs-up"></i>
                                    <span>
                                        <c:out value="${idee.nbVotesTop}" />
                                    </span>
                                </div>
                                <div class="text-danger d-inline mr-1">
                                    <i class="fas fa-thumbs-down"></i>
                                    <span>
                                        <c:out value="${idee.nbVotesFlop}" />
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-4" id="classement-brains">
            <div class="row">
                <h4>
                    Classement Brains
                </h4>
            </div>
            <c:forEach items="${utilisateursBrains}" var="utilisateur">
                <div class="row mb-3">
                    <div class="card pt-3" style="width: 21rem; height: 250px">
                        <img src="https://uctlanguagecentre.com/wp-content/uploads/2020/05/avatar-300x300.png" style="width: 150px; height: 150px; margin: auto"/>
                        <div class="card-body d-flex flex-column p-2" style="height: 50px">
                            <h5 class="card-title mb-1 text-center">
                                <c:out value="${utilisateur.libelle}" />
                            </h5>
                            <p class="card-text text-center text-secondary m-2" style="font-size: 1.1em">
                                <c:out value="${utilisateur.nbIdees}" />
                                idées
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-4" id="classement-buzz">
            <div class="row">
                <h4>
                    Classement Buzz
                </h4>
            </div>
            <c:forEach items="${ideesBuzz}" var="idee">
                <div class="row mb-3">
                    <div class="card" style="width: 21rem; height: 250px">
                        <img class="card-img-top" src="data:image/jpeg;base64,<c:out value="${idee.imageBase64}" />" />
                        <div class="card-body d-flex flex-column p-2" style="height: 50px">
                            <h5 class="card-title mb-1">
                                <c:out value="${idee.titre}" />
                            </h5>
                            <p class="card-text text-right text-secondary font-italic m-2" style="font-size: 0.7em">
                                <c:out value="${idee.prenomUtilisateur}" />
                                <c:out value="${idee.nomUtilisateur}" />
                                <span>
                                    le
                                </span>
                                <c:out value="${idee.strDateCreation}" />
                            </p>
                            <div class="mt-auto ml-auto ">
                                <c:out value="${idee.nbVotesTotal}" />
                                votes
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
