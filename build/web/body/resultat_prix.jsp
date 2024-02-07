<%@page import="objet.V_prix"%>
<% V_prix[] v = (V_prix[]) request.getAttribute("prix");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <table class="table datatable">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Libelle</th>
                    <th scope="col">Prix</th>
                  </tr>
                </thead>
                <tbody>
                    <%for(int i=0; i< v.length;i++){%>
                  <tr>
                    <th scope="row"><%out.print(v[i].getIdmodel());%></th>
                    <td><%out.print(v[i].getLibelle());%></td>
                    <td><%out.print(v[i].getPrix());%> ar</td>
                  </tr>
                  <%}%>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>
    
</main>