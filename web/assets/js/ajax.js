let form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

var category = document.getElementById("categorie");
var code = document.getElementById("code");
var nom = document.getElementById("nom");
var unite = document.getElementById("unite");
var type = document.getElementById("type");

function setHtml(objet){
    let tbody = document.getElementById("coordonnee-table");
    var selectedText = category.options[category.selectedIndex].text;
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <th>`+objet+`</th>
        <td>`+selectedText+`</td>
        <td>`+code.value+`</td>
        <td>`+nom.value+`</td>
        <td>`+unite.value+`</td>
    `;
    tbody.appendChild(tr);
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
            url: "/Commerce/Article_trait",
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



