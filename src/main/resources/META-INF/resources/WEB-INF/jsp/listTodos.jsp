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
        border-radius: 10px;
      }
      body {
        background-color: rgb(195, 187, 83);
      }
      .todo-table {
        max-height: 400px;
        overflow-y: auto;
      }
      .table thead th {
        position: sticky;
        top: 0;
      }

      .footer {
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

      .footer i {
        color: #d9534f; /* Red color for heart icon */
      }
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
              <th>id</th>
              <th>Description</th>
              <th>Target Date</th>
              <th>Is Done?</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${listOfTodos}" var="todo">
              <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td>
                  <a href="delete-todo?id=${todo.id}" class="btn btn-warning"
                    >Delete</a
                  >
                  /
                  <a href="update-todo?id=${todo.id}" class="btn btn-success"
                    >Update</a
                  >
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <a href="add-new-todo" class="btn btn-success">Add</a>
    </div>
    <div>
      <footer class="footer">
        <div class="container">
          <div class="row">
            <div class="col-lg-6">
              <h5>JavA DevelopeR</h5>
              <ul>
                <li>Java</li>
                <li>Spring Boot</li>
                <li>Microservices</li>
                <li>REST API</li>
                <li>Docker</li>
                <li>Spring Security</li>
                <li>Spring Data JPA</li>
              </ul>
            </div>
            <div class="col-lg-2 text-center">
              <!-- Add your image here -->
              <img
                src="src/main/resources/images/java.jpeg"
                alt="Java"
              />
            </div>
            <div class="col-lg-6 text-right">
              <p>&copy; 2023 Your ToDo App</p>
              <p>Developed <i class="fa fa-heart text-danger"></i> by SAI</p>
            </div>
          </div>
        </div>
      </footer>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
