
function traerInformacionCliente(){
$.ajax({
url:"http://localhost:8080/api/Client/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    verCliente(respuestas)}
//Acá se puede validar la respuesta.
});
}

function verCliente(items){
$("#resultador").empty();
$("#resultador").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultador").append("<li><a onClick='BuscarunoCliente("+items[i].idClient+")'>"+items[i].name+"</a></li>");
}}
function BuscarunoCliente(ide){
let ider=parseInt(ide,10);
$.ajax({
url:"http://localhost:8080/api/Client/"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
cositasCliente(respuesta);
alert("bien");}
});
}

function cositasCliente(respuesta){
var mensajes;
var reservaciones;
if(respuesta.messages.length==0){
mensajes+="No hay mensajes";}
else{
for (i=0;i<respuesta.messages.length;i++){
mensajes+="['"+respuesta.messages[i].messageText+"']";
}}
if(respuesta.reservations.length==0){
reservaciones+="No hay reservaciones";}
else{
for (i=0;i<respuesta.reservations.length;i++){
var jose=respuesta.reservations[i].devolutionDate;
reservaciones+="['"+jose+"']";}
}
    $("#infobicic").empty();
    $("#infobicic").append("<table border ='1' class='default'><thead><tr><th>Id</th> <th>Email</th> <th>Año</th> <th>Contraseña</th> <th>Nombre</th><th>Mensajes</th><th>Reservaciones</th></tr></thead>");
    $("#infobicic").append("<tbody><tr><td colspan='2'>"+respuesta.idClient+"</td><td>"+respuesta.email+"</td><td >"+respuesta.age+"</td><td>"+respuesta.password+"</td><td >"+respuesta.name+"</td><td>"+mensajes+"</td><td>"+reservaciones+"</td></tr></tbody></table>");
}
function ActClient(){
let myData={
        id:$("#idb").val(),
        name:$("#nameb").val(),
        password:("#password").val(),
        email:$("#emab").val(),
        age:$("#eda").val(),
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Client/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
           traerInformacionCliente();
           alert("Actualizado")}});
}
function GuaClient(){
    let myData={
        id:$("#idb").val(),
        name:$("#nameb").val(),
        email:$("#emab").val(),
        password:$("#password").val(),
        age:$("#eda").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Client/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
        traerInformacionCliente();
           alert("Guardado")}});
}


function EliClient(){
let idClient=$("#idbe").val();
    $.ajax({
        url:"http://localhost:8080/api/Client/"+idClient,
        type:"DELETE",
        contentType:"application/json",
        success:function(respuestas){
        alert("eliminado");
        traerInformacionCliente();
        id:$("#idb").val("");
                email:$("#emab").val("");
                age:$("#eda").val("");
                name:$("#nameb").val("");
           }});
}