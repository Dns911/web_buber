<%--
  Created by IntelliJ IDEA.
  User: vds15
  Date: 04-Dec-22
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome ${user} !
<br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="logout"/>
<input type="submit" name="button_logout" value="Logout"/>
</form>
</body>
</html>
