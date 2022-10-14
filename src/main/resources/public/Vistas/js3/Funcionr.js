
function traerInformacionReser(){
$.ajax({
url:"http://localhost:8080/api/Reservation/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    verReser(respuestas);
    }
//Acá se puede validar la respuesta.
});
}

function verReser(items){
$("#resultadorreser").empty();
$("#resultadorreser").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultadorreser").append("<li><a onClick='BuscarunoReser("+items[i].idReservation+")'>"+items[i].startDate+"</a></li>");
}}
function BuscarunoReser(ide){
let ider=parseInt(ide,10);
$.ajax({
url:"http://localhost:8080/api/Reservation/"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
cositasReser(respuesta);
alert("bien");}
});
}

function cositasReser(respuesta){
    $("#infobicireser").empty();
    $("#infobicireser").append("<table border ='1'class='default'><thead><tr><th>Id</th> <th>Reserva</th> <th>Devolución</th> </tr></thead>");
    $("#infobicireser").append("<tbody><tr><td  colspan='2'>"+respuesta.idReservation+"</td><td>"+respuesta.startDate+"</td><td>"+respuesta.devolutionDate+"</td><td>"+respuesta.status+"</td></tr><tbody></table>");
}
function ActReser(){
let myData={
        idReservation:$("#idre").val(),
        startDate:$("#start").val(),
        devolutionDate:("#devolution").val(),
        status:("#reservacion").val(),
        client:{idClient:$("#client").val()},
                bike:{id:$("#bike").val()},
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Reservation/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
           traerInformacionReser();
           alert("Actualizado")}});
}
function GuaReser(){
    let myData={
        idReservation:$("#idre").val(),
        startDate:$("#start").val(),
        devolutionDate:$("#devolution").val(),
         status:("#reservacion").val(),
       client:{idClient:$("#client").val()},
               bike:{id:$("#bike").val()},
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Reservation/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
        traerInformacionReser();
           alert("Guardado")}});
}


function EliReser(){
let idReservation=$("#idbre").val();
    $.ajax({
        url:"http://localhost:8080/api/Reservation/"+idReservation,
        type:"DELETE",
        contentType:"application/json",
        success:function(respuestas){
        alert("eliminado");
        traerInformacionReser();
        id:$("#idb").val("");
                email:$("#start").val("");
                age:$("#devolution").val("");

           }});
}