<%@page import="objet.V_matiere_model"%>
<% V_matiere_model[] v = (V_matiere_model[]) request.getAttribute("result");%>
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
                    <th scope="row"><%out.print(v[i].getLibelle());%></th>
                    <td><%out.print(v[i].getQuantite());%></td>
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