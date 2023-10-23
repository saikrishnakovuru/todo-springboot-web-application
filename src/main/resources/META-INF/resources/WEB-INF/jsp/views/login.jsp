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
    <style>
      /* Custom CSS for additional styling */
      .container {
        max-width: 400px;
        padding: 10px;
       
      }

      .form-group {
        margin-bottom: 20px;
      }

      .form-control:hover {
        border-color: #6610f2;
      }

      .btn:hover {
        border-color: #05df05; 
        background-color: #9fc82d; 
        color: #cf7c24;
        border-radius: 20px;
      }
    </style>
    <title>Login</title>
  </head>
  <body>
    <div class="container">
      <h1>Login</h1>
      <form method="post">
        <!-- <label for="name">Name</label>
        <input type="text" name="name" />
        <label for="password">Password</label>
        <input type="password" name="password" />
        <input type="submit" class="btn btn-success" /> -->
        <div class="form-group">
          <label for="name" class="form-label">Name</label>
          <input type="text" class="form-control" id="name" name="name" />
        </div>
        <div class="form-group">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            class="form-control"
            id="password"
            name="password"
          />
        </div>
        <button type="submit" class="btn btn-success">Login</button>
        ${errorMessage}
      </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
