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
    <title>Welcome</title>
  </head>
  <body>
    <div class="container">
      <h1>Welcome ${n}</h1>
      <hr />
      Manage your <a href="list-todos"> Todo's</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
