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
        <title>EASYCODE - Principal</title>

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
                            <a class="nav-link active" href="<%= AppHelper.baseUrl()%>">Principal</a>
                            <a class="nav-link" href="<%= AppHelper.baseUrl()%>login">Acceder</a>
                            <a class="nav-link" href="<%= AppHelper.baseUrl()%>contacto">Contáctanos</a>
                        </nav>
                    </div>
                </header>

                <main role="main" class="inner cover text-center">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <h1 class="cover-heading">Plataforma de apoyo a estudiantes</h1>
                                <p class="lead">Esta es una plataforma web que ayuda a la enseñanza de la correcta programación por medio de información didáctica. Los usuarios que se registren tendrán acceso a los tópicos para mejorar la organización de sus códigos</p>
                                <p class="lead">
                                    <a href="<%= AppHelper.baseUrl()%>login" class="btn prueba">Acceder</a>
                                </p>
                            </div>
                            <div class="carousel-item">
                                <h1 class="cover-heading">Aprende los mejores consejos para programar adecuadamente</h1>
                                <p class="lead">Contamos con temas de programación como JQuery, C++, Java, CodeIgniter y mucho más</p>
                                <p class="lead">
                                    <a href="<%= AppHelper.baseUrl()%>login" class="btn prueba">Acceder</a>
                                </p>
                            </div>
                            <div class="carousel-item">
                                <h1 class="cover-heading">Contamos con una sección de ayuda y buzón</h1>
                                <p class="lead">En nuestra plataforma puedes encontrar las dudas más comunes de nuestros usuarios y un buzón para contactarnos en caso de que necesites ayuda personalizada</p>
                                <p class="lead">
                                    <a href="<%= AppHelper.baseUrl()%>login" class="btn prueba">Acceder</a>
                                </p>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="sr-only">Next</span>
                        </a>
                    </div> 
                </main>

                <footer class="mastfoot mt-auto text-center">
                  <div class="inner">
                    <p>IDGS01 - Consuelo, Pueblo, Israel y Armando</p>
                  </div>
                </footer>
            </div>
        </div>
        <script src="<%= AppHelper.baseUrl()%>js/principal.js"></script>
    </body>
</html>
