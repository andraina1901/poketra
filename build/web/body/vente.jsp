<%@page import="objet.Model"%>
<% Model[] d = (Model[]) request.getAttribute("model");%>
<%@page import="objet.Personne"%>
<% Personne[] pe = (Personne[])request.getAttribute("personne");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout Vente</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_vente" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Personne</label>
                    <select class="form-select" aria-label="Default select example" name="personne" id="categorie">
                        <%for(int i=0; i<pe.length; i++){%>
                        <option value="<%out.print(pe[i].getIdpersonne());%>"><%out.print(pe[i].getNompersonne());%></option>
                      <%}%>
                    </select>
                    
                     <label for="inputNanme4" class="form-label">Model</label>
                    <select class="form-select" aria-label="Default select example" name="model" id="categorie">
                        <%for(int i=0; i<d.length; i++){%>
                        <option value="<%out.print(d[i].getIdModel());%>"><%out.print(d[i].getLibelle());%></option>
                      <%}%>
                    </select>
                    
                   <label for="inputNanme4" class="form-label">Nombre</label>
                   <input type="number" class="form-control" id="inputNanme4" name="nombre">
                   
                    <label for="inputNanme4" class="form-label">Date</label>
                   <input type="date" class="form-control" id="inputNanme4" name="date">
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