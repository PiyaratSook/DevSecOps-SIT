<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Plataforma</title>
		
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
                    <li class="active">
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
		    			<h2>Temas disponibles</h2>
		    		</div>
		    	</div>
                <div class="row mb-2">
                    <div class="col">
                        <p>Los cursos en esta plataforma abarcan diversos temas, entre los que se encuentran:</p>
                    </div>
                </div>
		    	<div class="row mb-2">
		    		<div class="col-3 d-flex justify-content-center">
		    			<div class="card" style="width: 18rem;">
		    				<div class="bloque-img d-flex">
						  		<img src="<%= AppHelper.baseUrl()%>img/jquery1.png" class="card-img-top card-img-top mx-auto my-auto" alt="...">
						  	</div>
						  	<div class="card-body d-flex flex-column">
							    <h5 class="card-title">jQuery</h5>
							    <p class="card-text">jQuery es una librería de JavaScript de código abierto que permite agregar interactividad y efectos visuales en un sitio web.</p>
						  </div>
						</div>
					</div>
					<div class="col-3 d-flex justify-content-center">
		    			<div class="card" style="width: 18rem;">
						  	<div class="bloque-img d-flex">
						  		<img src="<%= AppHelper.baseUrl()%>img/html1.png" class="card-img-top card-img-top mx-auto my-auto" alt="...">
						  	</div>
						  	<div class="card-body d-flex flex-column">
							    <h5 class="card-title">HTML</h5>
							    <p class="card-text">HTML es el lenguaje con el que se define el contenido de las páginas web.</p>

						  	</div>
						</div>
					</div>
					<div class="col-3 d-flex justify-content-center">
		    			<div class="card" style="width: 18rem;">
						  	<div class="bloque-img d-flex">
						  		<img src="<%= AppHelper.baseUrl()%>img/java1.jpg" class="card-img-top card-img-top mx-auto my-auto" alt="...">
						  	</div>
						  	<div class="card-body d-flex flex-column">
							    <h5 class="card-title">Java</h5>
							    <p class="card-text">Java es un lenguaje de programación orientado a objetos que es muy utilizado para el desarrollo de aplicaciones.</p>
						  	</div>
						</div>
					</div>
                            <div class="col-3 d-flex justify-content-center">
		    			<div class="card" style="width: 18rem;">
						  	<div class="bloque-img d-flex">
						  		<img src="<%= AppHelper.baseUrl()%>img/php1.png" class="card-img-top card-img-top mx-auto my-auto" alt="...">
						  	</div>
						  	<div class="card-body d-flex flex-column">
							    <h5 class="card-title">PHP</h5>
							    <p class="card-text">PHP es un lenguaje de scripting de código abierto, del lado del servidor, con programación HTML integrada que se utiliza para crear páginas web dinámicas.</p>
						  	</div>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="col">
                        <a href="<%= AppHelper.baseUrl()%>cursos" class="btn btn-block btn-primary">Ver todos los cursos</a>
                    </div>
                </div>
		    </div>
		</main> 
	</body>
</html>