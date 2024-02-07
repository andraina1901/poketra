var idpro;
function select(event){
    idpro = event.target.getAttribute("idpro");
    console.log(idpro);
}

let form = document.getElementById("filter_form"); 
form.addEventListener("submit", function (event) {
    event.preventDefault(); 
});

function Ajout(){
    envoyer();
    document.querySelector("input[name='code']").value="";
    document.querySelector("input[name='tva']").value="";
    document.querySelector("input[name='prix']").value="";
}

function envoyer(){
        form = document.getElementById("filter_form");
        let formData = new FormData(form);
        formData.append("idProforma",idpro);
        $.ajax({
            type: "POST",
            url: "/Commerce/Saisir",
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                var obj = response;
            },
            error: function(error) {
            }
        });
}