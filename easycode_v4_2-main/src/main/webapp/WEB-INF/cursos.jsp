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
        <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/popper.min.js"></script>
        <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
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
                    <li class="active">
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
		    		<div class="col-8">
		    			<h2>Cursos disponibles</h2>
		    		</div>
                    <div class="col-4">
                        <input type="text" id="buscador_cursos" class="form-control" placeholder="Buscar cursos...">
		    		</div>
		    	</div>
		    	<div class="row mb-4" id="lista_cursos">
				</div>
		    </div>
		</main> 
        <div class="modal fade" id="modal_pago" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Pagar curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-6">
                                <div class="card">
                                    <div class="card-body">
                                        <form class="form" role="form" autocomplete="off" id="form_tarjeta">
                                            <div class="form-group">
                                                <label for="titular">Titular</label>
                                                <input type="text" class="form-control" id="titular" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Número de tarjeta</label>
                                                <input type="text" class="form-control" id="num_tarjeta" required>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-6">
                                                    <label>Fecha de expiración</label>
                                                    <div class="form-row">
                                                        <div class="col-6">
                                                            <select class="form-control" name="cc_exp_mo" size="0">
                                                                <option value="01">01</option>
                                                                <option value="02">02</option>
                                                                <option value="03">03</option>
                                                                <option value="04">04</option>
                                                                <option value="05">05</option>
                                                                <option value="06">06</option>
                                                                <option value="07">07</option>
                                                                <option value="08">08</option>
                                                                <option value="09">09</option>
                                                                <option value="10">10</option>
                                                                <option value="11">11</option>
                                                                <option value="12">12</option>
                                                            </select>
                                                        </div>
                                                         <div class="col-6">
                                                            <select class="form-control" name="cc_exp_yr" size="0">
                                                                <option>21</option>
                                                                <option>22</option>
                                                                <option>23</option>
                                                                <option>24</option>
                                                                <option>25</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="form-group">
                                                        <label for="cvv">Código CVV</label>
                                                        <input type="text" class="form-control" id="cvv" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="costo">Costo</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend"><span class="input-group-text">$</span></div>
                                                    <input type="text" class="form-control text-right" id="costo">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                 <div class="card">
                                    <div class="card-body">
                                        <h4>Resumen de compra</h4>
                                        <table id="resumen" class="table table-borderless">
                                            <thead>
                                                <tr>
                                                    <th>Curso</th>
                                                    <th>Costo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td id="resumen_titulo"></td>
                                                    <td id="resumen_costo"></td>
                                                </tr>
                                                <tr>
                                                    <td>Envío</td>
                                                    <td>Gratis</td>
                                                </tr>
                                                <tr class="border-top">
                                                    <th>Total</th>
                                                    <th id="resumen_total"></th>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-2">
                            <div class="col-6">
                                <button type="button" class="btn btn-success btn-block" id="pagar_curso">Pagar</button>
                            </div>
                            <div class="col-6">
                                <button data-dismiss="modal" class="btn btn-danger btn-block">Cancelar</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="progress d-none" id="progress_bar_div">
                                    <div class="progress-bar progress-bar-striped bg-success progress-bar-animated" 
                                         role="progressbar" style="width: 0%" id="barra_progreso">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</body>
    <script src="<%= AppHelper.baseUrl()%>js/cursos.js"></script>
</html>