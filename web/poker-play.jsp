

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
        <div class="welcome">
                Name: ${user.name}<br>
                Balance: $${user.balance}
            </div>
        <div class="game">
            <div class="poker-board">
                <div class="poker-dealer">
                    <div class="poker-player-box">
                        <div class="poker-user">
                            <div class="poker-user-display">
                                Name: 
                                <br>
                            </div>
                            <div class="poker-controls">
                                <div class="poker-bet">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                            ${cpumessage}
                            <br>
                            ${winmessage}
                        </div>
                        <div class="poker-cards">
                            <img src="./img/${cpucards[0]}.png" />
                            <img src="./img/${cpucards[1]}.png" /> 
                            <img src="./img/${cpucards[2]}.png" /> 
                            <img src="./img/${cpucards[3]}.png" /> 
                            <img src="./img/${cpucards[4]}.png" /> 
                        </div>
                    </div> 
                    <div class="poker-output">
                        
                    </div>
                </div>
                <div class="poker-player">
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/${playercards[0]}.png" />
                            <img src="./img/${playercards[1]}.png" /> 
                            <img src="./img/${playercards[2]}.png" /> 
                            <img src="./img/${playercards[3]}.png" /> 
                            <img src="./img/${playercards[4]}.png" />
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                Name: ${user.name}
                                <div class="poker-bet">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                            ${playermessage}
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/${playercards[10]}.png" />
                            <img src="./img/${playercards[11]}.png" /> 
                            <img src="./img/${playercards[12]}.png" /> 
                            <img src="./img/${playercards[13]}.png" /> 
                            <img src="./img/${playercards[14]}.png" />
                        </div>
                        <div class="poker-user">
                            
                            <div class="poker-controls">
                                <div class="poker-bet">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/${cards[15]}.png" />
                            <img src="./img/${cards[16]}.png" /> 
                            <img src="./img/${cards[17]}.png" /> 
                            <img src="./img/${cards[18]}.png" /> 
                            <img src="./img/${cards[19]}.png" />
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                <div class="poker-bet">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="./img/${cards[20]}}.png" />
                            <img src="./img/${cards[21]}.png" /> 
                            <img src="./img/${cards[22]}.png" /> 
                            <img src="./img/${cards[23]}.png" /> 
                            <img src="./img/${cards[24]}.png" />
                        </div>
                        <div class="poker-user">
                            <div class="poker-controls">
                                <div class="poker-bet">
                                    <button>-</button>
                                    <input name="poker-bet" value="10" />
                                    <button>+</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
