<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/bootstrap_import.html" />
    <title>Connexion</title>
</head>
<body class="h-100 container-fluid text-light bg-dark bg-gradient text-light m-0 p-0">
<header class="header bg-dark p-4 border-bottom border-light">
    <div class="container">
        <h3>Exo6.com</h3>
    </div>
</header>
<main class="w-100 d-flex align-center">
    <div class="container bg-dark mt-4 p-4 pb-1 rounded w-25 border border-light">
        <form method="post" action="${pageContext.request.contextPath}/user/login">
            <h4 class="text-center pb-4 border-bottom border-light text-bold">Connexion</h4>
            <div class="d-flex flex-row mb-4">
                <div class="d-flex flex-column w-50">
                    <div class="input-group mb-3 d-flex flex-column">
                        <label class="text-center mb-2 fw-semibold" for="email">Email : </label>
                        <div class="input-group w-full px-2">
                            <input class="form-control bg-dark border border-light text-light" type="email" name="email" id="email" />
                        </div>
                    </div>
                </div>
                <div class="d-flex flex-column w-50">
                    <div class="input-group mb-3 d-flex flex-column">
                        <label class="text-center mb-2 fw-semibold" for="password">Mot de passe : </label>
                        <div class="input-group w-full px-2">
                            <input class="form-control bg-dark border border-light text-light" type="password" name="password" id="password" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="py-4 border-top border-light">
                <button class="btn btn-outline-light w-100">Connexion</button>
            </div>
            <div class="d-flex justify-end justify-content-end px-4">
                <p class="d-block px">Vous n'avez pas de compte? <a class="text-light" href="${pageContext.request.contextPath}/user/register">Inscription</a></p>
            </div>
        </form>
    </div>
</main>
</body>
</html>