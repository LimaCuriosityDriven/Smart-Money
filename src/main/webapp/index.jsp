<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/index.css"/>
<script src="https://unpkg.com/@phosphor-icons/web"></script>
<title>Fintech</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
    <main>
        <div class="init">
            <h2>Olá, ${nome}!</h2>
            <select class="form-select form-select-sm" aria-label=".form-select-sm example">
                <option value="1">Janeiro</option>
                <option value="2">Fevereiro</option>
                <option value="3">Março</option>
                <option value="4">Abril</option>
                <option value="5">Maio</option>
                <option value="6">Junho</option>
                <option value="7">Julho</option>
                <option value="8">Agosto</option>
                <option value="9">Setembro</option>
                <option value="10">Outubro</option>
                <option value="11">Novembro</option>
                <option value="12">Dezembro</option>
            </select>
        </div>
        <div class="content">
            <div class="economia">
                <h3>Economia Mensal</h3>
                <div class="graphic">
                    <img  src="../images/graphic.png" alt="Gráfico Economia Mensal">
                </div>
                <p class="blue economia-items"><strong>R$ 510,70</strong></p>
                <p class="white-alpha economia-items">Valor Economizado</p>
                <div class="economia-infos">
                    <p>Receitas Consideradas</p>
                    <p class="blue"><strong>R$ 1.207,47</strong></p>
                    <p>Despesas Consideradas</p>
                    <p class="red"><strong>R$ 696,77</strong></p>
                </div>
                <div class="economia-icon-text">
                    <i class="ph-fill ph-star"></i>
                    <p>Você está indo bem!</p>
                </div>
            </div>
            <div class="receitas">
            	<a href="Recebimentos?action=listarrecebimentos">
	                <h3 class="text-light">Receitas <i class="ph-bold ph-plus icon-title blue"></i></h3>
	                <div class="card-content">
	                    <div class="card-item">
	                        <p class="total text-light">Total</p>
	                        <p class="valor-total text-light">R$ 1.207,47</p>
	                    </div>
	                    <div class="card-item">
	                        <p class="previsto white-alpha">Previsto</p>
	                        <p class="valor-previsto white-alpha">R$ 2.790,94</p>
	                    </div>
	                </div>
            	</a>
            </div>
            <div class="despesas">
            	<a href = "Despesas?action=listardespesa">
	                <h3 class="text-light">Despesas <i class="ph ph-minus icon-title red"></i></h3>
	                <div class="card-content">
	                    <div class="card-item">
	                        <p class="total text-light">Total</p>
	                        <p class="valor-total text-light">R$ 696,77</p>   
	                    </div>
	                    <div class="card-item">
	                        <p class="previsto white-alpha">Previsto</p>
	                        <p class="valor-previsto white-alpha">R$ 696,77</p>
	                    </div>
	                </div>
            	</a>
            </div>
            <div class="contas">
                <h3>Últimas Despesas</h3>
                <div class="contas-content">
                    <div class="itau contas-item">
                        <div class="contas-icon">
                            <i class="ph ph-fork-knife"></i>
                        </div>
                        <div class="contas-text">
                            <div class="content-text">
                                <p>Pizza</p>
                                <p>R$ 60,00</p>
                            </div>
                            <div class="content-text">
                            <p class="white-alpha font-sm">Data</p>
                                <p class="white-alpha font-sm">15/11</p>
                            </div>
                        </div>
                    </div>
                    <div class="nubank contas-item">
                        <div class="contas-icon">
                            <i class="ph ph-car"></i>
                        </div>
                        <div class="contas-text">
                            <div class="content-text">
                                <p>Uber</p>
                                <p>R$ 12,85</p>
                            </div>
                            <div class="content-text">
                            <p class="white-alpha font-sm">Data</p>
                                <p class="white-alpha font-sm">12/11</p>
                            </div>
                        </div>
                    </div>
                    <div class="carteira contas-item">
                        <div class="contas-icon">
                            <i class="ph ph-heart"></i>
                        </div>
                        <div class="contas-text">
                            <div class="content-text">
                                <p>Consulta</p>
                                <p>R$ 150,00</p>
                            </div>
                            <div class="content-text">
                                <p class="white-alpha font-sm">Data</p>
                                <p class="white-alpha font-sm">12/11</p>
                            </div>
                        </div>
                    </div>
                    <div class="total contas-item">
                        <div class="contas-icon">
                            <i class="ph ph-graduation-cap"></i>
                        </div>
                        <div class="contas-text">
                            <div class="content-text">
                                <p>Faculdade</p>
                                <p>R$ 1.035,00</p>
                            </div>
                            <div class="content-text">
                                <p class="white-alpha font-sm">Data</p>
                                <p class="white-alpha font-sm">02/11</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="pendencias">
                <div class="pendencias-items">
                    <i class="ph ph-currency-circle-dollar"></i>
                    <p>Você tem uma <strong>receita pendente</strong> no total de R$ 2.000,00</p>
                </div>
            </div>
        </div>
    </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>