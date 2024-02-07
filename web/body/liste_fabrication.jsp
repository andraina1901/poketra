<%@page import="objet.Reste"%>
<%Reste[] r = (Reste[]) request.getAttribute("reste");%>
<main id="main" class="main">
    <section class="section">
      <div class="row">
          <div class="col-lg-12">
           <div class="card">
            <div class="card-body">
              <h5 class="card-title">Reste matiere premiere</h5>
              <!-- Vertical Form -->
             
                <!-- Table with stripped rows -->
              <table class="table">
                            <thead>
                              <tr>
                                <th scope="col">Matiere Premiere</th>
                                <th scope="col">Quantité</th>
                               
                              </tr>
                            </thead>
                            <tbody>
                                  <%for(int i=0; i< r.length;i++){%>
                  <tr>
                    <th scope="row"><%out.print(r[i].getLibelle());%></th>
                    <td><%out.print(r[i].getReste());%></td>
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
