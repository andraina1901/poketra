<%@page import="objet.Matiere_premiere"%>
<%@page import="objet.Look"%>
<%
    Look[] look = (Look[]) request.getAttribute("look");
    Matiere_premiere[] mat = (Matiere_premiere[]) request.getAttribute("matiere");
%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout de matiere pour un look</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_matierelook" method="post">
                <div class="col-12">
                    <label for="unite" class="form-label">Look</label>
                    <select class="form-select" aria-label="Default select example" name="look" id="categorie">
                        <%for(int i=0; i<look.length; i++){%>
                        <option value="<%out.print(look[i].getIdlook());%>"><%out.print(look[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>
                 <div class="col-12">
                    <label for="unite" class="form-label">Matiere premiere</label>
                    <select class="form-select" aria-label="Default select example" name="matiere" id="categorie">
                        <%for(int i=0; i<mat.length; i++){%>
                        <option value="<%out.print(mat[i].getIdmatiere_premiere());%>"><%out.print(mat[i].getLibelle());%></option>
                      <%}%>
                    </select>
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