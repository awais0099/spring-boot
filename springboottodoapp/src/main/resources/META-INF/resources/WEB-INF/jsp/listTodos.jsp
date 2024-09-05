<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <div>Welcome ${name}!</div>
    <hr />
    
    <h2>Your Todos</h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Description</th>
                <th scope="col">Target Date</th>
                <th scope="col">Is Done</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${todos}" var="todo">
                <tr>
                    <th scope="row">${todo.id}</th>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>
                    	${todo.done}
                    </td>
                    <td>
                        <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>
                    </td>
                    <td>
                        <a href="/update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a>
                    </td>
                </tr>
	        </c:forEach>
        </tbody>
    </table>
    <a href="/add-todo" class="btn btn-primary btn-lg">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>