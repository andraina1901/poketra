var form = document.getElementById("insert_reca"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});


var idReception;
function test2(event){
    idReception= event.target.getAttribute("idReception");
    console.log(idReception +"ato am test 2222");
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

var code;
var quantite;
function getParam(){
    code = document.getElementById("codeko");
    quantite= document.getElementById("quantiteko"); 
    console.log(code+"   "+quantite);
}

function insertReca(){
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
        formData.append("idReception",idReception);
        formData.append("code", code.value);
        formData.append("quantite",quantite.value);
        console.log(code+"  "+quantite);
        $.ajax({
            type: "POST",
            url: "/Commerce/Insert_reca",
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

