<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <body>
    <div>
      <div>Welcome ${n}</div>
      <hr />
	  <h1>Your Todo's</h1>
      <table class="table">
        <tr>
          <th>id</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done?</th>
        </tr>
        <c:forEach items="${todosList}" var="todo">
          <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
