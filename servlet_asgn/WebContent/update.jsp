<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="employeeController.do" method="post">
<input type="hidden" name="id" value="${employee.id}"/>
    <table>
        <tr>
            <td>Enter name:</td>
            <td><input type="text" name="pname" id="nameId" value="${employee.ename}" readonly/></td>
            <td><label id="nameMsg"></label></td>
        </tr>

        <tr>
            <td>Enter city:</td>
            <td><input type="text" name="city" id="cityId" value="${employee.city}" /></td>
            <td><label id="cityMsg"></label></td>
        </tr>


        <tr>
            <td>Enter Design:</td>
            <td><input type="text" name="desi" id="desiId" value="${employee.desi}"/></td>
            <td><label id="desiMsg"></label></td>
        </tr>


        <tr>
            <td>Enter salary:</td>
            <td><input type="text" name="salary" id="salaryId" value="${employee.salary}" /></td>
            <td><label id="salaryMsg"></label></td>
        </tr>

        <tr>
            <td><input type="submit" onclick="return validate();" /></td>
        </tr>
    </table>


</form>
</body>
</html>