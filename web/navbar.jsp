<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
 <nav>
    <span>Casino App</span>
    <span><a href="login?action=">Games</a></span>
    <span><a href="index.jsp">Logout</a></span>
    <span style="display: <c:out value="${ user.admin == 1 ? 'inline-block' : 'none'}" />">
        <a href="console.jsp">Admin Console</a>
    </span>
    <span style="float: right; margin-right: 20px;">
        <span><img src="${user.image}" /></span>
        <span>
            <a href="Stats?id=${user.userid}">${user.name}</a>  
            ||  
            $${user.balance}
        </span>
    </span>
</nav>   
</div>

