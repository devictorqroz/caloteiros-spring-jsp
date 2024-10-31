<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Caloteiros</title>
		<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/caloteiros/list-caloteiros.css">
		<script src="${pageContext.request.contextPath}/javascript/jquery-3.7.1.min.js" defer></script>
    	<script src="${pageContext.request.contextPath}/javascript/confirmation.js" defer></script>
	</head>
	<body>
		<header>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>
				Usuário Logado: ${currentUser.username}
			</p>
			<p>
				Lista de Caloteiros: 
			</p>		
			<table>
				<tr><th>ID</th><th>Nome</th><th>Email</th><th>Devendo</th><th>Data Dívida</th><th>Editar</th><th>Excluir</th></tr>
				<c:forEach var="caloteiro" items="${caloteiros}" varStatus="id">
					<tr>
						<td>${caloteiro.id}</td> 
						<c:choose>
							<c:when test="${not empty caloteiro.name}">
								<td>${caloteiro.name}</td>
							</c:when>
							<c:otherwise>
								<td>Nome não preenchido.</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty caloteiro.email}">
								<td><a href="#">${caloteiro.email}</a></td>
							</c:when>
							<c:otherwise>
								<td>E-mail não preenchido.</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty caloteiro.debt}">
								<td>${caloteiro.debt}</td>
							</c:when>
							<c:otherwise>
								<td>Devendo não preenchido.</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty caloteiro.debtDate}">
								<td>
									 ${fn:formatLocalDate(caloteiro.debtDate, 'dd/MM/yyyy')}
								</td>
							</c:when>
							<c:otherwise>
								<td>Data dívida não preenchida.</td>
							</c:otherwise>
						</c:choose>
						<td>
							<form action="/caloteiros/${caloteiro.id}/edit" method="GET">
								<input type="submit" id="updateButton" value="Editar" />
							</form>
						</td>
						<td>
							<form action="/caloteiros/${caloteiro.id}" method="POST">
								<input type="hidden" name="_method" value="DELETE" />
								<input type="submit" id="deleteButton" value="Excluir" />
							</form>
						</td>
					</tr>		
				</c:forEach>
			</table>
			<a href="/menu" class="menu-link">Retornar ao Menu</a>
		</main>
		<footer>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
		</footer>
	</body>
</html>