<%@ page import="model.Student" %>
<%
    Student s = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 400px;
        margin: 80px auto;
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 25px;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    label {
        margin-top: 10px;
        font-weight: bold;
        color: #444;
    }

    input[type="text"],
    input[type="number"] {
        padding: 8px;
        border-radius: 5px;
        border: 1px solid #ccc;
        margin-top: 5px;
    }

    input[type="submit"] {
        margin-top: 20px;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .back-link {
        display: inline-block;
        margin-top: 15px;
        text-decoration: none;
        color: #555;
        font-size: 14px;
    }

    .back-link:hover {
        color: #000;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Edit Student</h2>
        <form action="student" method="post">
            <input type="hidden" name="id" value="<%= s.getId() %>">

            <label>Name:</label>
            <input type="text" name="name" value="<%= s.getName() %>" required>

            <label>Age:</label>
            <input type="number" name="age" value="<%= s.getAge() %>" required>

            <label>Gender:</label>
            <input type="text" name="gender" value="<%= s.getGender() %>" required>

            <label>Year:</label>
            <input type="text" name="year" value="<%= s.getYear() %>" required>

            <label>Department:</label>
            <input type="text" name="department" value="<%= s.getDepartment() %>" required>

            <input type="submit" name="option" value="update">
        </form>

        <a href="student?option=list" class="back-link"> Back to Student List</a>
    </div>
</body>
</html>
