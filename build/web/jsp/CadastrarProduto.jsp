<%-- 
    Document   : CadastrarProduto
    Created on : 18/11/2018, 14:27:44
    Author     : Thiago
--%>

<%@page import="beans.Tipo"%>
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
                ArrayList<Tipo> arrtipos = new ArrayList<Tipo>();
                arrtipos = (ArrayList<Tipo>) request.getAttribute("tipos");


            %>



        <header class="masthead">
            <form class="form-horizontal" method="POST" action="ControleCadastro">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Cadastro de Produtos</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtcodigo_produto_id">Cód. Produto : </label>  
                        <div class="col-md-2">
                            <input id="txtcodigo_produto_id" name="cod_prod" type="text" placeholder="" class="form-control input-md">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtproduto">Produto : </label>  
                        <div class="col-md-6">
                            <input id="txtproduto" name="nome_prod" type="text" placeholder="Descrição do Produto" class="form-control input-md" required="">

                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtgrupo">Grupo : </label>
                        <div class="col-md-4">
                            <select id="txtgrupo" name="op" class="form-control">
                                <%                                for (Tipo obj : arrtipos) {
                                %>
                                <option value="<%= obj.getId()%>"><%=obj.getTipo()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtestoque_minimo">Valor Unitário : </label>  
                        <div class="col-md-2">
                            <input id="txtestoque_minimo" name="valor_prod" type="text" placeholder="" class="form-control input-md" required="">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtestoque_atual">Estoque Atual : </label>  
                        <div class="col-md-2">
                            <input id="txtestoque_atual" name="quantidade" type="text" placeholder="" class="form-control input-md">

                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="btnsalvar"></label>
                        <div class="col-md-8">
                            <button type="submit" name="btnsalvar" class="btn btn-primary">Salvar</button>
                            <button id="btncancelar" name="btncancelar" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>

                </fieldset>
            </form>


        </header>
    </body>
</html>
