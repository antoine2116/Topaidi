<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Topaidi</title>
    <%@include file="commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 1100px; margin: 15px auto">
    <div class="row mb-2">
        <h2 class="col-6">Les idées</h2>
        <% if (currentUser != null) { %>
            <div class="col-6">
                <a href="/createIdee" class="btn btn-success float-right">Proposer une idée</a>
            </div>
        <% } %>
    </div>
    <div class="row">
        <c:forEach items="${idees}" var="idee">
            <div class="col-sm-4 mb-2">
                <div class="card" style="width: 21rem; height: 420px">
                    <img class="card-img-top" src="data:image/jpeg;base64,<c:out value="${idee.imageBase64}" />" style="width: 100%; height: 200px; object-fit: cover;" />
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title mb-1">
                            <c:out value="${idee.titre}" />
                        </h5>
                        <div class="flex-row mb-1">
                            <span class="badge badge-dark">
                                <c:out value="${idee.libelleCategorie}" />
                            </span>
                        </div>
                        <p class="card-text text-justify mb-0" style="font-size: 0.8em">
                            <c:out value="${idee.description}" />
                        </p>
                        <p class="card-text text-right text-secondary font-italic m-2" style="font-size: 0.7em">
                            <c:out value="${idee.prenomUtilisateur}" />
                            <c:out value="${idee.nomUtilisateur}" />
                            <span>
                                le
                            </span>
                            <c:out value="${idee.strDateCreation}" />
                        </p>
                        <div class="mt-auto ml-auto d-inline">

                            <form class="d-inline" action="/vote" method="post">
                                <input type="hidden" name="id" value="<c:out value="${idee.id}"/>">
                                <input type="hidden" name="top" value="true"/>
                                <button type="submit" class="btn btn-sm btn-success" <c:out value="${idee.votableByUtilisateur ? '' : 'disabled'}" />>
                                    <i class="fas fa-thumbs-up"></i>
                                    <span>
                                        <c:out value="${idee.nbVotesTop}" />
                                    </span>
                                </button>
                            </form>

                            <form class="d-inline" action="/vote" method="post">
                                <input type="hidden" name="id" value="<c:out value="${idee.id}"/>">
                                <input type="hidden" name="top" value="false"/>
                                <button type="submit" class="btn btn-sm btn-danger" <c:out value="${idee.votableByUtilisateur ? '' : 'disabled'}" />>
                                    <i class="fas fa-thumbs-down"></i>
                                    <span>
                                        <c:out value="${idee.nbVotesFlop}" />
                                    </span>
                                </button>
                            </form>

                            <button type="button" class="btn btn-sm btn-info btn-commentaires" data-idIdee="<c:out value="${idee.id}" />" title="Commentaires" >
                                <i class="fas fa-comments"></i>
                                <span>
                                    <c:out value="${idee.nbCommentaires}" />
                                </span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div class="modal fade" id="commentairesModale" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div class="overflow-auto commentaires" style="max-height: 500px">
                    <div class="commentaire"  style="display: none">
                        <div class="d-flex flex-row align-items-center">
                            <h5 class="mr-2 comm-utilisateur">
                                <%--Infos utilisateur--%>
                            </h5>
                            <span class="dot mb-1">
                                &bull;
                            </span>
                            <span class="mb-1 ml-2 comm-date" style="font-size: 1em">
                                <%--Date--%>
                            </span>
                        </div>
                        <div class="comment-text-sm">
                            <span class="comm-texte">
                                <%--Texte--%>
                            </span>
                        </div>
                        <hr style="width:440px; margin: 15px auto;" />
                    </div>
                </div>
                <% if (currentUser != null) { %>
                    <form method="post" action="/createCommentaire" id="formCommentaire">
                        <div class="d-flex flex-row mt-4 mb-4">
                            <input type="hidden" name="idIdee" id="comm-idIdee">
                            <input type="text" name="texte" class="form-control mr-3" placeholder="Ajouter un commentaire...">
                            <button class="btn btn-primary" type="submit">
                                <i class="fas fa-paper-plane"></i>
                            </button>
                        </div>
                    </form>
                <% } %>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    $(document).ready(function() {
       $('.btn-commentaires').click(function() {
           const idIdee = $(this).data("ididee");
           const params = "idIdee=" + idIdee;
           $.ajax({
               url: '/commentaires?' + params,
               type: 'GET',
               contentType: 'application/json; charset=UTF-8',
               success: function (response) {
                   const container = $('.commentaires').first();
                   const commentaire = $('.commentaire').first();

                   container.empty();

                    for (let i = 0; i < response.length; i++) {
                        const newCommentaire = commentaire.clone();
                        $(newCommentaire).css('display', 'block');
                        $(newCommentaire).find('.comm-utilisateur').text(response[i].libelleUtilisateur);
                        $(newCommentaire).find('.comm-date').text(response[i].date);
                        $(newCommentaire).find('.comm-texte').text(response[i].texte);
                        container.append(newCommentaire);
                    }

                    $('#comm-idIdee').val(idIdee);

                    commentaire.css("display", "none");
                    container.append(commentaire);

                    $('#commentairesModale').modal('toggle');
               },
               error: function (response) {
                   console.log(response.error);
               }
           });
       });
    });
</script>
</html>
