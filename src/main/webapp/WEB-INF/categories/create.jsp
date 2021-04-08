<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Créer une catégorie</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>

<div class="container" style="width: 100%; max-width: 600px; margin: 15px auto">
    <h4 class="col-12">Créer une catégorie</h4>
    <div class="col-12">
        <form method="post" action="/categories/create">
            <div class="card">
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-12 pl-0">
                            <label>Libellé</label>
                            <input type="text" name="libelle" class="form-control" placeholder="Libellé" maxlength="55" autofocus required>
                        </div>
                    </div>
                    <div class="form-row mt-3 float-right">
                        <button type="submit" class=" btn btn-success">Valider</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
