<%@ include file="/includes.jsp" %>
<html>
	<head>
		<title>Edita caloteiro</title>
		<link rel="stylesheet" type="text/css" href="css/update-caloteiro.css">
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
			<form action="system" method="post" id="formUpdate">
				<input type="hidden" name="logica" value="IncludeCaloteiro"/>
				<input type="hidden" name="form" value="update"/>
				<input type="hidden" name="id" value="${caloteiro.id}"/>
			
				<triadTag:textField 
					nameField="name" 
					label="Nome:" 
					id="labelName"
					value="${caloteiro.name}" /> 
				<triadTag:textField 
					nameField="email" 
					label="Email:" 
					id="labelEmail" 
					value="${caloteiro.email}" /> 
				<triadTag:textField 
					nameField="debt" 
					label="Devendo:" 
					id="labelDebt" 
					value="${caloteiro.debt}" />
				<fmt:formatDate value="${caloteiro.debtDate.time}"
					pattern="dd/MM/yyyy" var="dateFormatted" />
				<triadTag:textField 
					nameField="debtDate" 
					label="Data da Dívida:" 
					id="labelDate" 
					value="${dateFormatted}" />
				
				<input type="submit" value="Atualizar"/>
			</form>
			<a href="menu.jsp" class="menu-link">Retornar ao Menu</a>
		</main>
		<footer>
			<c:import url="footer.jsp" />
		</footer>
	</body>
</html>