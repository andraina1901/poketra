<%@page import="objet.Look"%>
<%Look[] l = (Look[]) request.getAttribute("look");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de Taux Look</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_taux_look" method="post">
                <div class="col-12">
                  
                   <label for="inputNanme4" class="form-label">Look</label>
                  <select class="form-select" aria-label="Default select example" name="look" id="categorie">
                        <%for(int i=0; i<l.length; i++){%>
                        <option value="<%out.print(l[i].getIdlook());%>"><%out.print(l[i].getLibelle());%></option>
                      <%}%>
                    </select>
                   <label for="inputNanme4" class="form-label">Volume horaire</label>
                  <input type="number" class="form-control" id="inputNanme4" name="volume">
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