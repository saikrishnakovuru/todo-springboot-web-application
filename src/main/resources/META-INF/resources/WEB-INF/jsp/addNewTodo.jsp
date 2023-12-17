<html lang="en">
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add New Todo</title>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
      .container {
        margin-top: 20px;
        max-width: 400px;
      }

      .btn:hover {
        border-radius: 10px;
      }
      body {
        background-color: rgb(197, 185, 83);
      }
      .btn {
        margin-top: 10px;
      }
    </style>
  </head>
  <body>
    <%@ include file="resources/navigation.jspf" %>
    <div class="container">
      <form:form method="post" modelAttribute="todo">
        <div class="form-group">
          <label for="description" class="form-label">Description:</label>
          <form:input
            type="text"
            class="form-control"
            name="description"
            path="description"
          />
          <form:errors path="description" />
        </div>
        <div>
          <label for="targetDate">Date:</label>
          <form:input
            type="date"
            class="form-control"
            name="targetDate"
            path="targetDate"
            value="${todo.targetDate}"
          />
          <form:errors path="targetDate" />
        </div>
        <button type="submit" class="btn btn-success">${buttonName}</button>
      </form:form>
    </div>
    <%@ include file="resources/footer.jspf" %>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
