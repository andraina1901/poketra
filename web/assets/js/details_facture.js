var form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

var idFacture;
var bouts = document.querySelectorAll(".bout_det");
function testfac(event){
    idFacture= event.target.getAttribute("idFacture");
    console.log(idFacture);
}

//bouts.forEach(bouton,()=>{
//    console.log()
//});

function setHtml(objet){
    let tbody = document.getElementById("details2");
    tbody.innerHTML='';
    let tr = document.createElement("tr");
    for(let i=0; i<objet.length; i++){
        let tr = document.createElement("tr");
        tr.innerHTML = `
            <td>`+objet[i].reference+`</td>
            <td>`+objet[i].nom+`</td>
            <td>`+objet[i].quantite+`</td>
            <td>`+objet[i].unite+`</td>
            <td>`+objet[i].prix_unitaire+`</td>
        `;
        tbody.appendChild(tr);
    }
}

function getDetailsfac(){
    valide().then(function(objet) {
        setHtml(objet);
    }).catch(function(error) {
        console.error(error);
    });
}

function valide(){
    return new Promise(function(resolve, reject) {
        let formData = new FormData();
        formData.append("idFacture",idFacture);
        console.log(idFacture+"idFacture");
        $.ajax({
            type: "POST",
            url: "/Commerce/Details_fac",
            data: formData,
            processData: false,
            contentType: false,
            enctype: "multipart/form-data",
            success: function(response) {
                var obj = response;
                resolve(obj);
            },
            error: function(error) {
                reject(error);
            }
        });
    });
}

