<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/index.css"/>
<title>Fintech</title>
</head>
<body>
	<aside class="menu">
        <img src="./resources/images/logo.png" alt="">
        <div class="d-flex align-items-start">
            <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill"
                    data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home"
                    aria-selected="true">
                    <i class="ph ph-house"></i>
                    <a href="index.jsp" class="text-light">
	                    Dashboard                    
                    </a>
                </button>
                <button class="nav-link" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button"
                    role="tab" aria-controls="v-pills-profile" aria-selected="false">
                    <i class="ph ph-currency-circle-dollar"></i>
                    <a href="Investimentos?action=listarinvestimento">
                        Investimento
                    </a>
                </button>
                <button class="nav-link" data-bs-toggle="pill" data-bs-target="#v-pills-disabled" type="button"
                    role="tab" aria-controls="v-pills-disabled" aria-selected="false">
                    <i class="ph ph-target"></i>
                    Objetivos
                </button>
                <button class="nav-link" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button"
                    role="tab" aria-controls="v-pills-messages" aria-selected="false">
                    <i class="ph ph-gear"></i>
                    Configurações
                </button>
                <button class="nav-link" data-bs-toggle="pill" data-bs-target="#v-pills-settings" type="button"
                    role="tab" aria-controls="v-pills-settings" aria-selected="false">
                    <i class="ph ph-question"></i>
                    Suporte
                </button>
                <a href="./login.jsp">
                    <button class="logout" type="button">
                        <i class="ph ph-sign-out"></i>
                        <span>Sair</span>
                    </button>
                </a>
            </div>
        </div>
    </aside>
    <nav class="navbar">
        <div class="container-fluid">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false">
                    <i class="ph-bold ph-plus"></i>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="./cadastroDespesa.jsp">Despesa <i class="ph ph-minus icon-title red"></i></a></li>
                    <li><a class="dropdown-item" href="./cadastroRecebimento.jsp">Receita <i class="ph-bold ph-plus icon-title blue"></i></a>
                    </li>
                </ul>
            </div>
            <div class="botoes-navbar">
                <div class="botao-navbar">
                    <button class="btn btn-secondary btn-theme">
                        <i class="ph ph-moon"></i>
                    </button>
                </div>
                <div class="botao-navbar2">
                    <button class="btn btn-secondary btn-theme">
                        <i class="ph ph-bell"></i>
                    </button>
                </div>
                <div class="profile">
                    <p>${usuario}</p>
                    <i class="ph ph-user-circle"></i>
                </div>
            </div>
        </div>
    </nav>
</body>
</html>