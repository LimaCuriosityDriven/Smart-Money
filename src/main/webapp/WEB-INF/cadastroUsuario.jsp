<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/cadastroUsuario.css"/>
<script src="https://unpkg.com/@phosphor-icons/web"></script>
<title>Fintech</title>
</head>
<body>
	<form action="cadastroUsuario" method="post" autocomplete="off">
        <div class="box">
            <div class="container">
                <p>Cadastre-se</p>
            </div>
            <div class="container">
                <div>
                    <p for="nome" class="label">Nome Completo</p>
                    <i class="ph ph-user"></i>
                    <input type="text" placeholder="Digite seu nome" id="nome" required autofocus>
                </div>
                <div>
                    <p for="apelido" class="label">Apelido</p>
                    <i class="ph ph-identification-card"></i>
                    <input type="text" placeholder="Como quer ser chamado(a)?" id="apelido" required>
                </div>
                <div>
                    <p for="email" class="label">E-mail</p>
                    <i class="ph ph-envelope"></i>
                    <input type="email" placeholder="Digite seu e-mail" id="email" required>
                </div>
                <div>
                    <p for="telefone" class="label">Telefone</p>
                    <i class="ph ph-phone"></i>
                    <input type="tel" placeholder="(00) 0000-0000" id="telefone" required>
                </div>
                <div>
                    <p for="dtNascimento" class="label">Data de Nascimento</p>
                    <i class="ph ph-calendar"></i>
                    <input type="text" placeholder="00/00/0000" id="dtNascimento" required>
                </div>
                <div>
                    <p for="senha" class="label">Sua senha</p>
                    <i class="ph ph-lock"></i>
                    <input type="password" placeholder="*******" id="senha" required>
                </div>
            </div>
            <div class="container">
                <p>
                    <input class="btn" type="submit" value="Cadastrar">
                </p>
            </div>
            <div class="container">
                <a href="login.jsp">Já possui conta? Faça login</a>
            </div>
        </div>
    </form>
</body>
</html>