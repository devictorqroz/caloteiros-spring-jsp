<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu Caloteiros</title>
		<link rel="stylesheet" type="text/css" href="css/menu.css">
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>Seja bem vindo ${authenticatedUser.name} ao sistema caloteiros:</p>
			
			<ol>
				<li>
					<a href='<c:url value="/include-caloteiro.jsp" />' >
						Adicionar caloteiro
					</a>
				</li>
				<li>
					<a href='<c:url value="/system?logica=ListCaloteiro" />' >
						Listar caloteiros
					</a>
				</li>
			</ol>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>
