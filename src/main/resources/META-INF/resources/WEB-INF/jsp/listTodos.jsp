<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <html>

  <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
    <title>List Todos Page</title>
    <style>
      .btn:hover {
        border-radius: 10px;
      }

      body {
        background-color: #88da88;
      }

      .todo-table {
        max-height: 400px;
        overflow-y: auto;
      }

      .table thead th {
        position: sticky;
        top: 0;
      }

      /* .footer {
        background-color: #333;
        color: #fff;
        padding: 10px 0;
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 300px;
      }

      .footer p {
        margin-bottom: 0;
      }

      .large-text {
        font-size: 24px;
        font-weight: bold;
      } */
    </style>
  </head>

  <body>
    <%@ include file="resources/navigation.jspf" %>
      <div class="container">
        <h1>${name}'s Todos</h1>
        <div class="todo-table">
          <table class="table">
            <thead>
              <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${listOfTodos}" var="todo">
                <tr>
                  <td>${todo.description}</td>
                  <td>${todo.targetDate}</td>
                  <td>${todo.done}</td>
                  <td>
                    <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                    /
                    <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <a href="add-new-todo" class="btn btn-success">Add</a>
      </div>
      <%@ include file="resources/footer.jspf" %>
      <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>

  </html>