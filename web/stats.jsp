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
        <div class="console-div">
            <div class="stat-table-head">
                <div class="inner">
                    <div><img src="${user.image}" /></div>
                    <div>${table}</div>
                </div>   
            </div>
            <div class='stat-table'>
                <br><br>
                <div class="poker-stats">
                    <table>
                        <tr><th colspan="2" style="text-align: center;" >Poker Stats</th></tr>
                        <tr><th>Games Won</th><td>${pokerstats[3]}</td></tr>
                        <tr><th>Total Games Played</th><td>${pokerstats[0]}</td></tr>
                        <tr><th>Average Winnings</th><td>${pokerstats[1]}</td></tr>
                        <tr><th>Winning percentage</th><td>${pokerstats[2]}%</td></tr>    
                    </table>    
                
                    <table>
                        <tr><th colspan="2" style="text-align: center;">Craps Stats</th></tr>
                        <tr><th>Games Won</th><td>${crapstats[3]}</td></tr>
                        <tr><th>Total Games Played</th><td>${crapstats[0]}</td></tr>
                        <tr><th>Average Winnings</th><td>${crapstats[1]}</td></tr>
                        <tr><th>Winning percentage</th><td>${crapstats[2]}%</td></tr>    
                    </table> 
               
                    <table>
                        <tr><th colspan="2" style="text-align: center;">Hi-lo Stats</th></tr>
                        <tr><th>Games Won</th><td>${hilostats[3]}</td></tr>
                        <tr><th>Total Games Played</th><td>${hilostats[0]}</td></tr>
                        <tr><th>Average Winnings</th><td>${hilostats[1]}</td></tr>
                        <tr><th>Winning percentage</th><td>${hilostats[2]}%</td></tr>    
                    </table> 
                </div>
            </div>
        </div>
    </body>
</html>
