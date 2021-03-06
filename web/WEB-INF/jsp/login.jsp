<%-- 
    Document   : login
    Created on : 08/11/2015, 11:51:59
    Author     : William
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <script src="recursos/js/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>       


        <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>  
        <link href="recursos/bootstrap/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="divFormLogin">
            <h1 class="text-center">Entrar</h1>
            <form name="formLogin" method="post" action="efetua-login" class="formLogin">

                <div class="form-group">
                    <label for="usuario" class=""> Usuário:</label>
                    <input type="text" name="usuario" id="usuario" value="${loginCookie}" class="form-control">
                </div>
                    
                <div class="form-group">
                    <label for="senha" class=""> Senha:</label>
                    <input type="password" name="senha" id="senha" value="${senhaCookie}" class="form-control">  
                </div>
                
                <div class="form-inline">
                    <div class="">                    
                        <input type="checkbox" name="ckSalvaLogin" class=""/> 
                        <label for="ckSalvaLogin" style="margin-left: 0px;">Lembrar-me</label> 
                    </div>
                    
                    <div class="row">
                        <input type="submit" value="Entrar" name="entrar" id="entrar" class="btn-default btn-danger col-md-3 col-md-offset-6">
                    </div>
                </div>
            </form>

        </div>


    </body>
</html>
