<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>CodeCoach</title>

    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="assets/plugins/aos/aos.css">

    <link rel="stylesheet" href="assets/css/style.css">
    <script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


</head>

<body>


    <div class="main-wrapper">

        <!-- Header is placed here -->
        <%@include file="header.jsp" %>
        <!--End of header-->

        <!--Content start-->
        <section class="section section-search">
            <div class="container">
                <div class="banner-wrapper m-auto text-center aos" data-aos="fade-up">
                    <div class="banner-header">
                        <h1>Search Mentor in <span>CodeCoach Appointment</span></h1>
                        <p>Discover the best Mentors with your desire skills set</p>
                    </div>

                    <!--                    <div class="search-box">
                                            <form action="search" method="post">
                                                <div class="form-group search-info">
                                                    <input name="searchTxt" type="text" class="form-control"
                                                           placeholder="Search Skills, Categories, Mentor's name, etc">
                                                </div>
                                                <button type="submit" class="btn btn-primary search-btn"><i><img
                                                            src="assets/img/search-submit.png" alt></i> <span>Search</span></button>
                                            </form>
                                        </div>-->

                </div>
            </div>
        </section>

        <section class="section how-it-works">
            <div class="container">
                <div class="section-header text-center aos" data-aos="fade-up">
                    <span>CodeCoach Flow</span>
                    <h2>How does it works ?</h2>
                    <p class="sub-title">Are you looking to join online institutions? Now it's very simple, Sign up with
                        CodeCoach</p>
                </div>
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-1.png" alt></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Sign up</div>
                                </div>
                            </div>
                            <p class="mb-0">Are you looking to join online Learning? It's very simple
                            </p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-2.png" alt></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Becoming a mentor</div>
                                </div>
                            </div>
                            <p class="mb-0">Collaborate on your own timing, by register with mentor booking</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-3.png" alt></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Improve & Get Back</div>
                                </div>
                            </div>
                            <p class="mb-0">You can gather different skill set, and you can become mentor too</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    <!-- Pre footer -->
    <section class="section statistics-section">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-4">
                    <div class="statistics-list text-center aos" data-aos="fade-up">
                        <span>500+</span>
                        <h3>Happy Clients</h3>
                    </div>
                </div>
                <div class="col-12 col-md-4">
                    <div class="statistics-list text-center aos" data-aos="fade-up">
                        <span>120+</span>
                        <h3>Online Appointments</h3>
                    </div>
                </div>
                <div class="col-12 col-md-4">
                    <div class="statistics-list text-center aos" data-aos="fade-up">
                        <span>100%</span>
                        <h3>Job Satisfaction</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end of Pre footer -->

    <!--Content end-->

    <!--Footer start-->
    <%@include file="footer.jsp" %>
    <!-- Footer end -->

</div>


<script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="assets/js/jquery-3.6.0.min.js"></script>

<script src="assets/js/bootstrap.bundle.min.js"></script>

<script src="assets/js/owl.carousel.min.js"></script>

<script src="assets/plugins/aos/aos.js"></script>

<script src="assets/js/script.js"></script>
</body>
</html>
