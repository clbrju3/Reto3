
function traerInformacionu(){
$.ajax({
url:"http://140.84.191.220:8080/api/Client/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    ver(respuestas.items)}
//Acá se puede validar la respuesta.
});
}
function Buscaruno(){
$("#infobici").empty();
let ider=$("#idr").val();
$.ajax({
url:"http://140.84.191.220:8080/api/Client/:"+ider,
type:"GET",
datatype:"JSON",
success:function(respuestas){
alert("bien");
$("#infobici").append("<h3>"+respuestas.id+" "+respuestas.name+" "+respuestas.brand+" "+respuestas.model+"</h3>");}
});
}
function Actualiza(){
let myData={
        id:$("#idb").val(),
        name:$("#nameb").val(),
        email:$("#emab").val(),
        age:$("#eda").val(),
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Client/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
           traerInformacionu();
           alert("Actualizado")}});
}
function Guarda(){
    let myData={
        id:$("#idb").val(),
        name:$("#nameb").val(),
        email:$("#emab").val(),
        age:$("#eda").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Client/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
        traerInformacionu();
           alert("Guardado")}});
}
function ver(items){
$("#resultador").empty();
$("#resultador").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultador").append("<li><a href=cliente.html>"+items[i].name+"</a></li>");
}

}

function Elimina(){
let myData={
id:$("#idbe").val()}
let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Client/delete",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
        alert("eliminado");
        traerInformacionu();
        id:$("#idb").val("");
                email:$("#emab").val("");
                age:$("#eda").val("");
                name:$("#nameb").val("");
           }});
}