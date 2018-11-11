<%-- 
    Document   : CadastrarCooperador
    Created on : 11/11/2018, 16:36:49
    Author     : Thiago
--%>

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
                    <li class="nav-item">
                        <a class="nav-link" href="ControleHome">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sobre o EMart<span class="sr-only">(Página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cadastre seu Comercio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contatos</a>
                    </li>
                </ul>


            </div>
             <span class="navbar-text">
                 <form class="form-inline" action="LoginControle?=Formlogin">
                        <a class="nav-link" href="#"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button></a>
                    </form>
                </span>


        </nav>

        <header class="masthead d-flex" >
            <div class="container text-center my-auto" >
                <h2 class="mb-1"><font style="vertical-align: inherit;"></font></h2>

                <form action="CooperadorControle" method="POST">
                    <label class="align-top"><h3>Cadastro Empresarial</h3></label>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="empresa"><strong>Empresa</strong></label>
                            <input id="empresa" type="text" class="form-control" placeholder="EMart Mercado Online" name="txtempresa" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="cnpj"><strong>CNPJ</strong></label>
                            <input id="cnpj" type="text" class="form-control" placeholder="447.939.344-44" name="txtcnpj" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefone"><strong>Telefone</strong></label>
                            <input id="telefone" type="text" class="form-control" placeholder="(11) 1111-1111" name="txttelefone" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="email"><strong>Email para contato</strong></label>
                            <input id="email" type="text" class="form-control" placeholder="emart@hotmail.com" name="txtemail" required>
                        </div>

                    </div>
                    <label class="align-top"><h3>Endereço</h3></label>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="rua"><strong>Rua</strong></label>
                            <input id="rua" type="text" class="form-control" placeholder="Estrada Himala" name="txtrua" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="numero"><strong>Numero</strong></label>
                            <input id="numero" type="text" class="form-control" placeholder="1221" name="txtnumero" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="bairro"><strong>Bairro</strong></label>
                            <input id="bairro" type="text" class="form-control" placeholder="Jardim Alemanha" name="txtbairro" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="cep"><strong><strong>CEP</strong></strong></label>
                            <input id="cep" type="text" class="form-control" placeholder="08587000" name="txtcep" required>
                        </div>
                        



                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="complemento"><strong>Complemento</strong></label>
                            <input id="complemento" type="text" class="form-control" placeholder="Predio 1" name="txtcomplemento" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="cidade"><strong><strong>Cidade</strong></strong></label>
                            <input id="cidade" type="text" class="form-control" placeholder="São Paulo" name="txtcidade" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputEstado"><strong>Estado</strong></label>
                            <select id="inputEstado" class="form-control" name="txtestado" required>
                                <option selected value="0">Escolher...</option>
                                <option>Acre (AC)</option>
                                <option>Alagoas (AL)</option>
                                <option>Amapá (AP)</option>
                                <option>Amazonas (AM)</option>
                                <option>Bahia (BA)</option>
                                <option>Ceará (CE)</option>
                                <option>Distrito Federal (DF)</option>
                                <option>Espírito Santo (ES)</option>
                                <option>Goiás (GO)</option>
                                <option>Maranhão (MA)</option>
                                <option>Mato Grosso (MT)</option>
                                <option>Mato Grosso do Sul (MS)</option>
                                <option>Minas Gerais (MG)</option>
                                <option>Pará (PA)</option>
                                <option>Paraíba (PB)</option>
                                <option>Paraná (PR)</option>
                                <option>Pernambuco (PE)</option>
                                <option>Piauí (PI)</option>
                                <option>Rio de Janeiro (RJ)</option>
                                <option>Rio Grande do Norte (RN)</option>
                                <option>Rio Grande do Sul (RS)</option>
                                <option>Rondônia (RO)</option>
                                <option>Roraima (RR)</option>
                                <option>Santa Catarina (SC)</option>
                                <option>São Paulo (SP)</option>
                                <option>Sergipe (SE)</option>
                                <option>Tocantins (TO)</option>
                            </select>


                        </div>

                    </div>
                    <label class="align-top"><h3>Usuário</h3></label>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="usuario"><strong>Usuario</strong></label>
                            <input type="email" class="form-control" id="usuario" placeholder="fulano@yahoo.com" name="txtcadusuario" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="senha"><strong>Senha</strong></label>
                            <input type="password" class="form-control" id="senha" placeholder="Senha" name="txtcadsenha" required>
                        </div>
                        <input type="hidden" name="flag" value="cadastrarCooperador">
                    </div>

                    <button type="submit" class="btn btn-primary">Cadastrar</button>



                </form>


        </header>

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
