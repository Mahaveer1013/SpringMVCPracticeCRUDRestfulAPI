/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function insert() {
    let id = $("#id").val();
    if(id === "") id=0;
    let name = $("#name").val();
    let age = $("#age").val();
    if(age === "") age=0;
    let course = $("#course").val();
    $.ajax({
        url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({"id":id,"name":name,"age":age,"course":course}),
        success: function(data) {
            $("#currentResult").html("Id: "+data.id+"<br>Name: "+data.name+"<br>Age: "+data.age+"<br>Course: "+data.course);
        },
        error: function(data) {
            console.log(data);
            $("#currentResult").html(data.responseJSON.message);
        }
    });
}

function read() {
    let id = $("#id").val();
    if(id === "") id=0;
    $.ajax({
        url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id,
        type: "GET",
        success: function(data) {
            console.log(data);
            $("#currentResult").html("Id: "+data.id+"<br>Name: "+data.name+"<br>Age: "+data.age+"<br>Course: "+data.course);
        },
        error: function(data) {
            console.log(data);
            $("#currentResult").html(data.responseJSON.message);
        }
    });
}

function selectAll() {
    $.ajax({
        url: "/SpringMVCPracticeCRUDRestfulAPI/student",
        type: "GET",
        success: function(data) {
            console.log(data);
            if(data.length === 0) {
                $("#currentResult").html("No records found");
            } else {
                $("#currentResult").html("Total Number of records : "+data.length);
                for(let key in data) {
                    $("#currentResult").append("<br><br>Id: "+data[key].id+"<br>Name: "+data[key].name+"<br>Age: "+data[key].age+"<br>Course: "+data[key].course);
                }
            }
        }
    });
}

function remove() {
    let id = $("#id").val();
    if(id === "") id=0;
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id,
       type: "DELETE",
       success: function(data) {
            $("#currentResult").html("Id: "+data.id+"<br>Name: "+data.name+"<br>Age: "+data.age+"<br>Course: "+data.course);
        },
        error: function(data) {
            console.log(data);
            $("#currentResult").html(data.responseJSON.message);
        }
    });
}

function update() {
    let id = $("#id").val();
    if(id === "") id=0;
    let name = $("#name").val();
    let age = $("#age").val();
    if(age === "") age=0;
    let course = $("#course").val();
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id,
       type: "PUT",
       contentType: "application/json",
       data: JSON.stringify({"id":id,"name":name,"age":age,"course":course}),
       success: function(data) {
            $("#currentResult").html("Id: "+data.id+"<br>Name: "+data.name+"<br>Age: "+data.age+"<br>Course: "+data.course);
        },
        error: function(data) {
            console.log(data);
            $("#currentResult").html(data.responseJSON.message);
        }
    });
}


function showStudentDetails() {
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/studentdetails",
       type: "GET",
       success: function(data) {
           if(data.length===0) $("#currentResult").html("No record found");
           else {
               let result = "Total Number Of Records Are: " + data.length;
               result+="<br><table><tr><th>Id</th><th>Name</th><th>Age</th><th>Course</th><th>Task</th></tr>";
               for(let key in data) {
                   result+="<tr><td>"+data[key].id+"</td><td>"+data[key].name+"</td><td>"+data[key].age+"</td><td>"+data[key].course+"</td><td>"+data[key].task_name+"</td></tr>";
                   // taskdetails
               }
               result+="</table>";
               $("#currentResult").html(result);
           }
       },
       error: function(error) {
           $("#currentResult").html(error.responseJSON.message);
       }
    });
}