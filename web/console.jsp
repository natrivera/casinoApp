<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Console Page</title>
        <style>
            .cosole {
                margin: auto;
            }
            .console form {
                display: inline-block;
            }
    
        </style>
    </head>
        <body>
            <jsp:include page="/navbar.jsp" />
            <div class="console" >
                <h1>Casino App Console</h1>

                <form action="Console" method="post">
                    <input type="hidden" name="sqlStatement" value="select * from user_t" />
                    <input type="submit" value="Users">
                </form>
                <form action="Console" method="post">
                    <input type="hidden" name="sqlStatement" value="select * from transaction_t" />
                    <input type="submit" value="Transactions">
                </form>
                <form action="Console" method="post">
                    <input type="hidden" name="sqlStatement" value="select * from game_t" />
                    <input type="submit" value="Games">
                </form>
                <form action="Console" method="post">
                    <textarea  name="sqlStatement" cols="40" rows="4" ></textarea>
                    <input type="submit" value="Query">
                </form>

                ${sqlResult}
            </div>
        </body>
</html>
