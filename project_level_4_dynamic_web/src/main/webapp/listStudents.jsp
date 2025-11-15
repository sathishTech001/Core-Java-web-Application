<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 80%;
        margin: 50px auto;
        background: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        text-align: left;
        padding: 12px;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #007bff;
        color: white;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .btn {
        text-decoration: none;
        color: white;
        padding: 8px 12px;
        border-radius: 5px;
        margin: 0 4px;
        font-size: 14px;
    }

    .btn-edit {
        background-color: #28a745;
    }

    .btn-delete {
        background-color: #dc3545;
    }

    .btn-add {
        background-color: #007bff;
        float: right;
        margin-bottom: 15px;
    }

    .no-data {
        text-align: center;
        color: #777;
        font-style: italic;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Student List</h2>
        <a href="student?option=new" class="btn btn-add">+ Add Student</a>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students == null || students.isEmpty()) {
        %>
            <p class="no-data">No students available.</p>
        <%
            } else {
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Year</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
            <%
                for (Student s : students) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>
                <td><%= s.getGender() %></td>
                <td><%= s.getYear() %></td>
                <td><%= s.getDepartment() %></td>
                <td>
                    <a href="student?option=edit&id=<%= s.getId() %>" class="btn btn-edit">Edit</a>
                    <a href="student?option=delete&id=<%= s.getId() %>" 
                       class="btn btn-delete" 
                       onclick="return confirm('Are you sure to delete this student?');">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
        <% } %>
    </div>
</body>
</html>
