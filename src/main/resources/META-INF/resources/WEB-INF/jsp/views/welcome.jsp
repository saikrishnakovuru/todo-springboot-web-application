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
    <style>
      .navbar.navbar-light {
        background-color: rgb(187, 131, 47) !important;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
      <a class="navbar-brand m-1" href="https://github.com/saikrishnakovuru"
        >GitHub</a
      >
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
      <h1>Welcome ${n}</h1>
      <hr />
      Manage your <a href="list-todos"> Todo's</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
