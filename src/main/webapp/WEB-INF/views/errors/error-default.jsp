<%@ include file="/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Erro</title>
    <link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body>
	<header>
		<c:import url="header.jsp" />
		<h2>Caloteiros</h2>
	</header>
    <main>
        <h1>Error</h1>
        <p>Ops... Algum erro inesperado, verifique o preenchimento das informações.</p>
        <a href="menu.jsp">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="footer.jsp" />
    </footer>
</body>
</html>
