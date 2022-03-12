<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>EasyCode - Iniciar sesión</title>
        <link rel="icon" type="image/png" href="favicon.png" />
        
        <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
        <link href="<%= AppHelper.baseUrl()%>css/login.css" rel="stylesheet" >
        <style>
                .login-form {
                        width: 340px;
                        margin: 50px auto;
                }
                .login-form form {
                        margin-bottom: 15px;
                        background: #f7f7f7;
                        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                        padding: 30px;
                }
                .login-form h2 {
                        margin: 0 0 15px;
                }
                .form-control, .btn {
                        min-height: 38px;
                        border-radius: 2px;
                }
                .btn {        
                        font-size: 15px;
                        font-weight: bold;
                }
            </style>
    </head>
    <body>
        <div class="layer d-flex align-items-center justify-content-center">
            <div class="login-form">
                <form  method="post" action="<%= AppHelper.baseUrl()%>login_validation">
                    <a href="<%= AppHelper.baseUrl()%>"><img class="logoimg" src="http://localhost:8080/easycode_v2/img/opc2.png" alt="LOGO" 
                                    style="max-width: 250px;margin-right: auto;margin-left: auto;display: block;margin-bottom: 20px;"></a>
                    <h2 class="text-center">Inicio de sesión</h2>       
                    <div class="form-group">
                        <input type="email" name="correo" class="form-control" placeholder="Correo" required="required">
                        <span class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Contraseña" required="required">
                        <span class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="insert" value="Login" class="btn btn-primary btn-block">Inciar sesión</button>
                    </div>
                    <span class="text-danger">${message}</span><br>
                    <div class="clearfix">
                        <a href="<%= AppHelper.baseUrl()%>recuperar">¿Olvidaste tu contraseña?<br></a>
                        <a href="<%= AppHelper.baseUrl()%>registro">Crear una cuenta<br></a>
                    </div>        
                </form>
            </div>
        </div>
    </body>
</html> 