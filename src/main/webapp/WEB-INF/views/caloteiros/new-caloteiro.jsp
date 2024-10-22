<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<html>
	<head>
	    <meta charset="UTF-8">
		<title>Adiciona Caloteiro</title>
		<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/caloteiros/new-caloteiro.css">
		<script src="${pageContext.request.contextPath}/javascript/jquery-3.7.1.min.js" defer></script>
		<script src="${pageContext.request.contextPath}/javascript/jquery.maskMoney.min.js" defer></script>
		<script src="${pageContext.request.contextPath}/javascript/jquery.inputmask.min.js" defer></script>
		<script src="${pageContext.request.contextPath}/javascript/jquery.validate.min.js" defer></script>
		<script src="${pageContext.request.contextPath}/javascript/masks.js" defer></script>
	</head>
	<body>
		<header>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>
				Usuário Logado: ${authenticatedUser.username}
			</p>

			<form action="${pageContext.request.contextPath}/caloteiros" method="POST" id="formCreate">

				<triadTag:textField
					nameField="name" 
					label="Nome:" 
					id="labelName"
					value="${requestNewCaloteiro.name}" />
				<triadTag:textField 
					nameField="email" 
					label="Email:" 
					id="labelEmail"
					value="${requestNewCaloteiro.email}" />
				<triadTag:textField 
					nameField="debt" 
					label="Devendo:" 
					id="labelDebt"
					value="${requestNewCaloteiro.debt}" />
				<triadTag:textField 
					nameField="debtDate" 
					label="Data da Dívida:"
					id="labelDate"
					value="${requestNewCaloteiro.debtDate}" />
					
				<input type="submit" value="Cadastrar" />
			</form>
			<a href="/menu" class="menu-link">Retornar ao Menu</a>
		</main>
		<footer>
			<c:import url="${pageContext.request.contextPath}/WEB-INF/views/includes/footer.jsp" />
		</footer>
	</body>
</html>