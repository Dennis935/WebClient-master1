<!DOCTYPE html>
<html>
<head>
    <title>TicketHouse</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/tooltip.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-7h7s6+sg5uQw3G1O7w4AjlCE+hK8Vi7uMz5F8xAt1VqSz9tLJZ3zNj6k0I5bvlww" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/tooltip.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

</head>

<body>
<div class="top-navbar">
    <div class="logo">
        <a href="index.jsp"><h1>TicketHouse</h1></a>
    </div>
    <div class="navbar-icons">
        <% String username = (String) session.getAttribute("username");
            if (username != null) { %>
        <div class="login-icon" id="logoutButton">
            <span>Welcome, <%= username %></span>
            <a href="LogoutServlet" id="logoutLink"><i class="fas fa-sign-out-alt" style="color: white;"></i></a>
            <div class="tooltip">Logout</div>
        </div>
        <% } else { %>
        <div class="login-icon" id="loginButton">
            <a href="login.jsp"><i class="fas fa-user" style="color: white;"></i></a>
            <div class="tooltip">Login</div>
        </div>
        <% } %>
        <div class="cart-icon" id="cartButton">
            <a href="ProfileServlet"><i class="fas fa-shopping-cart" style="color: white;"></i></a>
            <div class="tooltip">Cart</div>
        </div>
    </div>
</div>

<div class="whiteBox">
    <div class="genreContainer border-bottom ">
        <h3>Filter</h3>
        <form id="filterForm">
            <div class="filter-row">
                <label>
                    <input type="checkbox" name="genre" value="Rock" style="cursor: pointer;">
                    Rock
                </label>
                <label>
                    <input type="checkbox" name="genre" value="Classic" style="cursor: pointer;">
                    Classic
                </label>
                <label>
                    <input type="checkbox" name="genre" value="Pop" style="cursor: pointer;">
                    Pop
                </label>
                <label>
                    <input type="checkbox" name="genre" value="Rap" style="cursor: pointer;">
                    Rap
                </label>
            </div>
            <div class="filter-row">
                <label>
                    Startdatum:
                    <input type="date" name="startDate" style="width: 150px;">
                </label>
                <label>
                    Enddatum:
                    <input type="date" name="endDate" style="width: 150px;">
                </label>
            </div>
            <div class="filter-row">
                <button class="filterButton" type="submit">Filtern</button>
            </div>
        </form>
    </div>

    <div class="events">
        <h3>Events</h3>
        <form>
            <div id="eventData"></div>
            <div class="loader" id="loader">
                <div class="loading-bar"></div>
                <div class="loading-bar"></div>
                <div class="loading-bar"></div>
                <div class="loading-bar"></div>
            </div>
            <br>
        </form>
    </div>
    <div class="pagination" id="paginationContainer"></div>
</div>


</body>
<!-- Remove the container if you want to extend the Footer to full width. -->
    <!-- Footer -->
    <footer class="text-center text-lg-start text-white"
            style="background-color: #090907">
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
