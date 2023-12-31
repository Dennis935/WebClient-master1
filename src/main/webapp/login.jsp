<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/tooltip.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-7h7s6+sg5uQw3G1O7w4AjlCE+hK8Vi7uMz5F8xAt1VqSz9tLJZ3zNj6k0I5bvlww" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="js/tooltip.js"></script>

</head>
<body>
<div class="top-navbar">
  <div class="logo">
    <a href="index.jsp"><h1>TicketHouse</h1></a>
  </div>
  <div class="navbar-icons">
    <div class="login-icon" id="loginButton">
      <a href="login.jsp"><i class="fas fa-user" style="color: white;"></i></a>
      <div class="tooltip">Login</div>
    </div>
  </div>
</div>

<div class="loginWhiteBox">
<form id="login-form" action="LoginServlet" method="post">
  <!-- Username input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">Username</label>
    <input type="text" id="form2Example1" name="username" class="form-control" />
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">Password</label>
    <input type="password" id="form2Example2" name="password" class="form-control" />
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Remember me </label>
      </div>
    </div>

    <div class="col">
      <!-- Simple link -->
      <a href="#!">Forgot password?</a>
    </div>
  </div>

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

  <!-- Register buttons -->
  <div class="text-center">
    <p>Not a member? <a href="#!">Register</a></p>
    <p>or sign up with:</p>
    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-facebook-f"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-google"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-twitter"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-github"></i>
    </button>
  </div>
</form>
</div>
</body>
<footer class="text-center text-lg-start text-white"
        style="background-color: #1D1B15">
  <!-- Grid container -->
  <div class="container p-4 pb-0">
    <!-- Section: Links -->
    <section class="">
      <!--Grid row-->
      <div class="row">
        <!-- Grid column -->
        <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">
            TicketHouse
          </h6>
          <p>
            We are here to help you! Use our links in the footer
            for more Information about us.
          </p>
        </div>
        <!-- Grid column -->

        <hr class="w-100 clearfix d-md-none" />

        <!-- Grid column -->
        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">More Information</h6>
          <p>
            <a class="text-white">Newsletter</a>
          </p>
          <p>
            <a class="text-white">AGB</a>
          </p>
          <p>
            <a class="text-white">Guarantee</a>
          </p>
          <p>
            <a class="text-white">Impressum</a>
          </p>
        </div>
        <!-- Grid column -->

        <hr class="w-100 clearfix d-md-none" />

        <!-- Grid column -->
        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">
            Useful links
          </h6>
          <p>
            <a class="text-white">Your Account</a>
          </p>
          <p>
            <a class="text-white">Become an Affiliate</a>
          </p>
          <p>
            <a class="text-white">Shipping Rates</a>
          </p>
          <p>
            <a class="text-white">Help</a>
          </p>
        </div>

        <!-- Grid column -->
        <hr class="w-100 clearfix d-md-none" />

        <!-- Grid column -->
        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
          <p><i class="fas fa-home mr-3"></i> Dornbirn, 6850, Vorarlberg</p>
          <p><i class="fas fa-envelope mr-3"></i> supportTickethouse@gmail.com</p>
          <p><i class="fas fa-phone mr-3"></i> +43 664 12345</p>
          <p><i class="fas fa-print mr-3"></i> +43 664 54321</p>
        </div>
        <!-- Grid column -->
      </div>
      <!--Grid row-->
    </section>
    <!-- Section: Links -->

    <hr class="my-3">

    <!-- Section: Copyright -->
    <section class="p-3 pt-0">
      <div class="row d-flex align-items-center">
        <!-- Grid column -->
        <div class="col-md-7 col-lg-8 text-center text-md-start">
          <!-- Copyright -->
          <div class="p-3">
            © 2023Copyright:
            <a class="text-white" href="https://mdbootstrap.com/"
            >TicketHouse.com</a
            >
          </div>
          <!-- Copyright -->
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-5 col-lg-4 ml-lg-0 text-center text-md-end">
          <!-- Facebook -->
          <a
                  class="btn btn-outline-light btn-floating m-1"
                  class="text-white"
                  role="button"
          ><i class="fab fa-facebook-f"></i
          ></a>

          <!-- Twitter -->
          <a
                  class="btn btn-outline-light btn-floating m-1"
                  class="text-white"
                  role="button"
          ><i class="fab fa-twitter"></i
          ></a>

          <!-- Google -->
          <a
                  class="btn btn-outline-light btn-floating m-1"
                  class="text-white"
                  role="button"
          ><i class="fab fa-google"></i
          ></a>

          <!-- Instagram -->
          <a
                  class="btn btn-outline-light btn-floating m-1"
                  class="text-white"
                  role="button"
          ><i class="fab fa-instagram"></i
          ></a>
        </div>
        <!-- Grid column -->
      </div>
    </section>
    <!-- Section: Copyright -->
  </div>
  <!-- Grid container -->
</footer>
<!-- Footer -->
<!-- End of .container -->
</html>
