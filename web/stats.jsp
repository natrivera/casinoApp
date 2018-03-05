<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.name}'s Stats</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
        <div class='stat-table'>
            <div>${table}</div>
            <br><br>
            <div class="poker-stats">
                Poker Stats
                <br>
                Games Won: ${pokerstats[3]}
                <br>
                Total Games Played: ${pokerstats[0]}
                <br>
                Average Winnings: ${pokerstats[1]}
                <br>
                Winning percentage: ${pokerstats[2]}%
            </div>
            <br><br>
            <div class="poker-stats">
                Craps Stats
                <br>
                Games Won: ${crapstats[3]}
                <br>
                Total Games Played: ${crapstats[0]}
                <br>
                Average Winnings: ${crapstats[1]}
                <br>
                Winning percentage: ${crapstats[2]}%
            </div>
        </div>
        
    </body>
</html>