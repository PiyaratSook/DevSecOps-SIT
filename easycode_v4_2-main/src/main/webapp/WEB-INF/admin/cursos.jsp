<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="translated-ltr">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, shrink-to-fit=9">
		<meta name="description" content="EASYCODE">
		<meta name="author" content="UNIFYCODE">		
		<title>EasyCode - Cursos</title>
		
        <link rel="icon" type="image/png" href="favicon.png" />
        <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
        <link href="<%= AppHelper.baseUrl()%>css/font-awesome.min.css" rel="stylesheet">
        <link href="<%= AppHelper.baseUrl()%>css/summernote-bs4.min.css" rel="stylesheet">
        
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/popper.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/summernote-bs4.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/summernote-es-ES.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/sweetalert2_all.min.js"></script>
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
                    <li>
                        <a href="<%= AppHelper.baseUrl()%>admin"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a>
                    </li>
                    <li class="active">
                        <a href="<%= AppHelper.baseUrl()%>admin_cursos"><i class="fa fa-book" aria-hidden="true"></i> Cursos</a>
                    </li>
                </ul>
            </nav>
            
		    <div id="content" class="p-5">
		    	<div class="row mb-2">
		    		<div class="col-12">
		    			<h2>Gestión de cursos</h2>
		    		</div>
		    	</div>
                
                <div class="row mb-2">
                    <div class="col-6">
                    </div>
                    <div class="col-6"> 
                        <button class="btn btn-block btn-success" id="nuevo_curso" data-toggle="modal" data-target="#modal_agregar">Agregar curso</button>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-12">
                        <table class="table" id="tabla_cursos">
                            <thead> 
                                <tr>
                                    <th style="width: 5%">ID</th>
                                    <th style="width: 30%">Nombre</th>
                                    <th style="width: 30%">Descripción</th>
                                    <th style="width: 10%">Categoría</th>
                                    <th style="width: 10%">Costo</th>
                                    <th style="width: 10%">Acciones</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
                
                <div class="row mb-4">
                    <div class="col-12">
                    </div>
                </div>
            </div>
		</main> 
        <div class="modal fade" id="modal_agregar" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" id="form_nuevo">
                            <div class="form-row">
                                <div class="col-6 form-group">
                                    <label for="nombre">Nombre</label>
                                    <input class="form-control" type="text" id="nombre" name="nombre" required>
                                </div>

                                <div class="col-3 form-group">
                                    <label for="costo">Costo</label>
                                    <div class="input-group">
                                        <div class="input-group-preappend">
                                            <span class="input-group-text">$</span>
                                        </div>
                                        <input class="form-control" type="text" id="costo" name="costo" required>
                                    </div>
                                </div>

                                <div class="col-3 form-group">
                                    <label forcategoriatipo">Categoría</label>
                                    <select class="form-control" id="categoria" name="categoria">
                                        <option value="HTML">HTML</option>
                                        <option value="jQuery">jQuery</option>
                                        <option value="PHP">PHP</option>
                                        <option value="Java">Java</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="col-12 form-group">
                                    <label for="descripcion">Descripción</label>
                                    <input class="form-control" type="text" id="descripcion" name="descripcion" required>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="col-12">
                                    <label for="editor">Contenido del curso</label>
                                    <div id="editor">
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="col-6">
                                    <button type="submit" class="btn btn-success btn-block">Agregar</button>
                                </div>
                                <div class="col-6">
                                    <button type="button" class="btn btn-danger btn-block" data-dismiss="modal">Cancelar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<%= AppHelper.baseUrl()%>js/cursos_admin.js"></script>
	</body>
</html>