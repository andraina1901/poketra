var form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

var idReception;
var bouts = document.querySelectorAll(".bout_det");
function test(event){
    idReception= event.target.getAttribute("idReception");
    console.log(idReception);
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
        `;
        tbody.appendChild(tr);
    }
}

function getDetails(){
    valide().then(function(objet) {
        setHtml(objet);
    }).catch(function(error) {
        console.error(error);
    });
}

function valide(){
    return new Promise(function(resolve, reject) {
        let formData = new FormData();
        formData.append("idReception",idReception);
        console.log(idReception+"idReception");
        $.ajax({
            type: "POST",
            url: "/Commerce/Details_rec",
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

