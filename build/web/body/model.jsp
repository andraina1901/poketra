<%@page import="objet.Type"%>
<%@page import="objet.Look"%>
<%@page import="objet.Dimension"%>
<% Dimension[] d = (Dimension[]) request.getAttribute("dimensions");
Look[] l = (Look[]) request.getAttribute("looks"); 
Type[] t = (Type[]) request.getAttribute("types"); %>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-6">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ajout Model</h5>
              <!-- Vertical Form -->
              <form class="row g-3" action="Ajout_model" method="post">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Libelle</label>
                  <input type="text" class="form-control" id="inputNanme4" name="libelle">
                </div>
                <div class="col-12">  
                  <label for="inputNanme4" class="form-label">Dimension</label>
                  <select class="form-select" aria-label="Default select example" name="dimension" id="categorie">
                        <%for(int i=0; i<d.length; i++){%>
                        <option value="<%out.print(d[i].getIddimension());%>"><%out.print(d[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>   
                 <div class="col-12">  
                  <label for="inputNanme4" class="form-label">Look</label>
                  <select class="form-select" aria-label="Default select example" name="look" id="categorie">
                        <%for(int i=0; i<l.length; i++){%>
                        <option value="<%out.print(l[i].getIdlook());%>"><%out.print(l[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>   
                 <div class="col-12">  
                  <label for="inputNanme4" class="form-label">Type</label>
                  <select class="form-select" aria-label="Default select example" name="type" id="categorie">
                        <%for(int i=0; i<t.length; i++){%>
                        <option value="<%out.print(t[i].getIdtype());%>"><%out.print(t[i].getLibelle());%></option>
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