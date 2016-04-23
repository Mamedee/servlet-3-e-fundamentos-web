<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado!=null}">
    Você está logado como ${usuarioLogado.getEmail()}<br/>
</c:if>

<form action="centralizador?acao=NovaEmpresa" method="post">
	Nome: <input type="text" name="nome"/> <br/>
	<input type="submit" value="Enviar"/>
</form>

<form action="centralizador?acao=" method="post">
	Email: <input type="text" name="email"/></br>
	Senha: <input type="password" name="senha"/></br>
	<input type="submit" value="Login">
</form>

<form action="centralizador?acao=logout" method="post">
	<input type="submit" value="Logout">
</form>

</body>
</html>