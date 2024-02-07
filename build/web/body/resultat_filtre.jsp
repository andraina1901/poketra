<%@page import="com.google.gson.Gson"%>
<%@page import="objet.Statistique"%>
<%@page import="objet.Tous"%>
<% Statistique[] stat = (Statistique[]) request.getAttribute("resultat");%>

<% 
    int homme = 0;
    int femme = 0;
    for(int i=0; i< stat.length; i++){
        if(stat[i].getSexe().equals("masculin")){
            homme += stat[i].getNombre();
        }else if(stat[i].getSexe().equals("feminin")){
            femme += stat[i].getNombre();
        }
}%>          
<script src="assets/js/chart.js"></script>
<main id="main" class="main">
    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <table class="table ">
                <thead>
                  <tr>
                    <th scope="col">Sexe</th>
                    <th scope="col">Statistiques</th>
                  </tr>
                </thead>
                <tbody>
                    <%for(int i=0; i< stat.length; i++){%>
                        <tr>
                            <th scope="row"><%out.print(stat[i].getSexe());%></th>
                            <th scope="row"><%out.print(stat[i].getNombre());%></th>
                         </tr>
                    <%}%>
                  
                </tbody>
              </table>
              <!-- End Table with stripped rows -->
              <div class="chart">
                    <!--<div class="title"><h2>Graphe</h2></div>-->
                    <div style="width: 270px">
                        <canvas id="myChart"></canvas>
                        <script>
                            
                            const label = ["Masculin","Feminin"];
                        const values1 = [<%=homme %>, <%=femme %>];


                        const ctx = document.getElementById("myChart");

                        const data = {
                            labels: label,
                            datasets: [
                                {
                                    label: "# of Votes",
                                    data: values1,
                                    borderWidth: 1,
                                },
                            ],
                        };
                        new Chart(ctx, {
                            type: "doughnut",
                            data: data,
                            options: {
                                scales: {
                                    y: {

                                        beginAtZero: true,
                                    },
                                },
                            },
                        });
                        
                        </script>
                    </div>
                    <script src="assets/js/statistique.js"></script>
                </div>
            </div>
          </div>

        </div>
      </div>
    </section>
    
                    
    
</main>