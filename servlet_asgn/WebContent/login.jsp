<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${param.status}<br>

<form action="loginController" method="post">
    <table>
        <tr>
            <td>Enter username:</td>
            <td><input type="text" name="username" id="usernameId" required /></td>
            <td><label id="usernameMsg"></label></td>
        </tr>

        <tr>
            <td>Enter password:</td>
            <td><input type="password" name="password" id="passwordId" required /></td>
            <td><label id="passwordMsg"></label></td>
        </tr>

        <tr>
            <td><input type="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>