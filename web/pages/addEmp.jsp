<%--
  Created by IntelliJ IDEA.
  User: hyling
  Date: 2023/4/3
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/safe/empServlet?method=insert" method="post">
    姓名:<input type="text" name="name"><br>
    工资:<input type="text" name="salary"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
