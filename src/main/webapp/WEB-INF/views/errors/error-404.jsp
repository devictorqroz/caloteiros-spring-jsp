<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro 404</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/error.css">
</head>
<body>
	<header>
		<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
		<h2>Caloteiros</h2>
	</header>
    <main>
        <h1>404</h1>
        <p>Não conseguimos encontrar esse link, tente um novo link.</p>
        <a href="/menu">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
    </footer>
</body>
</html>
