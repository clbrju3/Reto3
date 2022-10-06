function traerInformacio(){
$.ajax({
url:"http://140.84.191.220:8080/api/Message/all",
type:"GET",
datatype:"JSON",
success:function(respuestas){
    console.log(respuestas.length);
    ver(respuestas.items)}
//Acá se puede validar la respuesta.
});
}
function Actualiza(){
let myData={
        id:$("#idbro").val(),
        messagetext:$("#messa").val(),

        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Message/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
           alert("Actualizado")}});
}
function Guarda(){
    let myData={
        id:$("#idbro").val(),
        messagetext:$("#messa").val(),
        };
    let dataToSend=JSON.stringify(myData);
    console.log(dataToSend);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Message/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/json",
        complete:function(respuestas){
           alert("Guardado")}});
}


function Elimina(){
let myData={
id:$("#idbroe").val()}
let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://140.84.191.220:8080/api/Message/delete",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/json",
        success:function(respuestas){
        alert("eliminado");
        id:$("#idbro").val("");
                messagetext:$("#messa").val("");

           }});
}