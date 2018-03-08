<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leaderboard Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
        <div class="console">
            
            <form action="leaderboard?action=" method="post">
                <input type="hidden" name="sqlStatement" value="select * from game_t" />
                <input type="submit" value="Overall">
            </form>
            <form action="leaderboard?action=1" method="post">
                <input type="hidden" name="sqlStatement" value="select * from game_t" />
                <input type="submit" value="Poker">
            </form>
            <form action="leaderboard?action=2" method="post">
                <input type="hidden" name="sqlStatement" value="select * from game_t" />
                <input type="submit" value="Craps">
            </form>
            <form action="leaderboard?action=3" method="post">
                <input type="hidden" name="sqlStatement" value="select * from game_t" />
                <input type="submit" value="Hi-lo">
            </form>
        </div>
        <h2 style="margin: auto; text-align: center;">${gameid}</h2>
        <div class="stat-table">
            
           ${table} 
        </div>
        
    </body>
</html>
