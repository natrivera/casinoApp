
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
        <div class="main">
               
        </div>
        <div class="inner">
       
                <div class="choices">
                    <a href="poker.jsp">
                        <div class="choice">
                            Poker
                            <br>
                            <br>
                            <img src="./img/Ace of Spades.png" />
                        </div>
                    </a>
                 
                    <a href="craps.jsp">
                        <div class="choice">
                            Craps
                            <br>
                            <br>
                            <img src="./img/5.jpg" />
                            <br>
                        </div>
                    </a>
                    <a href="bingo.jsp">
                        <div class="choice">
                            Bingo
                            <br>
                            <br>
                            <img src="./img/King of Spades.png" />
                        </div>
                    </a>
                    <a href="hi-lo.jsp">
                        <div class="choice">
                            Hi-Lo
                            <br>
                            <br>
                            <img src="./img/Queen of Spades.png" />
                        </div>
                    </a>
                    <a href="leaderboard?action=">
                        <div class="choice">
                            LeaderBoards
                            <br>
                            <br>
                            <img src="./img/Jack of Spades.png" />
                        </div>
                    </a>
                </div>
        </div>
    </body>
</html>
