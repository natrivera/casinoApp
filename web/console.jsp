<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Console Page</title>
        <link href="index.css"  rel="stylesheet" />
        <link rel="icon" href="./img/favicon.ico" type="image/x-icon" >
    </head>
        <body>
            <jsp:include page="/navbar.jsp" />
            <div style=" margin-top: 20px; display: <c:out value="${ user.admin != 1 ? 'inline-block' : 'none'}" />" >You do not have admin access</div>
            <div class="console-div" style="display: <c:out value="${ user.admin == 1 ? '' : 'none'}" />" >       
                <div class="stat-table-head">
                    <h2 style="margin: auto; text-align: center;">Casino App Console</h2>
                    
                        <span>
                            <form action="Console" method="post">
                                <input type="hidden" name="sqlStatement" value="select * from user_t" />
                                <input type="submit" value="Users">
                            </form>
                        </span>
                        <span>
                            <form action="Console" method="post">
                                <input type="hidden" name="sqlStatement" value="select * from transaction_t" />
                                <input type="submit" value="Transactions">
                            </form>
                        </span>
                        <span>
                            <form action="Console" method="post">
                                <input type="hidden" name="sqlStatement" value="select * from game_t" />
                                <input type="submit" value="Games">
                            </form>
                        </span>
                        
                        <span>
                            <form action="Console" method="post">
                                <textarea  name="sqlStatement" cols="40" rows="2" ></textarea>
                                <input type="submit" value="Query">
                            </form>
                        </span>
                                 
                </div>
                <div class="stat-table">
                    ${sqlResult}
                </div>
            </div>
        </body>
</html>
