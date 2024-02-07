<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de Personne</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_personne" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nom">
                </div>
                   <div class="col-12">
                  <label for="inputNanme4" class="form-label">Date de Naissance</label>
                  <input type="date" class="form-control" id="inputNanme4" name="dtn">
                </div>
                   <div class="col-12">
                  <label for="inputNanme4" class="form-label">Adresse</label>
                  <input type="text" class="form-control" id="inputNanme4" name="adresse">
                </div>
                   <div class="col-12">
                  <label for="inputNanme4" class="form-label">Sexe</label>
                   <select class="form-select" aria-label="Default select example" name ="sexe">
                        <option value="m">masculin</option>
                        <option value="f">feminin</option>
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
