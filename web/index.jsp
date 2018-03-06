<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casino App</title>
         <link href="index.css"  rel="stylesheet" />
         <link rel="icon" href="./img/favicon.ico" type="image/x-icon">
    </head>
    <body>
        <div>
            <nav>
               <span>Casino App</span>
               <span><a href="login.jsp">User Login</a></span>
           </nav>   
        </div>
        <div class="main">
            <div id="title" class="tittle">
                <h1>Casino App</h1>
                <form action="login" method="post">
                    <label>Name:</label><input name="name" type="text"  required />
                    <br><br>
                    <label>Date of Birth:</label><input name="dob" type="date" value="1990-01-01" required />
                    <br><br>
                    <label>UserName:</label><input name="username" type="text" required  />
                    <br><br>
                    <label>Password:</label><input name="password" type="password" required />
                    <br><br>
                    <label>Image:</label>
                    <fieldset>
                    <input name="image" type="radio" value="./img/male.jpg" selected ><img src="./img/male.jpg" /><br>
                    <input name="image" type="radio" value="./img/male1.jpg"><img src="./img/male1.jpg" /><br>
                    <input name="image" type="radio" value="./img/female.jpg"><img src="./img/female.jpg" /><br>
                    <input name="image" type="radio" value="./img/female1.jpg"><img src="./img/female1.jpg" />
                    </fieldset>
                    <br><br>
                    <input type="hidden" name="action" value="new" />
                    <input type="submit" value="Create User!" />
                </form>  
                <br><br>
                <div class="error">${error}</div>
            </div>
        </div>
        
    </body>
</html>
