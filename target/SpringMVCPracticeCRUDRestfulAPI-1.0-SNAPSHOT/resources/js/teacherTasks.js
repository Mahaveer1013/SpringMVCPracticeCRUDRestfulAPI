/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//alert("yes");

function teacherAddTask() {
    let task = $("#teachersTask").val();
    if(task==="") task="a";
    $.ajax({
        url: "/SpringMVCPracticeCRUDRestfulAPI/task/"+task,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({"name":task}),
        success: function(data) {
            $("#teacherCurrentResult").html(data.name);
        },
        error: function(error) {
            $("#teacherCurrentResult").html(error.responseJSON.message);
        }
    });
}

function teacherDeleteTask() {
    let task = $("#teachersTask").val();
    if(task==="") task="a";
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/task/"+task,
       type: "DELETE",
       success: function(data) {
           $("#teacherCurrentResult").html(data.name);
       },
       error: function(error) {
           $("#teacherCurrentResult").html(error.responseJSON.message);
       }
    });
}

function teacherShowTasks() {
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/task",
       type: "GET",
       success: function(data) {
           if(data.length===0) {
               $("#teacherCurrentResult").html("No tasks found");
           } else {
               $("#teacherCurrentResult").html("Total Number of tasks : "+data.length);
               for(let key in data) {
                   $("#teacherCurrentResult").append("<br>"+data[key].name);
               }
           }
       },
       error: function(error) {
           $("#teacherCurrentResult").html(error.responseJSON.message);
       }
    });
}