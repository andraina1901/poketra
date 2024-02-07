let form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

var adresse = document.getElementById("adresse");
var contact = document.getElementById("contact");
var nom = document.getElementById("nom");
var mail = document.getElementById("mail");

function setHtml(){
    let tbody = document.getElementById("coordonnee-table");
    let adresse = document.getElementById("adresse");
    let contact = document.getElementById("contact");
    let nom = document.getElementById("nom");
    let mail = document.getElementById("mail");
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <th scope="row"> </th>
        <td>`+nom.value+`</td>
        <td>`+adresse.value+`</td>
        <td>`+contact.value+`</td>
        <td>`+mail.value+`</td>
        <td>2023-11-21</td>
    `;
    adresse.value="";
    nom.value="";
    mail.value="";
    contact.value="";
    
    tbody.appendChild(tr);
}

function Ajout(){
    envoyer().then(function(objet) {
        setHtml();
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
            url: "/Commerce/AddFournisseur",
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