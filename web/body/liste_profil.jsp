<%@page import="objet.Profil"%>
<%@page import="objet.V_profil"%>
<% V_profil[] b = (V_profil[])request.getAttribute("v_profil");%>
<% Profil[] p = (Profil[])request.getAttribute("profil");%>
<main id="main" class="main">
    <section class="section">
        <form class="row g-3" action="Filtrer_profil" method="post">
                <div class="col-12">
                    <label for="unite" class="form-label">Profil</label>
                    <select class="form-select" aria-label="Default select example" name="idprofil" id="categorie">
                        <%for(int i=0; i<p.length; i++){%>
                        <option value="<%out.print(p[i].getIdprofil());%>"><%out.print(p[i].getLibelle());%></option>
                      <%}%>
                    </select>
                </div>   
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
              </form>
        
      <div class="row">
          <div class="col-lg-12">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Liste Personne</h5>
              <!-- Vertical Form -->
             
                <!-- Table with stripped rows -->
              <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">Personne</th>
                               <th scope="col">Profil</th>
                                <th scope="col">Taux</th>
                              </tr>
                            </thead>
                           <tbody>
                    <%for(int i=0; i< b.length;i++){%>
                  <tr>
                    <th scope="row"><%out.print(b[i].getNom());%></th>
                    <td><%out.print(b[i].getProfil());%> ar</td>
                    <td><%out.print(b[i].getTaux());%> ar</td>
                    
                  </tr>
                  <%}%>
                </tbody>
                          </table>
              <!-- End Table with stripped rows --><!-- Vertical Form -->
            </div>
            </div>
          </div>
        </div>
    </section>
</main>         
