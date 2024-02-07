<%@page import="objet.V_matiere_look"%>
<% V_matiere_look[] v = (V_matiere_look[]) request.getAttribute("result");%>
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
                  </tr>
                </thead>
                <tbody>
                    <%for(int i=0; i< v.length;i++){%>
                  <tr>
                    <th scope="row"><%out.print(v[i].getIdmatiere_premiere());%></th>
                    <td><%out.print(v[i].getLibelle());%></td>
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