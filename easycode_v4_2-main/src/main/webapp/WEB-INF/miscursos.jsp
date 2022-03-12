<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Mis cursos</title>
		
        <link rel="icon" type="image/png" href="favicon.png" />
        <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/popper.min.js"></script>
		<link href="<%= AppHelper.baseUrl()%>css/font-awesome.min.css" rel="stylesheet">
        
        <script>
            var base_url = "<%= AppHelper.baseUrl()%>";
        </script>
        
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
                    <li class="active">
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
		    			<h2>Mis cursos comprados</h2>
		    		</div>
		    	</div>
		    	<div class="row">
                    <div class="col-12">
                        <table class="table" id="tabla_cursos">
                            <thead> 
                                <tr>
                                    <th style="width: 20%">Nombre</th>
                                    <th style="width: 35%">Descripción</th>
                                    <th style="width: 10%">Categoría</th>
                                    <th style="width: 10%">Fecha de compra</th>
                                    <th style="width: 10%">Costo</th>
                                    <th style="width: 10%">Acciones</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
		    </div>
		</main> 
        <script src="<%= AppHelper.baseUrl()%>js/cursos_user.js"></script>
	</body>
</html>