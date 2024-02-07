<%-- 
    Document   : dimension
    Created on : 19 déc. 2023, 13:29:06
    Author     : CEDRIC
--%>

<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de Dimension</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_dimension" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Libelle</label>
                  <input type="text" class="form-control" id="inputNanme4" name="dimension">
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