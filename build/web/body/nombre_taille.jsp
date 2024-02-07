
<%@page import="objet.Dimension"%>
<% Dimension[] d = (Dimension[]) request.getAttribute("taille");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de Nombre de Tailles</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_nombre_taille" method="post">
                <div class="col-12">
                  
                   <label for="inputNanme4" class="form-label">Dimension</label>
                  <select class="form-select" aria-label="Default select example" name="taille" id="categorie">
                        <%for(int i=0; i<d.length; i++){%>
                        <option value="<%out.print(d[i].getIddimension());%>"><%out.print(d[i].getLibelle());%></option>
                      <%}%>
                    </select>
                   
                   <label for="inputNanme4" class="form-label">Nombre</label>
                  <input type="number" class="form-control" id="inputNanme4" name="nombre">
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