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
        url: "/SpringMVCPracticeCRUDRestfulAPI/task",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({"task":task}),
        success: function(data) {
            $("#teacherCurrentResult").html(data.task);
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
           $("#teacherCurrentResult").html(data.task);
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
                   $("#teacherCurrentResult").append("<br>"+data[key].task);
               }
           }
       },
       error: function(error) {
           $("#teacherCurrentResult").html(error.responseJSON.message);
       }
    });
}

function showStudentDetails() {
    $.ajax({
       url: "/SpringMVCPracticeCRUDRestfulAPI/studentdetails",
       type: "GET",
       success: function(data) {
           if(data.length===0) $("#teacherCurrentResult").html("No record found");
           else {
               let result = "Total Number Of Records Are: " + data.length;
               result+="<br><table><tr><th>Id</th><th>Name</th><th>Age</th><th>Course</th><th>Task</th></tr>";
               for(let key in data) {
                   result+="<tr><td>"+data[key].sid+"</td><td>"+data[key].name+"</td><td>"+data[key].age+"</td><td>"+data[key].course+"</td><td>"+data[key].task+"</td></tr>";
               }
               result+="</table>";
               $("#teacherCurrentResult").html(result);
           }
       },
       error: function(error) {
           $("#teacherCurrentResult").html(error.responseJSON.message);
       }
    });
}