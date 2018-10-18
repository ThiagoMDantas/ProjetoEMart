<%-- 
    Document   : index
    Created on : 07/10/2018, 18:09:55
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
        <link href="css/stylish-portfolio.min.css" rel="stylesheet">

    </head>

    <body id="page-top">


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
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home<span class="sr-only">(Página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sobre o EMart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cadastre seu Comercio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contatos</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <form class="form-inline">
                        <a class="nav-link" href="#"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cadastrar</button></a>
                        <a class="nav-link" href="#"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button></a>
                    </form>
                </span>
            </div>
        </nav>


        <header class="masthead d-flex" style="
                box-shadow: inset 0px 1px 12px 12px black;
                ">
            <div class="container text-center my-auto">
                <h1 class="mb-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" color="##0066ff">Bem vindos a EMart</font></font></h1>
                <h3 class="mb-5">
                    <em><font style="vertical-align: inherit;" color="ffffff"><font style="vertical-align: inherit;">Praticidade que nós gostariamos de ter nos nossos dias!</font></font></em>
                </h3>
                <form name="inicial" action="LoginControle" method="POST" id="formInicial">
                <a class="btn btn-primary btn-xl js-scroll-trigger" onClick="document.getElementById('formInicial').submit();"><font style="vertical-align: inherit;" ><font style="vertical-align: inherit;">Entrar</font></font></a>
                <input type="hidden" name="flag" value="Formlogin" onClick="document.getElementById('formInicial').submit();">
                </form>
            </div>
            <div class="overlay"></div>
        </header>


        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/stylish-portfolio.min.js"></script>


    </body>

</html>

