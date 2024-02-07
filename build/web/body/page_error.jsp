<% String message = (String)request.getAttribute("message"); %>
<% String numero = (String)request.getAttribute("numero"); %>

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<main>
    <div class="container">

      <section class="section error-404 min-vh-100 d-flex flex-column align-items-center justify-content-center">
        <h1><%out.print(numero);%></h1>
        <h2><%out.print(message);%></h2>
        <a class="btn" href="">Back to home</a>
        <img src="assets/img/not-found.svg" class="img-fluid py-5" alt="Page Not Found">
      </section>

    </div>
</main>