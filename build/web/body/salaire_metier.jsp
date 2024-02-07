<%@page import="objet.Metier"%>
<% Metier[] m = (Metier[])request.getAttribute("metier");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de Salaire Metier</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_salaire_metier" method="post">
                <div class="col-12">
                    <label for="unite" class="form-label">Look</label>
                    <select class="form-select" aria-label="Default select example" name="metier" id="categorie">
                        <%for(int i=0; i<m.length; i++){%>
                        <option value="<%out.print(m[i].getIdmetier());%>"><%out.print(m[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                    
                   <label for="inputNanme4" class="form-label">Salaire</label>
                  <input type="number" class="form-control" id="inputNanme4" name="salaire">
                  
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