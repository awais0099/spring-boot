<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
    <h1>Welcome to the login page!</h1>
    <pre>${errorMessage}</pre>
    <form method="post">
        <input type="text" name="name" value="test" />
        <input type="password" name="password" value="test" />
        <input type="submit" name="submit" />
    </form>
</div>
<%@ include file="common/footer.jspf" %>