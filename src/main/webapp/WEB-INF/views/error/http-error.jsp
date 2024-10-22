<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Não Encontrada</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/error.css">
</head>
<body>
	<header>
		<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
		<h2>Caloteiros</h2>
	</header>
    <main>
        <h1>${error}</h1>
        <p>${message}</p>
        <a href="/menu">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
    </footer>
</body>
</html>
