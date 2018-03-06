
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="index.css"  rel="stylesheet" />
    </head>
    <body>
        <div><nav><span>Casino App</span></nav></div>
        <div class="main">
            <div class="tittle">
                <h1>Login</h1>
            <form action="login" method="post">
                    <label>UserName:</label><input name="username" type="text" required  />
                    <br><br>
                    <label>Password:</label><input name="password" type="password" required />
                    <br><br>
                    <input type="hidden" name="action" value="old" />
                    <input type="submit" value="Login" />
                </form>
                <br><br>
                <div class="error">${error}</div>
            </div>
        </div>
    </body>
</html>
