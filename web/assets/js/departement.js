var boutons = document.querySelectorAll("#supprimer");
const oui = document.getElementById("oui");
var bout_ajouts = document.querySelectorAll(".bout_ajout");
var element = document.querySelector("#coordonnee-table");
var code = document.querySelector("input[name='code']");
var quantite = document.querySelector("input[name='quantite']");
var eledrop;
var selects = document.querySelectorAll("#profile-tab");

function select(){
    let parent = document.querySelectorAll(".active")[1];
    eledrop = parent.lastElementChild.lastElementChild.lastElementChild.previousElementSibling.lastElementChild;
    console.log(eledrop.getAttribute("iddept"));
}

selects.forEach(s => {
    s.addEventListener("click",function(){
       setTimeout(select,500);
    });
}); 


bout_ajouts.forEach(bouton => {
    bouton.addEventListener("click",function(){
        element = bouton.previousElementSibling.lastElementChild;
    });
}); 




var tosuppr;
supprimer();


function supprimer(){
    boutons.forEach(bouton => {
    bouton.addEventListener("click",function(){
        tosuppr = bouton.parentElement.parentElement;
        console.log(tosuppr);
    });
});  
}

function ajout(){
    envoyer().then(function(objet) {
        setHtml(objet);
    }).catch(function(error) {
        console.error(error);
    });
}

function setHtml(objet){
    if(objet!="error505"){
        const el_added = document.createElement("tr");
        el_added.innerHTML =  `
        <th scope="row">`+code.value+`</th>
        <td>`+objet+`</td>
        <td>`+quantite.value+`</td>
        <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#supprimermodal" id="supprimer">
        <i class="bi bi-trash"></i> Supprimer</button></td>
        `;
        code.value = "";
        quantite.value = "";
        element.appendChild(el_added);
        boutons = document.querySelectorAll("#supprimer");
        supprimer();
    }   
}

function envoyer(){
return new Promise(function(resolve, reject) {
        form = document.getElementById("filter_form");
        let formData = new FormData(form);
        formData.append("idDept",element.getAttribute("iddept").toString());
        $.ajax({
            type: "POST",
            url: "/Commerce/Departement_trait",
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                var obj = response;
                console.log(obj);
                resolve(obj);
            },
            error: function(error) {
                reject(error);
            }
        });
    });
}

const defaut_boutton = document.getElementById("ajout_button");
defaut_boutton.addEventListener("click", function(){
});
        
function supp(){
return new Promise(function(resolve, reject) {
        let formData = new FormData();
        formData.append("idDept",eledrop.getAttribute("iddept").toString());
        formData.append("code",tosuppr.getAttribute("value").toString());
        $.ajax({
            type: "POST",
            url: "/Commerce/DropBesoin",
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

oui.addEventListener("click",function(){
    supp().then(function(objet) {
        if(objet=="202"){
            eledrop.removeChild(tosuppr);
            tosuppr=null;
        }
    }).catch(function(error) {
        console.error(error);
    });
    
});