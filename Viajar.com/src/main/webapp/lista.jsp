<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Viajar.com - Lista de Destinos</title>
<link rel="stylesheet" href="./css/font-awesome.css"/>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/style.css"/>
<link rel="stylesheet" href="./css/responsive.css"/>
<link rel="stylesheet" class="js-color-style" href="./css/colors/color-3.css"/>
</head>
<body>
      <!--header start-->
        <header class="header">
            <div class="container">
                <div class="header-main d-flex justify-content-between align-items-center">
                    <div class="header-logo">
                        <a href="index.html"><img src="./img/logo.png"></a>
                    </div>
                    <button type="button" class="header-hamburger-btn js-header-menu-toggler">
                        <span></span>
                    </button>
                    <div class="header-backdrop js-header-backdrop"></div>
                    <nav class="header-menu js-header-menu">
                        <button type="button" class="header-close-btn js-header-menu-toggler">
                            <i class="fas fa-times"></i>
                        </button>
                        <ul class="menu">
                            <li class="menu-item"><a href="index.html">home</a></li>
                            <li class="menu-item"><a href="CreateAndFind">Lista de Destinos</a></li>                            
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <!--header end-->
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Destinos Cadastrados</h3>
			<hr>
			<form action="CreateAndFind" method="GET" class="d-flex">
              <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou ID" aria-label="Search">
              <button class="btn btn-success btn-theme" type="submit">Buscar</button>
            </form>
            <hr>
			<table class="table box">
				<thead>
					<tr>
						<th>idDestino</th>
						<th>Nome</th>
						<th>Estado</th>
						<th>Pais</th>
						<th>Data de Ida</th>
						<th>Data de Volta</th>
						<th>Valor</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${destinos}" var="destino">
							<tr>
								<td>${destino.idDestino}</td>
								<td>${destino.nome}</td>
								<td>${destino.estado}</td>
								<td>${destino.pais}</td>
								<td>${destino.dataIda}</td>
								<td>${destino.dataVolta}</td>
								<td>${destino.valor}</td>
								<td>
									<button class="btn btn-danger" href="DestinoDeleter?destinoId=${destino.idDestino}">deletar</button> |
									<button class="btn btn-success" href="DestinoUpdate?destinoId=${destino.idDestino}">atualizar</button>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-theme" href="index.html">Voltar para o Cadastro de Destinos</button>
		</div>
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>