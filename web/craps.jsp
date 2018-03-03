<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Craps Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
    <center>
        <div id="pointDiv" class="crapsDiv">
            <p class ="point">Point is:</p>
                <img class="crapsImage" id ="diePoint1" src="${pointDie1Image}" alt="">
                <img class="crapsImage" id="diePoint2" src="${pointDie2Image}" alt="">
        </div>
        <div id ="rollDiv" class="crapsDiv">
                <img class="crapsImage" id="die1Roll" src="${die1ImageURL}" alt="">
                <img class="crapsImage" id="die2Roll" src="${die2ImageURL}" alt="">
        </div>
        <form action="CrapsController" method="post">
            <input name="playButton" type="submit" value="Play" ${playButtonState}>
            <input name="rollButton" type="submit" value="Roll" ${rollButtonState}>
        </form>
        <p id="message" class="red">${message}</p>
    </center>
    </body>
</html>