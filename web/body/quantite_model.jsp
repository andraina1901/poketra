<%@page import="objet.Matiere_premiere"%>
<%@page import="objet.Model"%>
<% Model[] d = (Model[]) request.getAttribute("model");%>
<% Matiere_premiere[] m = (Matiere_premiere[]) request.getAttribute("matiere");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout Model</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_quantite_model" method="post">
                <div class="col-12">  
                  <label for="inputNanme4" class="form-label">Model</label>
                  <select class="form-select" aria-label="Default select example" name="model" id="categorie">
                        <%for(int i=0; i<d.length; i++){%>
                        <option value="<%out.print(d[i].getIdModel());%>"><%out.print(d[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                <div class="col-12">  
                  <label for="inputNanme4" class="form-label">Matiere premiere</label>
                  <select class="form-select" aria-label="Default select example" name="matiere" id="categorie">
                        <%for(int i=0; i<m.length; i++){%>
                        <option value="<%out.print(m[i].getIdmatiere_premiere());%>"><%out.print(m[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>    
                 <div class="col-12">
                  <label for="inputNanme4" class="form-label">Quantite</label>
                  <input type="text" class="form-control" id="inputNanme4" name="quantite">
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