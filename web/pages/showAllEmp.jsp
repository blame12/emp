<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有员工</title>
</head>
<body>
<table border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>工资</td>
        <td>年龄</td>
        <td colspan="2">操作</td>
    </tr>
    <c:forEach var="emp" items="${requestScope.emps}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.age}</td>
            <td>
                <a href="${pageContext.request.contextPath}/safe/empServlet?method=remove&id=${emp.id}">删除</a>
                <a href="${pageContext.request.contextPath}/pages/modifyEmp.jsp?id=${emp.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/safe/empServlet?method=queryAll&page=1">首页</a>
<c:if test="${requestScope.page != 1}">
    <a href="${pageContext.request.contextPath}/safe/empServlet?method=queryAll&page=${requestScope.page-1}">上一页</a>
</c:if>
<c:if test="${requestScope.pageCount != requestScope.page}">
    <a href="${pageContext.request.contextPath}/safe/empServlet?method=queryAll&page=${requestScope.page+1}">下一页</a>
</c:if>
<a href="${pageContext.request.contextPath}/safe/empServlet?method=queryAll&page=${requestScope.pageCount}">尾页</a>
<button onclick="window.location.href='/pages/addEmp.jsp'">添加</button>
</body>
</html>
