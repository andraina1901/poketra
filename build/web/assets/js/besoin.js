//const bouts = document.querySelectorAll("#but");
//
//var idDept;
//bouts.forEach(function(bout){
//    bout.addEventListener("click", function(){
//        idDept = bout.getAttribute("iddept");
//        console.log(bout);
//    });
//});
////let inpu = document.createElement("input");
////inpu.setAttribute("idDept",inpu);
//
//
//var form2 = document.getElementById("filter_form"); 
//form2.addEventListener("submit", function (event) {
//    event.preventDefault(); 
//});
//
//function setHtml(objet){
//    let tbody = document.getElementById("tbody");
//    tbody.innerHTML = "";
//        let tr = document.createElement("tr");
//        tr.innerHTML = `
//            <td>`+objet+`</td>
//            <td>`+objet.nomArticle+`</td>
//            <td>`+objet.quantite_initiale+`</td>
//            <td>`+objet.quantite_finale+`</td>
//            <td>`+objet.nomMagasin+`</td>
//            <td>`+objet.prix_unitaire+`</td>
//        `;
//        tbody.appendChild(tr);
//    
//}
//
//function Ajout(){
//    envoyer().then(function(objet) {
//        setHtml(objet);
//    }).catch(function(error) {
//        console.error(error);
//    });
//}
//
//function envoyer(){
//return new Promise(function(resolve, reject) {
//        let formData = new FormData(form2);
//        formData.append("idDept",idDept);
//        $.ajax({
//            type: "POST",
//            url: "/Commerce/Departement_trait",
//            data: formData,
//            processData: false,
//            contentType: false,
//            success: function(response) {
//                var obj = response;
//                resolve(obj);
//            },
//            error: function(error) {
//                reject(error);
//            }
//        });
//    });
//}
//
//
//
//
//
