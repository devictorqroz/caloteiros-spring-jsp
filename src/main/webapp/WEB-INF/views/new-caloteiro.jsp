<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes.jsp" %>
<html>
	<head>
	    <meta charset="UTF-8">
		<title>Adiciona Caloteiro</title>
		<link rel="stylesheet" type="text/css" href="css/caloteiros/new-caloteiro.css">
		<script src="javascript/jquery-3.7.1.min.js" defer></script>
		<script src="javascript/jquery.maskMoney.min.js" defer></script>
		<script src="javascript/jquery.inputmask.min.js" defer></script>
		<script src="javascript/jquery.validate.min.js" defer></script>
		<script src="javascript/masks.js" defer></script>
	</head>
	<body>
		<header>
			<c:import url="header.jsp" />
			<h1>Caloteiros</h1>
		</header>
		<main>
			<p>
				Usuário Logado: ${authenticatedUser.name}
			</p>
			<form action="/caloteiros" method="POST">
				<input type="hidden" name="form" value="create"/>
				
				<triadTag:textField 
					nameField="name" 
					label="Nome:" 
					id="labelName" /> 
				<triadTag:textField 
					nameField="email" 
					label="Email:" 
					id="labelEmail" />
				<triadTag:textField 
					nameField="debt" 
					label="Devendo:" 
					id="labelDebt" />
				<triadTag:textField 
					nameField="debtDate" 
					label="Data da Dívida:"
					id="labelDate" />
					
				<input type="submit" value="Cadastrar" />
			</form>
			<a href="/menu" class="menu-link">Retornar ao Menu</a>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>