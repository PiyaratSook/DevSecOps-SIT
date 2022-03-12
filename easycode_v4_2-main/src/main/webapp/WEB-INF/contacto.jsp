<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, shrink-to-fit=9">
      <meta name="description" content="EASYCODE">
      <meta name="author" content="UNIFYCODE">        
      <title>EASYCODE - Contáctanos</title>
      
      <link rel="icon" type="image/png" href="favicon.png" />
      <link href="<%= AppHelper.baseUrl()%>css/bootstrap.min.css" rel="stylesheet">
      <script src="<%= AppHelper.baseUrl()%>js/jquery.min.js"></script>
      <script src="<%= AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
      <link href="<%= AppHelper.baseUrl()%>css/principal.css" rel="stylesheet" >
      <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
      <script> var base_url = "<%= AppHelper.baseUrl()%>"</script>
    </head>

    <body>
      <div class="layer">
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
          <header class="masthead mb-auto">
            <div class="inner">
              <img class="logoimg" src="<%= AppHelper.baseUrl()%>img/logo2_blanco.png" alt="LOGO" style="max-width: 250px">
              <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link" href="<%= AppHelper.baseUrl()%>">Principal</a>
                <a class="nav-link" href="<%= AppHelper.baseUrl()%>login">Acceder</a>
                <a class="nav-link active" href="<%= AppHelper.baseUrl()%>contacto">Contáctanos</a>
              </nav>
            </div>
          </header>

          <main role="main" class="inner cover">
                <form id="form-contacto" method="post" action="<%= AppHelper.baseUrl()%>contacto">
                    <h2 class="text-center">Contáctanos</h2>
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="nombre">Nombre completo</label>
                            <input type="text" name="nombre" class="form-control" placeholder="Nombre completo" required>
                            <span class="text-danger"></span>
                        </div>
                        <div class="form-group col-6">
                            <label for="correo">Correo</label>
                            <input type="email" name="correo" class="form-control" placeholder="Correo" required>
                            <small id="emailHelp" class="form-text text-muted">Sólo se ocupará para responder a tu contacto</small>
                            <span class="text-danger"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mensaje">Mensaje</label>
                        <textarea class="form-control" id="mensaje" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="insert" value="Login" class="btn btn-primary btn-block">Enviar mensaje</button>
                    </div>     
                </form>
          </main>

          <footer class="mastfoot mt-auto text-center">
            <div class="inner">
              <p>IDGS01 - Consuelo, Pueblo, Israel y Armando</p>
            </div>
          </footer>
        </div>
      </div>
    </body>
</html>
