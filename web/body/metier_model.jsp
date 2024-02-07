<%@page import="objet.Metier"%>
<% Metier[] m = (Metier[])request.getAttribute("metier");%>
<%@page import="objet.Model"%>
<% Model[] d = (Model[]) request.getAttribute("model");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout Modèle metier</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_metier_modele" method="post">
                <div class="col-12">
                  
                   <label for="inputNanme4" class="form-label">Model</label>
                  <select class="form-select" aria-label="Default select example" name="model" id="categorie">
                        <%for(int i=0; i<d.length; i++){%>
                        <option value="<%out.print(d[i].getIdModel());%>"><%out.print(d[i].getLibelle());%></option>
                      <%}%>
                    </select>
                   <label for="inputNanme4" class="form-label">Nombre</label>
                  <input type="number" class="form-control" id="inputNanme4" name="nombre">
                   <label for="inputNanme4" class="form-label">Metier</label>
                    <select class="form-select" aria-label="Default select example" name="metier" id="categorie">
                        <%for(int i=0; i<m.length; i++){%>
                        <option value="<%out.print(m[i].getIdmetier());%>"><%out.print(m[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Ok</button>
                  <!--<button type="reset" class="btn btn-secondary">Reset</button>-->
                </div>
              </form><!-- Vertical Form -->
            </div>
            </div>
          </div>
        </div>
    </section>
</main>