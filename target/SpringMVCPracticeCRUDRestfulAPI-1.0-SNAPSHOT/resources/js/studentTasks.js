/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//alert("yes");

function studentAddTask() {
    let id = $("#tasksStudent").val();
    if(id === "") id=0;
    let task = $("#tasksTask").val();
    if(task==="") task="a";
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id+"/task",
       type: "POST",
       contentType: "application/json",
       data: JSON.stringify({"id":id,"task":task}),
       success: function(data) {
           $("#studentTaskResult").html("Id: "+data.id+"<br>Task: "+data.task);
       },
       error: function(error) {
           $("#studentTaskResult").html("Please enter a valid StudentId/task Name only ONCE<br>");
           $("#studentTaskResult").append(error.responseJSON.message);
       }
    });
}

function studentDeleteTask() {
    let id = $("#tasksStudent").val();
    if(id === "") id=0;
    let task = $("#tasksTask").val();
    if(task==="") task="a";
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id+"/task/"+task,
       type: "DELETE",
       success: function(data) {
           $("#studentTaskResult").html("Id: "+data.id+"<br>Task: "+data.task);
       },
       error: function(error) {
           $("#studentTaskResult").html(error.responseJSON.message);
       }
    });
}

function studentShowTasks() {
    let id = $("#tasksStudent").val();
    if(id==="") id=0;
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/student/"+id+"/task",
       type: "GET",
       success: function(data) {
           console.log(data);
           if(data.length===0) $("#studentTaskResult").html("This student has no tasks assigned");
           else {
               $("#studentTaskResult").html("Total number of tasks for student "+id+" are: "+data.length);
                for(let key in data) {
                    $("#studentTaskResult").append("<br>"+data[key].task_details.name); 
                }
           }
       },
       error: function(error) {
           $("#studentTaskResult").html(error.responseJSON.message);
       }
    });
}