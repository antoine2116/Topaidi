<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Proposer une idée</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 800px; margin: 15px auto">
    <h2 class="col-6">Proposer une idée</h2>
    <div class="col-12">
        <form action="createIdee" method="post" enctype="multipart/form-data">
            <div class="card">
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-6 pl-0">
                            <label>Titre</label>
                            <input type="text" name="titre" class="form-control" maxlength="55" autofocus required>
                        </div>
                        <div class="form-group col-6">
                            <label>Catégorie</label>
                            <select class="form-control" name="categorie_id" required>
                                <c:forEach items="${categories}" var="categorie">
                                    <option value="${categorie.id}">${categorie.libelle}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <label>Image</label>
                        <input type="file" name="image" class="form-control-file">
                    </div>
                    <div class="form-row mt-3">
                        <label>Description</label>
                        <textarea name="description" class="form-control" rows="3" maxlength="125"></textarea>
                    </div>
                    <div class="form-row mt-3 float-right">
                        <button class=" btn btn-success">Valider</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
