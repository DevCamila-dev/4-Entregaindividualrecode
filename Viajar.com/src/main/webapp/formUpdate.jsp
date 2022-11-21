<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Viajar.com - Atualizar Promoção</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/font-awesome.css"/>
    <link rel="stylesheet" href="./css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./css/style.css"/>
    <link rel="stylesheet" href="./css/responsive.css"/>
    <link rel="stylesheet" class="js-color-style" href="./css/colors/color-3.css"/>
</head>
<body>
 <!--main wrapper start-->
    <div class="main-wrapper">

        <!--header start-->
        <header class="header">
            <div class="container">
                <div class="header-main d-flex justify-content-between align-items-center">
                    <div class="header-logo">
                        <a href="index_promo.html"><img src="./img/logo.png"></a>
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
                            <li class="menu-item"><a href="index_promo.html">home</a></li>
                            <li class="menu-item"><a href="CreateAndFind1">Lista de Promoções</a></li>
                            
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <!--header end-->
        
        <!--breadcrumb start-->
        <div class="breadcrumb-nav">
            <div class="container">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="index_promo.html">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Atualização</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--breadcrumb end-->

<div class="container">
	<div class="row">
		<!--signup section start-->
        <section class="sign-up section-padding">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-6 col-xl-5">
                        <div class="signup-form box">
                            <h2 class="form-title text-center">Atualização de Promoção</h2>
                        <form action="CreateAndFind1" method="GET" class="menu-item d-flex">
                              <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou ID" aria-label="Search">
                              <button class="btn btn-block btn-theme" type="submit">Buscar</button>
                            </form>
                            <form action="CreateAndFind1" method="POST">
                                <div class="form-group mt-3">
                                	<label>Nome</label>
                                    <input value="${promocao.nome}" name="nome" maxlength="40" type="text" class="form-control">
                                </div>
                                <div class="form-group">                        
                                  <label>Valor da Promoção</label>
                                  <input value="${promocao.valorPromo}" name="valorPromo" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="R$">
                                </div>
                                <div class="form-group">
                                    <label>idDestino</label>
                                    <input value="${promocao.idDestino}" name="idDestino" maxlength="11" type="text" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-block btn-theme btn-form">Atualizar Promoção</button>
                                <button type="reset" class="btn btn-block btn-theme btn-form">Limpar Formulário</button>                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--signup section end-->
		
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>