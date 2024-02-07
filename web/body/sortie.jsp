<%@page import="objet.Matiere_premiere"%>
<% Matiere_premiere[] m = (Matiere_premiere[]) request.getAttribute("matiere");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Sortie Matière Première</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_sortie" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Matiere Première</label>
                  <select class="form-select" aria-label="Default select example" name="matiere" id="categorie">
                        <%for(int i=0; i<m.length; i++){%>
                        <option value="<%out.print(m[i].getIdmatiere_premiere());%>"><%out.print(m[i].getLibelle());%></option>
                      <%}%>
                    </select>
                   <label for="inputNanme4" class="form-label">Quantite</label>
                   <input type="text" class="form-control" id="inputNanme4" name="quantite">
                   </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Valider</button>
                  <!--<button type="reset" class="btn btn-secondary">Reset</button>-->
                </div>
              </form><!-- Vertical Form -->
            </div>
            </div>
          </div>
        </div>
    </section>
</main>         