var form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

function test(event){
    idDemande = event.target.getAttribute("iddem");
    console.log(idDemande);
}

init();

function setHtml(objet){
    let tbody = document.getElementById("coordonnee-table");
    for(let i=0; i<objet.length; i++){
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <th scope="row"> </th>
        <td>`+objet[i].idDemande+`</td>
        <td>`+objet[i].nom+`</td>
        <td>`+objet[i].etat+`</td>
        <td>`+objet[i].date+`</td>
        <td><button type="button" id="`+objet[i].idDemande_proforma+`" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#uploadmodal">Upload</button></td>
    `;
    tbody.appendChild(tr);
    }
}

function Ajout(){
    envoyer().then(function(objet) {
        setHtml(objet);
    }).catch(function(error) {
        console.error(error);
    });
}

function envoyer(){
return new Promise(function(resolve, reject) {
        form = document.getElementById("filter_form");
        let formData = new FormData(form);

        $.ajax({
            type: "POST",
            url: "/Commerce/AskProforma",
            data: formData,
            processData: false,
            contentType: false,
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

function upload(){
return new Promise(function(resolve, reject) {
        form = document.getElementById("upload");
        let formData = new FormData(form);
        formData.append("idDemande_proforma",idDemande);
        $.ajax({
            type: "POST",
            url: "/Commerce/AddProforma",
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

