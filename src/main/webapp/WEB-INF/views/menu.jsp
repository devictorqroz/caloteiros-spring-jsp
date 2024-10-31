<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu Caloteiros</title>
		<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
	</head>
	<body>
		<header>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>Seja bem vindo ${sessionScope.currentUser.username} ao sistema caloteiros</p>
			
			<ol>
				<li>
					<a href='<c:url value="/caloteiros/new" />' >
						Adicionar caloteiro
					</a>
				</li>
				<li>
					<a href='<c:url value="/caloteiros" />' >
						Listar caloteiros
					</a>
				</li>
				<li>
                    <a href='<c:url value="/users/new" />' >
                        Criar novo usuário
                    </a>
                </li>
                <li>
                    <a href='<c:url value="/logout" />' >
                        Logout
                    </a>
                </li>
			</ol>
		</main>
		<footer>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
		</footer>
	</body>
</html>
