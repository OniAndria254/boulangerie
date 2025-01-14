
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Produit> all = (List<Produit>) request.getAttribute("all");
    String error = (String) request.getAttribute("error");
    if(error != null)
    {
%>
<div class="alert alert-danger" role="alert"><%= error%></div>
<%
    }
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">

                <h4 class="card-title">Insertion Produit Conseille</h4>

                <form class="forms-sample" method="post" action="/produitConseille/addProduitConseille">
                    <div class="mb-3">
                        <label class="form-label">Produit</label>
                        <select class="form-select mb-3" name="idProduitConseille">
                            <%
                                for (Produit pt : all) { %>
                            <option value="<%= pt.getIdProduit() %>"><%= pt.getNom() %></option>
                            <%}
                            %>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="dateProduitConseille" class="form-label">Date</label>
                        <input type="date" class="form-control" id="dateProduitConseille" name="dateProduitConseille">
                    </div>

                    <button type="submit" class="btn btn-primary me-2">Ajouter</button>
                </form>

            </div>
        </div>
    </div>

</div>
