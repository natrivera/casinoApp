<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poker Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
        
        <div class="game">
            <div class="poker-board">
                <div class="poker-dealer">
                    <div class="poker-player-box">
                        <div class="poker-user">
                            <div class="poker-user-display">
                                Name: ${cpu.name}
                                <br>
                            </div>
                            <div class="poker-controls">
                                <div class="poker-bet" style="display: none;">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>  
                        </div>
                        <div class="poker-cards">
                            <div class="poker-hand-msg"><h2>${cpumessage}</h2></div>
                            <img src="./img/${cpucards[0]}.png" class="poker-play-card-1" />
                            <img src="./img/${cpucards[1]}.png" class="poker-play-card-2" /> 
                            <img src="./img/${cpucards[2]}.png" class="poker-play-card-3" /> 
                            <img src="./img/${cpucards[3]}.png" class="poker-play-card-4" /> 
                            <img src="./img/${cpucards[4]}.png" class="poker-play-card-5" /> 
                        </div>
                    </div> 
                    <div class="poker-output">
                        ${winmessage}
                    </div>
                </div>
                <div class="poker-player">
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/${playercards[0]}.png" class="poker-play-card-1" />
                            <img src="./img/${playercards[1]}.png" class="poker-play-card-2" /> 
                            <img src="./img/${playercards[2]}.png" class="poker-play-card-3" /> 
                            <img src="./img/${playercards[3]}.png" class="poker-play-card-4" /> 
                            <img src="./img/${playercards[4]}.png" class="poker-play-card-5" />
                            <div class="poker-hand-msg"><h2>${playermessage}</h2></div>
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                Name: ${user.name}
                                <br><br>
                                <form action="Poker" method="post">
                                    <button type="button" onclick="minus();">-</button>
                                    <input name="poker-bet" id="userbet" value="${bet}" />
                                    <button type="button" onclick="plus();">+</button>
                                    <br>
                                    <input type="submit" value="Bet" />
                                    <input type="hidden" name="action" value="cpu" />
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/i${playercards[10]}.png" class="poker-play-card-1" />
                            <img src="./img/i${playercards[11]}.png" class="poker-play-card-2" /> 
                            <img src="./img/i${playercards[12]}.png" class="poker-play-card-3" /> 
                            <img src="./img/i${playercards[13]}.png" class="poker-play-card-4" /> 
                            <img src="./img/i${playercards[14]}.png" class="poker-play-card-5" />
                        </div>
                        <div class="poker-user">
                            
                            <div class="poker-controls">
                                Name:
                                <div class="poker-bet" style="display: none;">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                            |<br>|<br>|
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/i${cards[15]}.png" class="poker-play-card-1" />
                            <img src="./img/i${cards[16]}.png" class="poker-play-card-2" /> 
                            <img src="./img/i${cards[17]}.png" class="poker-play-card-3" /> 
                            <img src="./img/i${cards[18]}.png" class="poker-play-card-4" /> 
                            <img src="./img/i${cards[19]}.png" class="poker-play-card-5" />
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                Name:
                                <div class="poker-bet" style="display: none;">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                            |<br>|<br>|
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/i${cards[20]}.png" class="poker-play-card-1" />
                            <img src="./img/i${cards[21]}.png" class="poker-play-card-2" /> 
                            <img src="./img/i${cards[22]}.png" class="poker-play-card-3" /> 
                            <img src="./img/i${cards[23]}.png" class="poker-play-card-4" /> 
                            <img src="./img/i${cards[24]}.png" class="poker-play-card-5" />
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                Name:
                                <div class="poker-bet" style="display: none;">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                            |<br>|<br>|
                        </div>
                    </div>
                </div>
            </div>
        </div>
                        
       <script>
           
           function minus() {
               var input = document.getElementById("userbet").value;
               var temp = parseInt(input);
               temp--;
               document.getElementById("userbet").value = temp;
           }
           
           function plus() {
               var input = document.getElementById("userbet").value;
               var temp = parseInt(input);
               temp++;
               document.getElementById("userbet").value = temp;
           }
                            
       </script>
    </body>
</html>
