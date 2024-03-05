<%--
  Created by IntelliJ IDEA.
  User: Alumno Tarde
  Date: 04/03/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/ccs/css3.css">
</head>
<body>
<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Registro</a></li>
        <li class="tab"><a href="#login">Logearse</a></li>
    </ul>

    <div class="tab-content">
        <div id="signup">
            <h1>Resgistrese Gratis</h1>

            <form action="/" method="post">

                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            Nombres<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off" />
                    </div>

                    <div class="field-wrap">
                        <label>
                            Apellidos<span class="req">*</span>
                        </label>
                        <input type="text" required autocomplete="off" />
                    </div>
                </div>

                <div class="field-wrap">
                    <label>
                        Dirección Email<span class="req">*</span>
                    </label>
                    <input type="email" required autocomplete="off" />
                </div>

                <div class="field-wrap">
                    <label>
                        Crear Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off" />
                </div>

                <button type="submit" class="button button-block" />Alla Vamos !!!</button>

            </form>

        </div>

        <div id="login">
            <h1>Te Extrañamos!</h1>

            <form action="/" method="post">

                <div class="field-wrap">
                    <label>
                        Dirección Email<span class="req">*</span>
                    </label>
                    <input type="email" required autocomplete="off" />
                </div>

                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input type="password" required autocomplete="off" />
                </div>

                <p class="forgot"><a href="#">Has Olvidado Tu Password?</a></p>

                <button class="button button-block" />Ya Estas Dentro</button>

            </form>

        </div>

    </div><!-- tab-content -->

</div> <!-- /form -->
</body>
</html>
