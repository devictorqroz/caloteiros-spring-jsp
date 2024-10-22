<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Caloteiro Adicionado</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/action-completed.css">
</head>
<body>
	<header>
		<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
		<h1>Caloteiros</h1>
	</header>
    <main>
        <h3>Sucesso</h3>
        <p>Caloteiro adicionado com sucesso.</p>
        <a href="/menu">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
    </footer>
</body>
</html>
