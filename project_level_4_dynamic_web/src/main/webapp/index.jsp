<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Student App</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        text-align: center;
        background: #fff;
        padding: 50px 70px;
        border-radius: 12px;
        box-shadow: 0 2px 12px rgba(0,0,0,0.1);
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    p {
        color: #666;
        margin-bottom: 30px;
    }

    a {
        display: inline-block;
        text-decoration: none;
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border-radius: 6px;
        transition: background-color 0.2s ease;
        font-weight: bold;
    }

    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Welcome to Student Management App</h2>
        <p>Manage your students easily — Add, Edit, Delete, and View all in one place.</p>
        <a href="student?option=list">View Students</a>
    </div>
</body>
</html>
