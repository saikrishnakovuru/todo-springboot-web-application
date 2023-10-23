<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
  </head>
  <body>
    <form method="post">
      Name: <input type="text" name="name" />
      password: <input type="password" name="password" />
      <input type="submit"/>
      ${errorMessage}
    </form>
  </body>
</html>
