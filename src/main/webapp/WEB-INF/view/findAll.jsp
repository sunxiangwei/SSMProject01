<%--
  Created by IntelliJ IDEA.
  User: sunxiangwei
  Date: 2020-5-1
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="center" border="1" cellspacing="0" cellpadding="5" width="80%">
        <tr>
            <th>id</th>
            <th>uname</th>
            <th>upass</th>
            <th>age</th>
        </tr>
        <c:forEach items="${userPageInfo.list}" var="user">
            <tr align="center">
                <td>${user.uno}</td>
                <td>${user.uname}</td>
                <td>${user.upass}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="findAll.do?pageNum=1">首页</a>

                <a href="findAll.do?pageNum=${userPageInfo.prePage}">上一页</a>

                <%--${userPageInfo.pageNum }--%>

                <c:forEach items="${userPageInfo.navigatepageNums}" var="num">
                    <c:if test="${num == userPageInfo.pageNum}">
                        【${num}】
                    </c:if>
                    <c:if test="${num != userPageInfo.pageNum}">
                        <a href="findAll.do?pageNum=${num}">${num}</a>
                    </c:if>
                </c:forEach>


                <a href="findAll.do?pageNum=${userPageInfo.nextPage}">下一页</a>

                <a href="findAll.do?pageNum=${userPageInfo.pages}">尾页</a>
            </td>
        </tr>
    </table>
</body>
</html>
