var form = document.getElementById("etat_stock"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

//bouts.forEach(bouton,()=>{
//    console.log()
//});

function setHtml(objet){
    let tbody = document.getElementById("etat");
    tbody.innerHTML='';
    let tr = document.createElement("tr");
    for(let i=0; i<objet.length; i++){
        let tr = document.createElement("tr");
        tr.innerHTML = `
            <td>`+objet[i].codeArticle+`</td>
            <td>`+objet[i].nomArticle+`</td>
            <td>`+objet[i].quantite_initiale+`</td>
            <td>`+objet[i].quantite_finale+`</td>
            <td>`+objet[i].unite+`</td>
            <td>`+objet[i].nomMagasin+`</td>
        `;
        tbody.appendChild(tr);
    }
}

var code1;
var magasin1;
var date1;
var date2;
function getPar(){
    code1 = document.getElementById("code");
    magasin1= document.getElementById("magasin"); 
    date1= document.getElementById("date1"); 
    date2= document.getElementById("date2");
}



function search(){
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
        formData.append("code", code1.value);
        formData.append("magasin", magasin1.value);
        formData.append("date1", date1.value);
        formData.append("date2", date2.value);
        
        console.log(code1.value+"  "+magasin1.value+" "+date1.value+" "+date2.value);
        $.ajax({
            type: "POST",
            url: "/Commerce/Etat_trait",
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

