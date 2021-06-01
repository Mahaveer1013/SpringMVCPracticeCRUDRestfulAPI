<%-- 
    Document   : home
    Created on : May 19, 2021, 12:00:50 PM
    Author     : Thammana Srinivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono&display=swap" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/resources/js/student.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/studentTasks.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/teacherTasks.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>
    <body>
    <center>
        <h1>Students</h1>
        <label> <b>Id:</b> </label> <input type="number" id="id"><br>
        <label> <b>Name:</b> </label> <input type="text" id="name"><br>
        <label> <b>Age:</b> </label> <input type="number" id="age"><br>
        <label> <b>Course:</b> </label> <input type="text" id="course"><br><br>
        <input onclick="insert()" type="submit" value="INSERT"> <input onclick="read()" type="submit" value="SELECT">
        <input onclick="remove()" type="submit" value="DELETE"> <input onclick="update()" type="submit" value="UPDATE">
        <input onclick="selectAll()" type="submit" value="SELECT ALL"> 
        <input onclick="showStudentDetails()" type="submit" value="SHOW STUDENT DETAILS">
        <br><br> 
        <b><div id="currentResult"></div></b>
        <h1>Tasks</h1>
        <label> <b>Student Id:</b> </label> <input type="number" id="tasksStudent"><br>
        <label> <b>Task</b> </label> <input type="text" id="tasksTask"><br><br>
        <input onclick="studentAddTask()" type="submit" value="ADD TASK"> 
        <input onclick="studentDeleteTask()" type="submit" value="REMOVE TASK">
        <input onclick="studentShowTasks()" type="submit" value="SHOW TASKS">
        <br><br>
        <b><div id="studentTaskResult"></div></b>
        <h1>Teachers</h1>
        <label> <b>Task</b> </label> <input type="text" id="teachersTask"><br><br>
        <input onclick="teacherAddTask()" type="submit" value="ADD TASK"> 
        <input onclick="teacherDeleteTask()" type="submit" value="REMOVE TASK">
        <input onclick="teacherShowTasks()" type="submit" value="SHOW TASKS">
        <br><br>
        <b><div id="teacherCurrentResult"></div></b>
        <br><br>
    </center>
    </body>
</html>
