<%-- 
    Document   : Home
    Created on : 04/11/2018, 20:23:29
    Author     : Thiago
--%>

<%@page import="beans.Tipo"%>
<%@page import="beans.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">

    <head>
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="icon" type="image/gif" href="img/animated_favicon1.gif">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>EMart</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/homecss.css" rel="stylesheet">

    </head>
    <body id="page-top">

        <%
            ArrayList<Produto> arrprod = new ArrayList<Produto>();
            arrprod = (ArrayList<Produto>) request.getAttribute("produtos");

            ArrayList<Tipo> arrtipos = new ArrayList<Tipo>();
            arrtipos = (ArrayList<Tipo>) request.getAttribute("tipos");


        %>

        <nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light navbar-dark bg-dark">
            <center>
                <a class="navbar-brand" href="#">
                    <img src="img/logo.png" width="50" height="50" class="d-inline-block align-top" alt="">
                </a>
            </center>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#textoNavbar" aria-controls="textoNavbar" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="textoNavbar">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="ControleHome?flag=inicio">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sobre o EMart<span class="sr-only">(Página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LoginControle?flag=FormloginCoop">Cadastre seu Comercio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contatos</a>
                    </li>
                </ul>



                <form class="form-inline" action="ControleHome" method="POST">
                    <input class="form-control" type="search" placeholder="Pesquisa"  name="txtpesquisa" >
                    <input type="hidden" name="flag" value="pesquisa">
                    <a class="nav-link"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button></a>
                </form>
                <span>
                    <a class="navbar-brand" href="CarrinhoControle?flag=ViewCarrinho">
                        <img src="img/carrinho.png" width="50" height="50" class="d-inline-block align-top">
                    </a>

                </span>

            </div>


        </nav>

        <!-- Page Content -->


        <header class="masthead d-flex">
            <div class="container">

                <div class="row">

                    <div class="col-lg-3">

                        <h2 class="my-4">Setores</h2>
                        <div class="list-group">
                            <%                                
                                for (Tipo obj : arrtipos) {
                            %>

                            <a href="ControleHome?flag=setor&txtcategoria=<%= obj.getId()%>" class="list-group-item">
                                <input type="hidden" name="txtcategoria" value="<%= obj.getId()%>">
                                <%= obj.getTipo()%>
                            </a>

                            <%
                                }
                            %>
                        </div>

                    </div>
                    <!-- /.col-lg-3 -->

                    <div class="col-lg-9">

                        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <img class="d-block img-fluid" src="https://themefurnace-9fcd.kxcdn.com/wp-content/uploads/2016/11/black-wordpress-deals.jpg" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block img-fluid" src="img/BannerOferta.jpg" alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block img-fluid" src="img/Banner.jpg" alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>

                        <div class="row">



                            <%
                                for (Produto prod : arrprod) {
                            %>
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <a href="#"><img class="card-img-top" src="<%=prod.getImagem()%>" alt=""></a>
                                    <div class="card-body">
                                        <h4 class="card-title">
                                            <a href="#"><%=prod.getNome()%></a>
                                        </h4>
                                        <h5>$<%=prod.getValor()%></h5>
                                        <p class="card-text"><%=prod.getDetalhes()%></p>
                                    </div>
                                    <div class="card-footer">
                                        <small class="text-muted">
                                            <form action="CarrinhoControle" method="POST">
                                                <input type="hidden" name="idpadr" value="<%=prod.getProdutoPadrao().getId()%>">
                                                <input type="hidden" name="flag" value="AdicionarProduto">
                                                <button class="btn btn-outline-success my-sm-0" type="submit">Comprar</button>
                                            </form>
                                        </small>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>


                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.col-lg-9 -->

                </div>
                <!-- /.row -->

            </div>
        </header>
        <!-- /.container -->


        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>

