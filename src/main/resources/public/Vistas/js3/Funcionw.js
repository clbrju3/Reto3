function traerInformacio(){
$.ajax({
url:"http://localhost:8080/api/Category/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    verCatego(respuestas)}
//Acá se puede validar la respuesta.
});
}
function BuscarunoCatego(ide){
let ider=parseInt(ide,10);
$.ajax({
url:"http://localhost:8080/api/Category/"+ide,
type:"GET",
datatype:"JSON",
success:function(respuesta){
cositasCatego(respuesta);
alert("bien");}
});
}
function verCatego(items){
$("#resultadorcatego").empty();
$("#resultadorcatego").append("<ul>");
for(i=0;i<items.length;i++){
$("#resultadorcatego").append("<li><a onClick='BuscarunoCatego("+items[i].id+")'>"+items[i].name+"</a></li>");
}

}
function cositasCatego(respuesta){
var bicis;
if(respuesta.bikes.length==0){
bicis+="No hay bicicletas";}
else{
for (i=0;i<respuesta.bikes.length;i++){
bicis+="['"+respuesta.bikes[i].name+"']";
}}
    $("#infocatego").empty();
    $("#infocatego").append("<table border ='1'><thead><tr><th>Id</th> <th>Nombre</th> <th>Descripcion</th> <th>Bicicletas</th><th></th></tr></thead>\n");
    $("#infocatego").append("<tbody><tr><td>"+respuesta.id+"</td><td >"+respuesta.name+"</td><td >"+respuesta.description+"</td><td >"+bicis+"</td></tr></tbody></table>");
}
function ActCatego(){
let myData={
        id:$("#idc").val(),
        name:$("#catego").val(),
        description:$("#descrip").val(),
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Category/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
           alert("Actualizado")}});
}
function GuaCatego(){
    let myData={
        id:$("#idc").val(),
        name:$("#catego").val(),
        description:$("#descrip").val(),
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://localhost:8080/api/Category/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
        traerInformacio();
           alert("Guardado")}});
}


function EliCatego(){
let id=$("#idbelim").val();
    $.ajax({
        url:"http://localhost:8080/api/Category/"+id,
        type:"DELETE",
        contentType:"application/json",
        success:function(respuestas){
        alert("eliminado");
        id:$("#idc").val("");
                messagetext:$("#catego").val("");

           }});
}