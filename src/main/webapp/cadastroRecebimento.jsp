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
            <h2>Adicionar Receita</h2>
            <div>
                <button class="btn-back">
                	<a href="./index.jsp">Voltar</a>
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
            <form action="Recebimentos" method="post" autocomplete="off" id="formReceita">
            	<input type ="hidden" name = "action" value = "cadastrarrecebimento">
                <!-- Coluna 1 -->
                <div class="col">
                    <div class="input-item">
                        <i class="ph ph-text-align-left"></i>
                        <input type="text" name="nomerecebimento" id="" placeholder="Descrição" required>
                    </div>
                    <div class="input-item">
                        <i class="ph ph-currency-circle-dollar"></i>
                        <input type="number" name="valorrecebimento" id="" placeholder="R$ 0,00" min="0" required>
                    </div>
                    <div class="input-item">
                        <div class="col d-flex">
                            <i class="ph ph-check-circle"></i>
                            <p>Efetivada</p>
                        </div>
                        <div class="cl-toggle-switch">
                            <label class="cl-switch">
                                <input type="checkbox" name="statusrecebimento" value = "1">
                                <span></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="line"></div>
                <!-- Coluna 2 -->
                <div class="col">
                   
                    <div class="input-item ">
                        <div class="col d-flex justify-content-between ">
                            <div class="d-flex align-items-center">
                                <i class="ph ph-calendar"></i>
                                <p>Data de Recebimento</p>
                            </div>
                            <input type="text" name="datarecebimento" placeholder = "dd/mm/aaaa" required>
                        </div>
                    </div>
                                       <div class="input-item">
                        <i class="ph ph-files"></i>
                        <input type="text" name="descrecebimento" id="" placeholder="Descrição">
                    </div>
                    <p class="label-categoria">Categoria</p>
                    <div class="input-item" id="input-categoria">
                        <div class="circle">
                            <i class="ph-fill ph-shapes"></i>
                        </div>
                        <select class="form-select" id="categorySelect" aria-label="Default select example" name="categoria">
                            <option value="Alimentação">Benefícios</option>
                            <option value="Transporte">Comissão</option>
                            <option value="Educação">Pagamentos</option>
                            <option value="Moradia">Rendimentos</option>
                            <option value="Serviços">Serviços</option>
                            <option value="Saúde">Vendas</option>
                            <option selected value="Outros">Outros</option>
                        </select>
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