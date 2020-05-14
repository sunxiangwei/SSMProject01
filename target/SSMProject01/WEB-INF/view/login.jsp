<%--
  Created by IntelliJ IDEA.
  User: sunxiangwei
  Date: 2020-5-1
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/jq/jquery-3.4.1.min.js"></script>
    <script>
        $(function(){
           $("#btn").click(function () {
               $.ajax({
                   url:"login.do",
                   type:"post",
                   dataType:"text",
                   data:{
                       "uname":$("#uname").val(),
                       "upass":$("#upass").val()
                   },
                   success:function (data) {
                       if (data == "success"){
                           alert("登陆成功");
                           $(location).attr("href","index.jsp");
                       }else{
                           alert("登录失败");
                           $(location).attr("href","login.html");
                       }
                   },
                   error:function () {
                       alert("操作失败")
                   }
               });
           });
        });
    </script>
</head>
<body>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>用户名:</td><td><input type="text" name="uname" id="uname"></td>
        <td>密码:</td><td><input type="password" name="upass" id="upass"></td>
        <td colspan="2"><button id="btn">提交</button></td>
    </tr>
</table>
</body>
</html>
