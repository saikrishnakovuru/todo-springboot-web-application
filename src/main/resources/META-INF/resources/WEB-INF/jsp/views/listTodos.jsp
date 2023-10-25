<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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

      .container {
        max-width: 900px;
      }

      body {
        background-color: rgb(200, 176, 92);
      }
      .navbar.navbar-light {
        background-color: rgb(187, 131, 47) !important;
      }
    </style>
  </head>
  <body>
    
    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
      <a class="navbar-brand m-1" href="https://www.goolge.com">Goolge</a>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
          <li class="nav-item">
            <a class="nav-link" href="/list-todos">Todos</a>
          </li>
        </ul>
      </div>
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
      </ul>
</nav>

    <div class="container">
      <h1>${n}'s Todos</h1>
      <table class="table">
        <thead>
          <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todosList}" var="todo">
            <tr>
              <td>${todo.id}</td>
              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
              <td>
                <a href="delete-todo?id=${todo.id}" class="btn btn-danger"
                  >Delete</a
                >
                <a href="update-todo?id=${todo.id}" class="btn btn-success"
                  >Update</a
                >
              </td>
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
