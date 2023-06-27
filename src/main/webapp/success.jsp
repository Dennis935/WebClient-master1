<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.username}">
  <c:redirect url="login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">


  <title>Buchung erfolgreich</title>
  <style>
    body {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
      text-align: center;
    }

    h1, p {
      margin-bottom: 20px;
    }

    img {
      width: 100px;
    }
  </style>
</head>
<body>
<h1>Buchung erfolgreich</h1>
<img src="icons/successIcon.png" alt="Erfolgssymbol">
<p>Ihre Buchung wurde erfolgreich abgeschlossen. Vielen Dank!</p>

<a href="index.jsp">Zurück zur Startseite</a>
</body>
</html>



