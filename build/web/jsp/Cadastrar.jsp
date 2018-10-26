<%-- 
    Document   : Cadastrar
    Created on : 18/10/2018, 14:10:32
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
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sobre o EMart<span class="sr-only">(Página atual)</span>s</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cadastre seu Comercio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contatos</a>
                    </li>
                </ul>

            </div>
        </nav>
        <header class="masthead d-flex" >
            <div class="container text-center my-auto" >
                <h2 class="mb-1"><font style="vertical-align: inherit;"></font></h2>

                <form action="CadastroControle?flag=realizarCadastro" method="POST">
                    <label class="align-top"><h3>Cadastro</h3></label>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" placeholder="Nome" name="txtnome" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" placeholder="447.939.344-44" name="txtcpf" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="cpf">Data de Nascimento</label>
                            <input type="date" class="form-control" placeholder="04/04/1999" name="txtdatanasc" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="telefone">Telefone</label>
                            <input type="" class="form-control" placeholder="(11) 99999-9999" name="txttelefone" required>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="sexo">Sexo</label>
                            <select id="sexo" class="form-control" name="txtsexo" required>
                                <option selected>Sexo...</option>
                                <option value="M">Masculino</option>
                                <option value="F">Feminino</option>
                            </select>
                        </div>
                        
                            </div>
                        <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="fulano@umc.com" name="txtemail" required>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="rua">Rua</label>
                                <input type="text" class="form-control" id="rua" placeholder="Rua dos Bobos" name="txtrua" required>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="numero">Numero</label>
                                <input type="text" class="form-control" id="numero" placeholder="638" name="txtnumero" required>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" id="bairro" placeholder="Jardim dos Anjos" name="txtbairro" required>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" id="cep" name="txtcep" required>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" id="cidade" placeholder="São Paulo" name="txtcidade" required>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="inputEstado">Estado</label>
                                <select id="inputEstado" class="form-control" name="txtestado" required>
                                    <option selected>Escolher...</option>
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
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="usuario">Usuario</label>
                                <input type="email" class="form-control" id="usuario" placeholder="fulano@yahoo.com" name="txtcadusuario" required>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" placeholder="Senha" name="txtcadsenha" required>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
            <div class="overlay"></div>

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
