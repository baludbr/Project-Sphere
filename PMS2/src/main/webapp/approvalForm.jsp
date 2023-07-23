<!DOCTYPE html>
<html>
<head>
    <title>Project Approval Form</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 16px;
        }

        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='6'%3E%3Cpath d='M1 1l5 4 5-4'/%3E%3C/svg%3E") no-repeat right #fff;
            background-position-x: calc(100% - 8px);
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<% String s=request.getParameter("data"); %>
<jsp:include page="navbar.jsf"></jsp:include>
<form action="approveForm" method="post">
    <label for="email">Email</label>
    <input type="text" id="email" name="email" value="${user.email}" required readonly>
    <br>
    <label for="id">Project Id:</label>
    <input type="text" id="id" name="id" value=${param['data']} required>
    <br>

    <label for="status">Approval Status:</label>
    <select id="status" name="status" required>
        <option value="approve">Approve</option>
        <option value="deny">Deny</option>
    </select>
    <br>

    <input type="submit" value="Submit">
</form>

</body>
</html>