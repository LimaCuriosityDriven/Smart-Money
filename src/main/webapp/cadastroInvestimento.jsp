<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/cadastroDespesa.css"/>
<script src="https://unpkg.com/@phosphor-icons/web"></script>
<title>Fintech</title>
	<%@ include file="menu.jsp" %>
</head>
<body>
<main>
        <div class="init">
            <h2>Adicionar Investimento</h2>
            <div>
                <button class="btn-back">
                	<a href="Investimentos?action=listarinvestimento">Voltar</a>
                </button>
                <button type="submit" form="formReceita" class="btn-save">Salvar</button>
            </div>
        </div>
        <c:if test="${not empty msg }">
				<div class="alert alert-success alert-dismissible" role="alert">${msg}
					<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger alert-dismissible" role="alert">${erro}
					<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
        <div class="form">
            <form action="Investimentos" method="post" autocomplete="off" id="formReceita">
                <input type = "hidden" value = "cadastrarinvestimento" name = "action">
                <div class="col">
                    <div class="input-item">
                        <i class="ph ph-text-align-left"></i>
                        <input type="text" name="nomeinvestimento" id="" placeholder="Descrição" required>
                    </div>
                    
                    <div class="input-item">
                        <i class="ph ph-currency-circle-dollar"></i>
                        <input type="number" name="valorinvestimento" id="" placeholder="R$ 0,00" min="0" required>
                    </div>
                    <div class="input-item">
                        <i class="ph ph-arrow-u-down-left"></i>
                        <input type="number" name="valorretornoinvestimento" id="" placeholder="R$ 0,00" min="0" required>
                    </div>
                </div>
                <div class="line"></div>
                <!-- Coluna 2 -->
                <div class="col">
                   
                    <div class="input-item ">
                        <div class="col d-flex justify-content-between ">
                            <div class="d-flex align-items-center">
                                <i class="ph ph-calendar"></i>
                                <p>Data do Investimento</p>
                            </div>
                            <input type="text" name="datainvestimento" placeholder="dd/MM/aaaa" required>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </main>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>