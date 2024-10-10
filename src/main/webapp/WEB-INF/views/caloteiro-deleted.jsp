<%@ include file="/includes.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Caloteiro deletado</title>
    <link rel="stylesheet" type="text/css" href="css/action-completed.css">
</head>
<body>
	<header>
		<c:import url="header.jsp" />
		<h1>Caloteiros</h1>
	</header>
    <main>
        <h3>Sucesso</h3>
        <p>Caloteiro ${name} deletado com sucesso.</p>
        <a href="menu.jsp">Retornar ao Menu</a>
    </main>
    <footer>
       <c:import url="footer.jsp" />
    </footer>
</body>
</html>
