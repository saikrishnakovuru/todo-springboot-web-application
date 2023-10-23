<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <title>Add New Todo</title>
    <style>
      .container {
        width: 500px;
      }

      .form-control {
        margin-bottom: 10px;
      }

      .btn:hover {
        border-radius: 10px;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Add your new Todo ${n}</h1>
      <hr />
      <form method="post">
        <div class="form-group">
          <label for="description" class="form-label">Description</label>
          <input
            type="text"
            class="form-control"
            id="description"
            name="description"
          />
        </div>
        <div>
          <label for="date">Date:</label>
          <input type="date" class="form-control" id="date" name="date" />
        </div>
        <button type="submit" class="btn btn-success">Add</button>
      </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
