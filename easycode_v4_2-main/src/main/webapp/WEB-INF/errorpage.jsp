<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>EasyCode - Error 404</title>
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
                <form>
                    <h1>404</h1>
                    <p>No se encontró la página solicitada.</p>
                    <div class="clearfix">
						<a href="<%= AppHelper.baseUrl()%>plataforma">Regresar a la plataforma<br></a>
					</div>  
                </form>
			</div>
		</div>
	</body>
</html> 