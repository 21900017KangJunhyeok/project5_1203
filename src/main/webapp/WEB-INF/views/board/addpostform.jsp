<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Card here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addok" method="post">
<table id = "edit">
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Card:</td><td><input type="text" name="card"/></td></tr>
    <tr><td>Content:</td><td><input type="text" name="content"/></td></tr>
    <tr><td>price:</td><td><input type="text" name="price"/></td></tr>
    <tr><td>Installment:</td><td><input type="text" name="installment"/></td></tr>
</table>
    <button type="button" onclick="location.href='list'">목록보기</button>
    <button type="submit">등록하기</button>
</form>

</body>
</html>