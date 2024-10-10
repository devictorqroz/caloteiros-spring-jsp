<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Caloteiro Adicionado</title>
    <link rel="stylesheet" type="text/css" href="css/action-completed.css">
</head>
<body>
	<header>
		<c:import url="header.jsp" />
		<h1>Caloteiros</h1>
	</header>
    <main>
        <h3>Sucesso</h3>
        <p>Caloteiro ${caloteiro.name} adicionado com sucesso.</p>
        <a href="menu">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="footer.jsp" />
    </footer>
</body>
</html>
