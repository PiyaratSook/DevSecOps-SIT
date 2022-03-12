<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8;charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>EASYCODE - REGISTRO</title>
		<link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
		<link href="<%= AppHelper.baseUrl()%>css/registro.css" rel="stylesheet" >
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
                <form  id="registro" method="post" action="<%= AppHelper.baseUrl()%>registro">
                    <a href="<%= AppHelper.baseUrl()%>"><img class="logoimg" src="http://localhost:8080/easycode_v2/img/opc2.png" alt="LOGO" 
                                    style="max-width: 250px;margin-right: auto;margin-left: auto;display: block;margin-bottom: 20px;"></a>
                    <h2 id="registro" class="text-center">Registro</h2> 
					<div class="form-group">
						<input type="text" name="nombre" id="nombre" class="form-control" placeholder="Nombre" required>
					</div>
					<div class="form-group">
						<input type="text" name="apellidos" id="apellidos" class="form-control" placeholder="Apellido" required>
					</div>	
					<div class="form-group">
						<input type="email" name="correo" id="correo" class="form-control" placeholder="Correo" required>
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control" placeholder="Contraseña" required>
					</div>
					<div class="form-group">
						<button  type="submit" method="post" name="registro" id="registro" class="btn btn-primary btn-block">Registrarse</button>
					</div>
                    <span class="text-danger">${message}</span><br>
					<div class="clearfix">
						<a href="<%= AppHelper.baseUrl()%>login">¿Ya tienes una cuenta?<br></a>
					</div>        
				</form>
			</div>
		</div>
        <script type="text/javascript" src="<%= AppHelper.baseUrl()%>js/jquery_validate.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/registro.js"></script>
	</body>
</html> 