<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Ayuda</title>
		
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
			</ul>-->
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
                    <li class="active">
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
		    			<h2>Ayuda</h2>
		    		</div>
		    	</div>
                
                <div class="row justify-content-center">
                    <div class="col-10">
                    <div class="panel-group" id="accordion">
                        <div class="faqHeader">Preguntas generales</div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#preg1">¿Los cursos tienen un certificado para el usuario?</a>
                                </h4>
                            </div>
                            <div id="preg1" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    No, nosotros solo compartimos el conocimiento a través de nuestros cursos para facilitar el aprendizaje de forma autónoma pero no otorgamos certificados.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#preg2">¿Hasta que grado llegan los cursos? </a>
                                </h4>
                            </div>
                            <div id="preg2" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    Dan las bases fundamentales sobre diversas tecnologías en el desarrollo actual.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#preg3">¿Qué incluyen los cursos?</a>
                                </h4>
                            </div>
                            <div id="preg3" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    Incluye retroalimentación sobre el lenguaje de programación de tu interés para guíarte con consejos y prácticas para aprender cómo se puede codificar de forma ordenada y correcta.
                                </div>
                            </div>
                        </div>

                        <div class="faqHeader">Pagos</div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#preg4">¿Qué métodos de pago aceptan?</a>
                                </h4>
                            </div>
                            <div id="preg4" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    Aceptamos pagos por medio de PayPal, tarjeta de crédito y débito, depósito bancario, transferencia SPEI y pago por OXXO.
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">¿Con quién debo contactar si necesito ayuda?</a>
                                </h4>
                            </div>
                            <div id="preg5" class="panel-collapse collapse">
                                <div class="panel-body">
                                    Puedes enviarnos un mensaje mediante la sección de contáctanos.
                                </div>
                            </div>
                        </div>
                    </div>
                
                    </div>
                </div>
		    </div>
		</main> 
	</body>
</html>