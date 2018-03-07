
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hi-Lo Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <jsp:include page="/navbar.jsp" />
        <div class="game">
            <div class="poker-board">
                <div class="poker-dealer">
                    <div class="poker-player-box">
                        <div class="poker-cards">
                            <img src="${user.image}"  />
                            <img src="img/<c:choose><c:when test="${count == null}">i.png</c:when><c:otherwise>${card1[0]}.png</c:otherwise></c:choose>" class="poker-play-card-1" />
                            <img src="img/<c:choose><c:when test="${count == null || count == 1}">i.png</c:when><c:otherwise>${card2[0]}.png</c:otherwise></c:choose>" class="poker-play-card-2" /> 
                            <br>
                            ${user.name}
                        </div>
                        <form action="HighLowController" method="post">
                            <input type="submit" name="lowerButton" value="Lower" <c:choose><c:when test="${count == null}">disabled</c:when><c:otherwise>${lowerButtonState}</c:otherwise></c:choose>>
                            <input type="submit" name="higherButton" value="Higher" <c:choose><c:when test="${count == null}">disabled</c:when><c:otherwise>${higherButtonState}</c:otherwise></c:choose>>
                            <br><br>
                            <input type="submit" name="playButton" value="Play" ${playButtonState}>
                        </form>
                            <h2>${winMessage}</h2>
                        <div class="poker-user">
                            <div class="poker-controls">
                                <div class="poker-bet" style="display: none;">
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
