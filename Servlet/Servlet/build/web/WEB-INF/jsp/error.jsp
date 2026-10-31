<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

    <div class="container min-vh-100 d-flex justify-content-center align-items-center">

        <div class="card shadow-lg text-center p-5" style="max-width: 500px;">

            <h1 class="text-danger display-4">Oops!</h1>

            <h3>Something went wrong.</h3>

            <p class="text-muted mt-3">
                We couldn't process your request.
                Please try again.
            </p>

            <div class="alert alert-danger mt-3">
                An unexpected error occurred.
            </div>

            <a href="${pageContext.request.contextPath}/index.html"
               class="btn btn-primary mt-3">
                Go Back Home
            </a>

        </div>

    </div>

</body>
</html>