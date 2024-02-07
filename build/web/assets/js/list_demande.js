function select(){
    let parent = document.querySelectorAll(".active")[1];
    eledrop = parent.lastElementChild.lastElementChild.lastElementChild.previousElementSibling.lastElementChild;
    console.log(eledrop.getAttribute("iddept"));
}


function ajout(){
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
