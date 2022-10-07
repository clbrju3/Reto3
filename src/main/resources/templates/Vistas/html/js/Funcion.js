
function traerInformacion(){
$.ajax({
url:"http://140.84.191.220:8080/api/Bike/all",
type:"GET",
datatype:"JSON",
success:function(respuesta){
    console.log(respuesta.length);
    ver(respuesta.items)
    vere(respuesta.items)}
//Acá se puede validar la respuesta.
});
}
function Buscaruno(){
let ide=$("#idr").val();
let ider=parseInt(ide,10);
$.ajax({
url:"http://140.84.191.220:8080/api/Bike/:"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
vere(respuesta.items)
alert("bien");}
});
}
function Actualizar(){
let myData={
        id:$("#idb").val(),
        brand:$("#brandb").val(),
        model:$("#modelb").val(),
        category_id:$("#category_idb").val(),
        name:$("#nameb").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Bike/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuesta){
           traerInformacion();
           alert("Actualizado")}});
}
function Guardar(){
    let myData={
        id:$("#idb").val(),
        brand:$("#brandb").val(),
        model:$("#modelb").val(),
        category_id:$("#category_idb").val(),
        name:$("#nameb").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Bike/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuesta){
        traerInformacion();
           alert("Guardado")}});
}
function ver(items){
$("#resultado").empty();
$("#resultado").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultado").append("<li><a href='#infobici'>"+items[i].name+"</a></li>");
}

}
function vere(items){
$("#infobici").empty();
$("#infobici").append("<span>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
for(i=0;items.length;i++){
$("#infobici").append("<h2>"+"   "+items[i].name+"    </h2>");
$("#infobici").append("<h3>"+items[i].id+"</h3>");
$("#infobici").append("<h3>"+"  "+items[i].brand+"</h3>");
$("#infobici").append("<h3>"+"    "+items[i].model+"</h3>");
$("#infobici").append("<h3>"+"   "+items[i].category_id+"</h3>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
$("#infobici").append("<br>");
}
$("#infobici").append("</span>");

}
function Eliminar(){
let myData={
id:$("#ida").val()}
let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Bike/delete",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuesta){
        alert("eliminado");
        traerInformacion();
        id:$("#idb").val("");
                brand:$("#brandb").val("");
                model:$("#modelb").val("");
                category_id:$("#category_idb").val("");
                name:$("#nameb").val("");
           }});
}
