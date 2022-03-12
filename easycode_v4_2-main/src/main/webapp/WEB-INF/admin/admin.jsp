<%@page import="java.util.List"%>
<%@page import="dao.User"%>
<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Administración</title>
		
        <link rel="icon" type="image/png" href="favicon.png" />
        <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/popper.min.js"></script>
		<link href="<%= AppHelper.baseUrl()%>css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<%= AppHelper.baseUrl()%>css/datatables_bootstrap4.min.css"/>
        <script type="text/javascript" src="<%= AppHelper.baseUrl()%>js/datatables.min.js"></script>
        
        <link href="<%= AppHelper.baseUrl()%>css/plataforma.css" rel="stylesheet">
        <link rel="stylesheet" href="<%= AppHelper.baseUrl()%>css/simple-calendar.css">
        <style>
            .faqHeader {
                font-size: 27px;
                margin: 20px;
            }

            .panel-heading [data-toggle="collapse"]:after {
                font: normal normal normal 14px/1 FontAwesome;
                content: "\f04b";
                float: right;
                color: #F58723;
                font-size: 18px;
                line-height: 22px;
                /* rotate "play" icon from > (right arrow) to down arrow */
                -webkit-transform: rotate(-90deg);
                -moz-transform: rotate(-90deg);
                -ms-transform: rotate(-90deg);
                -o-transform: rotate(-90deg);
                transform: rotate(-90deg);
            }

            .panel-heading [data-toggle="collapse"].collapsed:after {
                /* rotate "play" icon from > (right arrow) to ^ (up arrow) */
                -webkit-transform: rotate(90deg);
                -moz-transform: rotate(90deg);
                -ms-transform: rotate(90deg);
                -o-transform: rotate(90deg);
                transform: rotate(90deg);
                color: #454444;
            }
        </style>
	</head>

	<body>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div style="min-width:224px">
                <img class="logoimg" src="<%= AppHelper.baseUrl()%>img/logo2_blanco.png" alt="LOGO" 
                     style="max-width: 150px; margin-left:auto; margin-right:auto; display:block">
            </div>
            <div class="mr-auto">
                <span class="badge badge-danger" style="font-size: 25px;background-color: #FB0707;">ZONA ADMINISTRATIVA</span>
            </div>
	      <div class="ml-auto menu-derecha">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Hola, ${user.nombre} ${user.apellidos}</button>
                    <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right">
                      <a class="dropdown-item" href="<%= AppHelper.baseUrl()%>logout">Cerrar sesión</a>
                    </div>
                  </div>

	      </div>
	    </nav>

		<main role="main" class="wrapper">
            <nav id="sidebar">
                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="<%= AppHelper.baseUrl()%>admin"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a>
                    </li>
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>admin_cursos"><i class="fa fa-book" aria-hidden="true"></i> Cursos</a>
                    </li>
                </ul>
            </nav>
            
		    <div id="content" class="p-5">
		    	<div class="row mb-2">
		    		<div class="col-12">
		    			<h2>Inicio de administración</h2>
		    		</div>
		    	</div>
                
                <div class="row mb-4">
                    <div class="col-md-3">
                        <div class="card-counter primary">
                            <i class="fa fa-users"></i>
                            <span class="count-numbers">${usuarios_registrados}</span>
                            <span class="count-name">Usuarios registrados</span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card-counter danger">
                            <i class="fa fa-graduation-cap"></i>
                            <span class="count-numbers">${cursos_registrados}</span>
                            <span class="count-name">Cursos registrados</span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card-counter success">
                            <i class="fa fa-shopping-cart "></i>
                            <span class="count-numbers">${ventas_realizadas}</span>
                            <span class="count-name">Ventas realizadas</span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card-counter info">
                            <i class="fa fa-money"></i>
                            <span class="count-numbers">$${total_vendido}</span>
                            <span class="count-name">Total vendido</span>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-6">
                        <div id="calendario">
                        </div>
                    </div>
                    <div class="col-6">
                        <div id="usuarios-registrados" class="text-center">
                            <h3>Usuarios registrados</h3>
                        </div>
                        <div id="table-wrap">
                            <table class="table table-borderless text-center" >
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Tipo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% 
                                        List<User> usuarios;
                                        if(request.getAttribute("usuarios") != null) {
                                            usuarios = (List<User>) request.getAttribute("usuarios");

                                            for(User usuario : usuarios) { %>
                                                <tr>
                                                    <td><%=usuario.getNombre()%> <%=usuario.getApellidos()%></td>
                                                    <td><%=usuario.getCorreo()%></td>
                                                    <td><%=usuario.getTipo_usuario()%></td>
                                                </tr>
                                                <%
                                            }
                                        } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
		</main> 
        <script src="<%= AppHelper.baseUrl()%>js/jquery.simple-calendar.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/admin.js"></script>
	</body>
</html>