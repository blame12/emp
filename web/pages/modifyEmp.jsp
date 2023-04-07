<%--
  Created by IntelliJ IDEA.
  User: hyling
  Date: 2023/4/3
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/safe/empServlet?method=modify&id=<%=request.getParameter("id")%>" method="post">
    姓名:<input type="text" name="name" ><br>
    工资:<input type="text" name="salary"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
