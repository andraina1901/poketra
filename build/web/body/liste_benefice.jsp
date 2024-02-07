<%@page import="objet.Benefice"%>
<% Benefice[] b = (Benefice[])request.getAttribute("prix");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-12">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Liste Poketra</h5>
              <!-- Vertical Form -->
             
                <!-- Table with stripped rows -->
              <table class="table">
                            <thead>
                                
                              <tr>
                                <th scope="col">Poketra</th>
                               <th scope="col">Prix de revient</th>
                                <th scope="col">Prix de vente</th>
                                <th scope="col">Bénéfice</th>
                              </tr>
                            </thead>
                           <tbody>
                    <%for(int i=0; i< b.length;i++){%>
                  <tr>
                    <th scope="row"><%out.print(b[i].getLibelle());%></th>
                    <td><%out.print(b[i].getPrix_revient());%> ar</td>
                    <td><%out.print(b[i].getPrix_vente());%> ar</td>
                    
                    <td><%out.print(b[i].getBenefice());%> ar</td>
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
