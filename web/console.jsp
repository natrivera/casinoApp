<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Console Page</title>
        <link href="index.css"  rel="stylesheet" />
    </head>
        <body>

           
            <c:if test="${sqlStatement == null}">
                <c:set var="sqlStatement" value="select * from User" />
            </c:if>

            <h1>Casino App Console</h1>
            <p>Enter an SQL statement and click the Execute button.</p>

            <p><b>SQL statement:</b></p>
            <form action="Console" method="post">
                <textarea name="sqlStatement" cols="60" rows="8">${sqlStatement}</textarea>
                <input type="submit" value="Execute">
            </form>

            <p><b>SQL result:</b></p>
            ${sqlResult}

        </body>
</html>
