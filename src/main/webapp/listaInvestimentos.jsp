<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="resources/css/lista.css"/>
<script src="https://unpkg.com/@phosphor-icons/web"></script>
<title>Fintech</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<main>
        <div class="init">
            <h2>Investimentos</h2>
            <div>
                <button class="btn-back">
                    <a href="index.jsp">Voltar</a>
                </button>
                <a href = "cadastroInvestimento.jsp">
                	<button class = "btn-save">
                		Novo Investimento
                	</button>
                </a>
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
        
        
        <c:forEach items="${investimentos}" var="i">
	       
	        <div class="d-flex despesa">
	            <div>
	                <div class="d-flex">
	                    <p>${i.nm_investimento}</p>
	                    <p class="ms-5">R$ ${i.vl_investimento}</p>
	                </div>
	                <div class="white-alpha">Data:  <fmt:formatDate value="${i.dt_investimento}" pattern="dd/MM/yyyy"/></div>
	            </div>
	            <div>
		         	<c:url value="Investimentos" var="link">
						<c:param name="action" value="open-form-investimentoedicao"/>
						<c:param name="idinvestimento" value="${i.id_investimento}"/>
					</c:url>
					<a href ="${link}">
						<button class="edit-button">
							<i class="ph ph-pencil-simple"></i>
						</button>
					</a> 
		            <button class="delete-button" data-bs-target="#modalConfirmarExclusao" data-bs-toggle="modal" onclick = "idRemover.value = ${i.id_investimento}">    
		                <i class="ph ph-trash"></i>
		            </button>          
	            </div>
	        </div>
	        
        </c:forEach>  
    
    
    <div class="modal fade" id="modalConfirmarExclusao" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" >
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5">Aten��o!</h1>
                    </div>
                    <div class="modal-body">
                        Tem certeza que deseja excluir essa despesa?
                    </div>
                    <div class="modal-footer">
                    	<form action="Investimentos" method="post">
    						<input type="hidden" name="action" value="excluirinvestimento">
    						<input type="hidden" name="idinvestimento" id="idRemover">
    						<button type="button" class="close-button" data-bs-dismiss="modal">Fechar</button>
    						<button type="submit" class="delete-button">Excluir</button>
						</form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    
</body>
</html>