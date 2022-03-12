<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Buzón de mensajes</title>
		
        <link rel="icon" type="image/png" href="favicon.png" />
        <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/popper.min.js"></script>
		<link href="<%= AppHelper.baseUrl()%>css/font-awesome.min.css" rel="stylesheet">
        
        <link href="<%= AppHelper.baseUrl()%>css/plataforma.css" rel="stylesheet">
	</head>

	<body>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div style="min-width:224px">
                <img class="logoimg" src="<%= AppHelper.baseUrl()%>img/logo2_blanco.png" alt="LOGO" 
                     style="max-width: 150px; margin-left:auto; margin-right:auto; display:block">
            </div>
	      <div class="ml-auto menu-derecha">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Hola, ${user.nombre} ${user.apellidos}</button>
                    <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                      <a class="dropdown-item" href="<%= AppHelper.baseUrl()%>cuenta">Cuenta</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="<%= AppHelper.baseUrl()%>logout">Cerrar sesión</a>
                    </div>
                  </div>

	      </div>
	    </nav>

		<main role="main" class="wrapper">
		    <nav id="sidebar">
                <ul class="list-unstyled components">
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>plataforma"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a>
                    </li>
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>cursos"><i class="fa fa-book" aria-hidden="true"></i> Cursos</a>
                    </li>
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>mis_cursos"><i class="fa fa-question-circle" aria-hidden="true"></i> Mis cursos</a>
                    </li>
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>ayuda"><i class="fa fa-question-circle" aria-hidden="true"></i> Ayuda</a>
                    </li>
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>sitemap"><i class="fa fa-th-large" aria-hidden="true"></i> Mapa del sitio</a>
                    </li>
                </ul>
            </nav>
            
		    <div id="content" class="p-5">
		    	<div class="row">
		    		<div class="col-12">
		    			<h2>Cuenta</h2>
		    		</div>
		    	</div>
                <div class="row">
                    <div class="col">
                        <% if(request.getAttribute("resultado") != null) {
                            if((Boolean) request.getAttribute("resultado")) { %>
                                <div class="alert alert-success" role="alert">
                                    ${mensaje}
                                </div>
                            <% } else { %>
                                <div class="alert alert-danger" role="alert">
                                    ${mensaje}
                                </div>
                            <% } 
                        } %>
                    </div>
                </div>
                <div class="row">
		    		<div class="col-12">
		    			<form class="form" action="<%= AppHelper.baseUrl()%>/datos_cuenta" method="post" id="datos_cuentas">
                            <div class="form-row">
                                <div class="col-6 form-group">
                                    <label for="nombre"><h4>Nombre (s)</h4></label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" value="${nombre}">
                                </div>
                                <div class="col-6 form-group">
                                    <label for="apellidos"><h4>Apellidos</h4></label>
                                    <input type="text" class="form-control" name="apellidos" id="apellidos" value="${apellidos}">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col form-group">
                                    <label for="correo"><h4>Correo electrónico</h4></label>
                                    <input type="email" class="form-control" name="correo" id="correo" value="${correo}" placeholder="correo@dominio.com">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-12 form-group">
                                    <button class="btn btn-success btn-block" type="submit">Guardar</button>
                                </div>
                            </div>
                        </form> 
		    		</div>
		    	</div>
		    </div>
		</main>
        <script src="<%= AppHelper.baseUrl()%>js/jquery_validate.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/cuenta.js"></script>
	</body>
</html>
