<%@page import="objet.Personne"%>
<%@page import="objet.Profil"%>
<% Profil[] p = (Profil[])request.getAttribute("profil");%>
<% Personne[] pe = (Personne[])request.getAttribute("personne");%>

<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout Personne Embauche</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_personne_embauche" method="post">
                <div class="col-12">
                  
                   <label for="inputNanme4" class="form-label">Personne</label>
                   <select class="form-select" aria-label="Default select example" name="idpersonne" id="categorie">
                        <%for(int i=0; i<pe.length; i++){%>
                        <option value="<%out.print(pe[i].getIdpersonne());%>"><%out.print(pe[i].getNompersonne());%></option>
                      <%}%>
                    </select>
                   
                   <label for="inputNanme4" class="form-label">Profil</label>
                   <select class="form-select" aria-label="Default select example" name="idprofil" id="categorie">
                        <%for(int i=0; i<p.length; i++){%>
                        <option value="<%out.print(p[i].getIdprofil());%>"><%out.print(p[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                     <div class="col-12">
                  <label for="inputNanme4" class="form-label">Date</label>
                  <input type="date" class="form-control" id="inputNanme4" name="date">
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
