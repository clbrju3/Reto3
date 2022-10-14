function traerMensaje(){
$.ajax({
url:"http://localhost:8080/api/Message/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    verMensaje(respuestas)}
//Acá se puede validar la respuesta.
});
}

function verMensaje(items){
$("#resultadormensaje").empty();
$("#resultadormensaje").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultadormensaje").append("<li><a onClick='BuscarunoMensaje("+items[i].idMessage+")'>"+items[i].bike.name+"</a></li>");
}}
function BuscarunoMensaje(ide){
let ider=parseInt(ide,10);
$.ajax({
url:"http://localhost:8080/api/Message/"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
cositasMensaje(respuesta);
alert("bien");}
});
}

function cositasMensaje(respuesta){
    $("#infobicim").empty();
    $("#infobicim").append("<table border ='1' class='default'></thead><tr><th>Id</th><th>Bicicleta</th><th>Cliente</th> <th>Mensaje</th> </tr></thead>");
    $("#infobicim").append("<tbody><tr><td colspan='1'>"+respuesta.idMessage+"</td><td >"+respuesta.bike.name+"</td><td >"+respuesta.client.name+"</td><td >"+respuesta.messageText+"</td></tr></tbody></table>");
}
function ActMensa(){
let myData={
        idMessage:$("#idbro").val(),
        messageText:$("#messa").val(),
        client:{idClient:$("#idCLient").val()},
        bike:{id:$("#idBike").val()},
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Message/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
        traerMensaje(respuestas);
           alert("Actualizado")}});
}
function GuaMensa(){
    let myData={
        idMessage:$("#idbro").val(),
        messageText:$("#messa").val(),
        client:{idClient:$("#idCLient").val()},
        bike:{id:$("#idBike").val()},
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Message/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
        traerMensaje(respuestas);
           alert("Guardado")}});
}


function EliMensa(){

let idMessage=$("#idbroe").val();
    $.ajax({
        url:"http://localhost:8080/api/Message/"+idMessage,
        type:"DELETE",
        contentType:"application/json",
        success:function(respuestas){
        traerMensaje(respuestas);
        alert("eliminado");
        id:$("#idbro").val("");
                messagetext:$("#messa").val("");

           }});
}