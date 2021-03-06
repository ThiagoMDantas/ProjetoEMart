<%-- 
    Document   : Carrinho
    Created on : 16/11/2018, 13:01:55
    Author     : Thiago
--%>

<%@page import="beans.Cooperador"%>
<%@page import="beans.ProdutoPadrao"%>
<%@page import="beans.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

        <style>
            .filterable {
                margin-top: 15px;
            }
            .filterable .panel-heading .pull-right {
                margin-top: -20px;
            }
            .filterable .filters input[disabled] {
                background-color: transparent;
                border: none;
                cursor: auto;
                box-shadow: none;
                padding: 0;
                height: auto;
            }
            .filterable .filters input[disabled]::-webkit-input-placeholder {
                color: #333;
            }
            .filterable .filters input[disabled]::-moz-placeholder {
                color: #333;
            }
            .filterable .filters input[disabled]:-ms-input-placeholder {
                color: #333;
            }

        </style>
    </head>

    <body>

        <nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light navbar-dark bg-dark">
            <center>
                <a class="navbar-brand" href="ControleHome">
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
                        <a class="nav-link" href="#">Sobre o EMart<span class="sr-only">(Página atual)</span>s</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LoginControle?flag=FormloginCoop">Cadastre seu Comercio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contatos</a>
                    </li>
                </ul>

            </div>

        </nav>

        <%

            ArrayList<Produto> arrmeusprod = new ArrayList<Produto>();
            arrmeusprod = (ArrayList<Produto>) request.getAttribute("ProdutosCooperador");

            Cooperador fonecedor = new Cooperador();
            fonecedor = (Cooperador) request.getAttribute("dados");

        %>


        <header class="masthead">
            <div class="panel">
                <div class="col-md-12">
                    <div class="panel panel-primary filterable">
                        <div class="panel-heading">
                            <h3 class="panel-title">Meus</h3>
                            <h3 class="panel-title">Produtos</h3>
                        </div>
                    </div>
                </div>
            </div>




            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col">Detalhes</th>
                        <th scope="col">Setor</th>
                        <th scope="col">Imagem</th>
                        <th scope="col">R$</th>
                        <th scope="col"></th>

                    </tr>
                </thead>
                <tbody>
                    <%                             
                        for (Produto obj : arrmeusprod) {
                    %>
                    <tr>



                        
                        <td><%=obj.getId()%></td>
                        <td><%=obj.getNome()%></td>
                        <td><%=obj.getQuantidade()%></td>
                        <td><%=obj.getDetalhes()%></td>
                        <td><%=obj.getTipo().getTipo()%></td>
                        <td><%=obj.getImagem()%></td>
                        <td><%=obj.getValor()%></td>


                        <td scope="col">
                            <label>
                                <form action="ProdutoControle" method="POST">
                                    <input type="hidden" name="checkId" value="<%=obj.getId()%>">
                                    <input type="hidden" name="flag" value="exluir">
                                    <button type="submit" class="btn btn-primary">Excluir</button>
                                </form>
                            </label> 
                            <label>
                                <form action="ProdutoControle" method="POST">
                                    <input type="hidden" name="checkId" value="<%=obj.getId()%>">
                                    <input type="hidden" name="flag" value="alterar">
                                    <button type="submit" class="btn btn-primary">Alterar</button>
                                </form>
                            </label>
                        </td>

                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>


            <form action="ProdutoControle" method="POST">
                <center>
                    <span>

                        <a><button type="submit" class="btn btn-primary">Cadastrar Produto</button></a>
                        <input type="hidden" value="cadastrar" name="flag"> 
                    </span>
                </center>
            </form>


        </header>







        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/stylish-portfolio.min.js"></script>

    </body>
</html>
