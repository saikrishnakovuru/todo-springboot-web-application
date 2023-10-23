<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <title>List Todos Page</title>
    <style>
      .btn:hover {
        border-radius: 20px;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>${n}'s Todos</h1>
      <table class="table">
        <thead>
          <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todosList}" var="todo">
            <tr>
              <td>${todo.id}</td>
              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="add-new-todo" class="btn btn-success">Add Todo</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
