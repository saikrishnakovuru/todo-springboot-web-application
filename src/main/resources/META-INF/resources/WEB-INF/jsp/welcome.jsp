<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <title>Welcome page</title>
    <style>
      body {
        background-color: #88da88;
      }
    </style>
  </head>
  <body>
    <%@ include file="resources/navigation.jspf" %>
    <div class="container">
      <h1>Welcome ${name}!</h1>

      <h4><a href="/list-todos">Manage</a> your todos</h4>
    </div>
    <%@ include file="resources/footer.jspf" %>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
