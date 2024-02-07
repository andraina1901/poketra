<%@page import="objet.Look"%>
<%
    Look[] look = (Look[]) request.getAttribute("look");
%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Matiere premiere selon look</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Traitement_matierelook" method="post">
                <div class="col-12">
                    <label for="unite" class="form-label">Look</label>
                    <select class="form-select" aria-label="Default select example" name="look" id="categorie">
                        <%for(int i=0; i<look.length; i++){%>
                        <option value="<%out.print(look[i].getIdlook());%>"><%out.print(look[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>   
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Recherche</button>
                  <!--<button type="reset" class="btn btn-secondary">Reset</button>-->
                </div>
              </form><!-- Vertical Form -->
            </div>
            </div>
          </div>
        </div>
    </section>
</main>