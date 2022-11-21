<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Viajar.com - Lista de Promoções</title>
<link rel="stylesheet" href="./css/font-awesome.css"/>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/style.css"/>
<link rel="stylesheet" href="./css/responsive.css"/>
<link rel="stylesheet" class="js-color-style" href="./css/colors/color-3.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="./img/logo.png" alt="Viajar.com"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index_promo.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind1">Lista de Promoções</a>
        </li>
      </ul>
      <form action="CreateAndFind1" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou ID" aria-label="Search">
        <button class="btn btn-outline- btn-theme" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Promoções Cadastradas</h3>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th>idPromo</th>
						<th>Nome</th>
						<th>valorPromo</th>
						<th>idDestino</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${promocoes}" var="promocao">
							<tr>
								<td>${promocao.idPromo}</td>
								<td>${promocao.nome}</td>
								<td>${promocao.valorPromo}</td>
								<td>${promocao.idDestino}</td>
								<td>
									<a href="PromocaoDeleter?promoId=${promocao.idPromo}">deletar</a> |
									<a href="PromocaoUpdate?promoId=${promocao.idPromo}">atualizar</a>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<h5><a href="index_promo.html">Voltar para o Cadastro de Promocões</a></h5>
		</div>
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>