<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to BUBER</title>
</head>
<body>
<h1> "Hello Calc!"
</h1>
<br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="login"/>
    Login: <input type="text" name="login" value=""/>
    <br/>
    Password: <input type="password" name="pass" value=""/>
<%--    <input list="type" name="mathOperator"/>--%>
<%--    <datalist id="type">--%>
<%--        <option>+</option>--%>
<%--        <option>-</option>--%>
<%--        <option>x</option>--%>
<%--        <option>/</option>--%>
<%--    </datalist>--%>
    <br/>
    <input type="submit" name="but" value="Submit"/>

    <br/>
    ${login_msg}
</form>
<form action="pages/registration.jsp">
    <input type="submit" name="but1" value="Registration"/>
</form>
</body>
</html>