<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
  }

  form {
    display: grid;
    place-items: center;
    background-color: #ffffff;
    border: 1px solid #cccccc;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: 300px;
    margin: 100px auto;
  }

  form input[type="text"],
  form textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #cccccc;
    border-radius: 3px;
  }

  form button {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    border-radius: 3px;
    padding: 10px 20px;
    cursor: pointer;
    width: 100%;
  }

  form button:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>
<jsp:include page="navbar.jsf"></jsp:include>
<br/><br/><br/><br/>
<form method="get" action="addServlet">
  <input type="text" placeholder="Email" value="${user.email}" name="email" readonly/><br/>
  <input type="text" placeholder="Project Title" name="ptitle" /><br/>
  <textarea placeholder="Project Description" name="pdescription"></textarea>
  <button type="submit">Add Project</button>
</form>
</body>
</html>
