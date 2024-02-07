var form = document.getElementById("insert_fac"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});


var idReception;
function test3(event){
    idFacture= event.target.getAttribute("idFacture");
    console.log(idFacture +"ato am test 2222");
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

var code3;
var quantite3;
var pu3;
function getParam2(){
    code3 = document.getElementById("codeko");
    quantite3= document.getElementById("quantiteko"); 
    pu3 = document.getElementById("prixako")
    console.log(code3+"   "+quantite3+ " "+pu3);
}

function insertFac(){
    valide2().then(function(objet) {
        setHtml(objet);
    }).catch(function(error) {
        console.error(error);
    });
}

//console.log(code+"  "+quantite);

function valide2(){
    return new Promise(function(resolve, reject) {
        let formData = new FormData();
        formData.append("idFacture",idFacture);
        formData.append("code", code3.value);
        formData.append("quantite",quantite3.value);
        formData.append("pu",pu3.value);
        
    console.log(code3.value+"   "+quantite3.value+ " "+pu3.value);
        $.ajax({
            type: "POST",
            url: "/Commerce/Ajout_art",
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




