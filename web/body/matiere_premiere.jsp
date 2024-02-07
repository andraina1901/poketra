<%@page import="objet.Unite"%>
<% Unite[] u = (Unite[]) request.getAttribute("unite"); %>

<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout matiere premiere</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_matiere" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Libelle</label>
                  <input type="text" class="form-control" id="inputNanme4" name="matiere">
                </div>
                <div class="col-12">
                    <label for="unite" class="form-label">Unite</label>
                    <select class="form-select" aria-label="Default select example" name="unite" id="categorie">
                        <%for(int i=0; i<u.length; i++){%>
                        <option value="<%out.print(u[i].getIdunite());%>"><%out.print(u[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Ajouter</button>
                  <!--<button type="reset" class="btn btn-secondary">Reset</button>-->
                </div>
              </form><!-- Vertical Form -->
            </div>
            </div>
          </div>
        </div>
    </section>
</main>