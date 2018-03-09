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
                    <div class="form-div">
                        <div>Name</div><br>
                        <input name="name" type="text"  required />
                        <br>
                        <div>Date of Birth</div><br>
                        <input name="dob" type="date" value="1990-01-01" required />
                        <br>
                        <div>UserName</div><br>
                        <input name="username" type="text" required  />
                        <br>
                        <div>Password</div><br>
                        <input name="password" type="password" required />
                        <br><br>
                        <div>Image</div>
                        <fieldset>
                            <span>
                                <img src="./img/male.jpg" /><br>
                                <input name="image" type="radio" value="./img/male.jpg" selected >
                            </span>
                            <span>
                                <img src="./img/male1.jpg" /><br>
                                <input name="image" type="radio" value="./img/male1.jpg">
                            </span>
                            <span>
                                <img src="./img/female.jpg" /><br>
                                <input name="image" type="radio" value="./img/female.jpg">
                            </span>
                            <span>
                                <img src="./img/female1.jpg" /><br>
                                <input name="image" type="radio" value="./img/female1.jpg">
                            </span>                         
                        </fieldset>
                        
                        <input type="hidden" name="action" value="new" />
                        <input type="submit" value="Create User!" />
                    </div>
                </form>  
                <br><br>
                <div class="error">${error}</div>
            </div>
        </div>       
    </body>
</html>
