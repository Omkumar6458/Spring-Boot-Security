<!DOCTYPE html>
<html>
<head>
    <title>Login FOR SEE TASK LIST  </title>
</head>
<body>
<h2>Login</h2>
<form action="/EMS/login1" method="post">

    <label>Username:</label>
    <input type="text" name="username"/><br/><br/>
    <label>Password:</label>
    <input type="password" name="password"/><br/><br/>
    <input type="submit" value="Login"/>
</form>

<c:if test="${param.error != null}">
    <p style="color:red">Invalid username or password!</p>
</c:if>

<c:if test="${param.logout != null}">
    <p style="color:green">You have been logged out.</p>
</c:if>
</body>
</html>
