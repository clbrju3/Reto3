
function traerInformacion(){
$.ajax({
url:"http://localhost:8080/api/Bike/all",
type:"GET",
datatype:"JSON",
success:function(respuesta){
console.log(respuesta);

    verBici(respuesta);
    }
//Acá se puede validar la respuesta.
});
}

function ActBici(){
let myData={
        id:$("#idbici").val(),
                brand:$("#brandbici").val(),
                model:$("#modelb").val(),
                category:{id:$("#category_idb").val()},
                description:$("#descripb").val(),
                year:$("#year").val(),
                name:$("#namebici").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Bike/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuesta){
           traerInformacion();
           alert("Actualizado")}});
}
function GuaBici(){
    let myData={
        id:$("#idbici").val(),
        brand:$("#brandbici").val(),
        model:$("#modelb").val(),
        category:{id:$("#category_idb").val()},
        description:$("#descripb").val(),
        year:$("#year").val(),
        name:$("#namebici").val(),};
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Bike/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuesta){
        traerInformacion();
           alert("Guardado")}});
}
function verBici(items){
$("#resultado").empty();
$("#resultado").append("<ul>")
for(i=0;i<items.length;i++){
$("#resultado").append("<li><a onClick='BuscarunoBici("+items[i].id+")'>"+items[i].name+"</a></li>");
}}

function BuscarunoBici(ide){
let ider=parseInt(ide,10);
$.ajax({
url:"http://localhost:8080/api/Bike/"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
cositasBici(respuesta);
alert("bien");}
});
}

function cositasBici(respuesta){
console.log(respuesta.category.id);
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
    $("#infobici").empty();
    $("#infobici").append("<table border ='1' class='default'><thead><tr><th>Id</th> <th>Nombre</th> <th>Descripcion</th> <th>Marca</th> <th>Año</th> <th>Categoria</th><th>Mensajes</th><th>Reservaciones</th></tr></thead>");
    $("#infobici").append("<tbody><tr><td colspan='2'>"+respuesta.id+"</td><td >"+respuesta.name+"</td><td >"+respuesta.description+"</td><td>"+respuesta.brand+"</td><td >"+respuesta.year+"</td><td>"+respuesta.category.name+"</td><td>"+mensajes+"</td><td>"+reservaciones+"</td></tr></tbody></table>");
}

function EliBici(){
let id=$("#ida").val();
    $.ajax({
        url:"http://localhost:8080/api/Bike/"+id,
        type:"DELETE",
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
