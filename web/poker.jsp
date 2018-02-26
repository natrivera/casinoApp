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
        <div class="">
            <div class="inner">
                <div class="choices">
                    <div class="choice">
                        <form action="Poker" method="post">
                            <input type="hidden" name="action" value="cpu" />
                            <input type="submit" value="1 Player" /> 
                        </form>
                    </div>
                    <div class="choice">
                        <form action="Poker" method="post">
                            <input type="hidden" name="action" value="multi" />
                            <input type="submit" value="Multi-Player" /> 
                        </form>
                    </div>
                    <div class="choice">
                        <form action="Poker" method="post">
                            <input type="hidden" name="action" value="answer" />
                            <input type="submit" value="Enter Challenge Code" /> 
                            <br>
                            <input type="text" name="gameid"  />
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
