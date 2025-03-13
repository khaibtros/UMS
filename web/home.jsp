<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>MKD university</title>

    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon1.png">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="assets/plugins/aos/aos.css">

    <link rel="stylesheet" href="assets/css/style.css">
    <script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


</head>

<body data-aos-easing="ease" data-aos-duration="1200" data-aos-delay="0" data-new-gr-c-s-check-loaded="14.1226.0" data-gr-ext-installed="">


    <div class="main-wrapper">

        <!-- Header is placed here -->
        



    
    <div class="main-wrapper">
        <header class="header">
            <div class="header-fixed">
                <nav class="navbar navbar-expand-lg header-nav">
                    <div class="navbar-header">
                        <a id="mobile_btn" href="javascript:void(0);">
                            <span class="bar-icon">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </a>
                        <a href="/ums/home" class="navbar-brand logo">
                            <img src="assets/img/logo1.png" class="img-fluid" alt="Not Found" onerror="this.src=&quot;../assets/img/logo1.png&quot;">
                        </a>
                    </div>
                    <div class="main-menu-wrapper">
                        <div class="menu-header">
                            <a href="/ums/home" class="menu-logo">
                                <img src="assets/img/logo.png" class="img-fluid" alt="Logo">
                            </a>
                            <a id="menu_close" class="menu-close" href="javascript:void(0);">
                                <i class="fas fa-times"></i>
                            </a>
                        </div>
                        <ul class="main-nav">
                            <li class="has-submenu">
                                <a href="/ums/home">Home <i class="fas"></i></a>
                            </li>

                            <!--                            <li class="has-submenu">
                                                            <a href='search?searchTxt='>Search mentor <i class="fas"></i></a>
                            
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="listchat">Chat <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="contactus">Contact Us <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="faq">FAQ <i class="fas "></i></a>
                                                        </li>-->

                            <!--Admin, student, instructor dashboard button-->
                            
                            
                            
                            <!--end of  button-->

                            <li class="login-link">
                                <a href="login">Login / Signup</a>
                            </li>
                        </ul>
                    </div>

                    <!-- login header -->
                    
                    <!-- end of login header -->


                    <!-- default header -->
                    
                        <ul class="nav header-navbar-rht">

                            <li class="nav-item">
                                <a class="nav-link header-login" href="/ums/login">Login</a>
                            </li>
                            <!--                            <li class="nav-item">
                                                            <a class="nav-link header-login" href="logout">Logout</a>
                                                        </li>-->
                        </ul>
                    
                    <!-- end of default header -->
                </nav>
            <div class="sidebar-overlay"></div><div class="sidebar-overlay"></div><div class="sidebar-overlay"></div><div class="sidebar-overlay"></div></div>
        </header>
    </div>


        

        
        <section class="section section-search">
            <div class="container">
                <div class="banner-wrapper m-auto text-center aos aos-init aos-animate" data-aos="fade-up">
                    <div class="banner-header">
                        <h1>Đại Học<span> Đầu Hàng Công Nghệ Việt Nam</span></h1>
                        <p>Discover the best Mentors with your desire skills set</p>
                    </div>

                    <div class="search-box">
                        <form action="search" method="post">
                            <div class="form-group search-info">
                                <input name="searchTxt" type="text" class="form-control" placeholder="Tìm hiểu ngay">
                            </div>
                            <button type="submit" class="btn btn-primary search-btn"><i><img src="assets/img/search-submit.png" alt=""></i> <span>Search</span></button>
                        </form>
                    </div>

                </div>
            </div>
        </section>

        <section class="section how-it-works">
            <div class="container">
                <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">
                    
                    <span></span><h2>Học cùng chuyên gia - Định hướng tương lai</h2>
                    <p class="sub-title" style="
    font-weight: 400;
">Chúng tôi tự hào mang đến đội ngũ giảng viên, cố vấn là những chuyên gia hàng đầu trong lĩnh vực của họ.</p>
                </div>
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-1.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Đăng kí dễ dàng</div>
                                </div>
                            </div>
                            <p class="mb-0" style="
    height: 41px;
">Chỉ cần vài bước đơn giản, bạn có thể trở thành sinh viên của MKD ngay hôm nay!</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-2.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Đội ngũ giàu kinh nghiệm</div>
                                </div>
                            </div>
                            <p class="mb-0">Các mentor đến từ các doanh nghiệp lớn, trường đại học danh tiếng.</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-3.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Mạng lưới kết nối rộng khắp</div>
                                </div>
                            </div>
                            <p class="mb-0">Mở rộng quan hệ nghề nghiệp và tham gia vào cộng đồng học thuật năng động.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="section popular-courses">
            <div class="container">
                <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">

                    <h2>Cánh cửa của tương lai</h2>
                    <p class="sub-title">MKD University là nơi kết nối tri thức, sáng tạo và thực tiễn. Chúng tôi cam kết mang đến môi trường học tập hiện đại, chương trình đào tạo chất lượng cao và cơ hội nghề nghiệp rộng mở cho sinh viên.</p>
                </div>

                <!-- carousel of popular mentors -->

                <div class="owl-carousel mentoring-course owl-theme owl-loaded owl-drag">
                    


                <div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(-1809px, 0px, 0px); transition: all; width: 7237px;"><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item active" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item active" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned active" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned active" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 271.505px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div></div></div><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-dots disabled"><button role="button" class="owl-dot active"><span></span></button></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-dots"><button role="button" class="owl-dot active"><span></span></button><button role="button" class="owl-dot"><span></span></button><button role="button" class="owl-dot"><span></span></button></div></div>
            </div>

            <!-- end of carousel of popular mentors -->
        </section>


        <section class="section path-section">
            <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">
                <div class="container">
                    <span>tham gia</span>
                    <h2>Ngay bây giờ</h2>
                    <p class="sub-title"></p>
                </div>
            </div>
            <div class="learning-path-col">
                <div class="container">

                    <div id="skillslist" class="row">

                        <!-- categories/subcategories/skills -->
                        
                        <!-- end of categories/subcategories/skills -->

                    </div>
                    <!--this button will load more skills-->
                    <div class="view-all text-center aos aos-init aos-animate" data-aos="fade-up">
                        <button onclick="loadMore()" class="btn btn-primary">yes sir</button>
                    </div>
                </div>
            </div>
        </section>


        <script>
<!--        ajax use to load more skills-->
            function loadMore() {
//            get the already-have skills in the current dom
                var amount = document.getElementsByClassName("countskills").length;
                $.ajax({
                    //call to loadskills controller
                    url: "/codecoach/loadskills",
                    type: 'get',
                    //push the data to the load skill controller
                    data: {
                        exist: amount
                    },
                    //if success binding to dom
                    success: function (data) {
                        var skillslist = document.getElementById("skillslist");
                        skillslist.innerHTML += data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>

        <!-- Pre footer -->
        <section class="section statistics-section">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>Top 12</span>
                            <h3>university rank</h3>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>99.69%</span>
                            <h3>Sinh viên có việc làm</h3>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>100%</span>
                            <h3>no scam</h3>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end of Pre footer -->

        <!--Content end-->

        <!--Footer start-->
        



    <footer class="footer">
        <div class="footer-top aos aos-init aos-animate" data-aos="fade-up">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-6">

                        <div class="footer-widget footer-about">
                            <div class="footer-logo" style="
    height: 186px;
    width: 300px;
">
                                <img src="assets/img/logo1.png" alt="Not Found" onerror="this.src=&quot;../assets/img/logo1.png&quot;" style="
    /* size: a3; */
    /* height: 235px; */
    width: 100%;
">
                            </div>
                            <div class="footer-about-content" style="
    margin-top: -106px;
    margin-left: 20px;
">
                                <p style="/* margin-left: 20px; */">If you see me calling
Thì xin em không nhấc máy
Mà nếu như em lỡ nghe rồi thì cho anh xin nốt lần này
I'm talking 'bout
When you see me calling
Thì xin em không nhấc máy
'Cause when that Henny hit me
Thì cool boy cũng trở thành lầy</p>
                                <div class="social-icon">
                                    <ul>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-facebook-f"></i> </a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-twitter"></i> </a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-instagram"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-dribbble"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-2 col-md-6"></div>
                    <div class="col-lg-2 col-md-6"></div>


                    <div class="col-lg-4 col-md-6" style="
    margin-top: 36px;
">

                        <div class="footer-widget footer-contact">
                            <h2 class="footer-title">Contact Us</h2>
                            <div class="footer-contact-info">
                                <div class="footer-address">
                                    <span><i class="fas fa-map-marker-alt"></i></span>
                                    <p>Đại học MKD Thạch Thất, Việt Nam</p>
                                </div>
                                <p>
                                    <i class="fas fa-phone-alt"></i>
                                    0989889999
                                </p>
                                <p>
                                    <i class="fas fa-envelope"></i>
                                    contact@mkd.edu.vn
                                </p>
                                <p>
                                    <i class="fas fa fa-globe"></i>
                                    www.mkd.edu.vn
                                </p>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container-fluid">

                <div class="copyright">
                    <div class="row">
                        <div class="col-12 text-center">
                            <div class="copyright-text">
                                <p class="mb-0">© Bản quyền thuộc về MKD group</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </footer>


        

    </div>


    <script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <script src="assets/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/owl.carousel.min.js"></script>

    <script src="assets/plugins/aos/aos.js"></script>

    <script src="assets/js/script.js"></script>








<body data-aos-easing="ease" data-aos-duration="1200" data-aos-delay="0" data-new-gr-c-s-check-loaded="14.1226.0" data-gr-ext-installed="">


    <div class="main-wrapper">

        <!-- Header is placed here -->
        



    
    <div class="main-wrapper">
        <header class="header">
            <div class="header-fixed">
                <nav class="navbar navbar-expand-lg header-nav">
                    <div class="navbar-header">
                        <a id="mobile_btn" href="javascript:void(0);">
                            <span class="bar-icon">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </a>
                        <a href="/ums/home" class="navbar-brand logo">
                            <img src="assets/img/logo1.png" class="img-fluid" alt="Not Found" onerror="this.src=&quot;../assets/img/logo1.png&quot;">
                        </a>
                    </div>
                    <div class="main-menu-wrapper">
                        <div class="menu-header">
                            <a href="/ums/home" class="menu-logo">
                                <img src="assets/img/logo.png" class="img-fluid" alt="Logo">
                            </a>
                            <a id="menu_close" class="menu-close" href="javascript:void(0);">
                                <i class="fas fa-times"></i>
                            </a>
                        </div>
                        <ul class="main-nav">
                            <li class="has-submenu">
                                <a href="/ums/home">Home <i class="fas"></i></a>
                            </li>

                            <!--                            <li class="has-submenu">
                                                            <a href='search?searchTxt='>Search mentor <i class="fas"></i></a>
                            
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="listchat">Chat <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="contactus">Contact Us <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="faq">FAQ <i class="fas "></i></a>
                                                        </li>-->

                            <!--Admin, student, instructor dashboard button-->
                            
                            
                            
                            <!--end of  button-->

                            <li class="login-link">
                                <a href="login">Login / Signup</a>
                            </li>
                        </ul>
                    </div>

                    <!-- login header -->
                    
                    <!-- end of login header -->


                    <!-- default header -->
                    
                        <ul class="nav header-navbar-rht">

                            <li class="nav-item">
                                <a class="nav-link header-login" href="/ums/login">Login</a>
                            </li>
                            <!--                            <li class="nav-item">
                                                            <a class="nav-link header-login" href="logout">Logout</a>
                                                        </li>-->
                        </ul>
                    
                    <!-- end of default header -->
                </nav>
            <div class="sidebar-overlay"></div><div class="sidebar-overlay"></div><div class="sidebar-overlay"></div><div class="sidebar-overlay"></div><div class="sidebar-overlay"></div></div>
        </header>
    </div>


        

        
        <section class="section section-search">
            <div class="container">
                <div class="banner-wrapper m-auto text-center aos aos-init aos-animate" data-aos="fade-up">
                    <div class="banner-header">
                        <h1><span>The Best</span> University Viet Nam</h1>
                        <p>Empowering Future Leaders with Excellence in Education</p>
                    </div>

                    <div class="search-box">
                        <form action="search" method="post">
                            <div class="form-group search-info">
                                <input name="searchTxt" type="text" class="form-control" placeholder="Search now">
                            </div>
                            <button type="submit" class="btn btn-primary search-btn"><i><img src="assets/img/search-submit.png" alt=""></i> <span>Search</span></button>
                        </form>
                    </div>

                </div>
            </div>
        </section>

        <section class="section how-it-works">
            <div class="container">
                <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">
                    
                    <span></span><h2>Learn with Experts – Shape Your Future</h2>
                    <p class="sub-title" style="
    font-weight: 400;
">We take pride in bringing together a team of lecturers and advisors who are leading experts in their respective fields.</p>
                </div>
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-1.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Easy Registration</div>
                                </div>
                            </div>
                            <p class="mb-0" style="
    /* height: 41px; */
">With just a few simple steps, you can become an MKD student today</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-2.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Experienced Mentors</div>
                                </div>
                            </div>
                            <p class="mb-0">Our mentors come from leading businesses and prestigious universities</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="feature-box text-center aos aos-init aos-animate" data-aos="fade-up">
                            <div class="feature-header">
                                <div class="feature-icon">
                                    <span class="circle"></span>
                                    <i><img src="assets/img/icon-3.png" alt=""></i>
                                </div>
                                <div class="feature-cont">
                                    <div class="feature-text">Extensive Networking</div>
                                </div>
                            </div>
                            <p class="mb-0">Expand your career prospects and join a dynamic academic community</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="section popular-courses">
            <div class="container">
                <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">

                    <h2>Innovate, Learn, Succeed</h2>
                    <p class="sub-title">MKD University is a hub of knowledge, creativity, and practical experience. We are committed to providing a modern learning environment, high-quality academic programs, and broad career opportunities for students.</p>
                </div>

                <!-- carousel of popular mentors -->

                <div class="owl-carousel mentoring-course owl-theme owl-loaded owl-drag">
                    


                <div class="owl-stage-outer"><div class="owl-stage" style="transform: translate3d(-2254px, 0px, 0px); transition: all; width: 9017px;"><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item active" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item active" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned active" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-dots disabled"></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div><div class="owl-item cloned" style="width: 292.008px; margin-right: 30px;"><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div></div></div></div><div class="owl-nav disabled"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-dots disabled"><button role="button" class="owl-dot active"><span></span></button></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-nav"><button type="button" role="presentation" class="owl-prev"><span aria-label="Previous">‹</span></button><button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span></button></div><div class="owl-dots"><button role="button" class="owl-dot active"><span></span></button><button role="button" class="owl-dot"><span></span></button><button role="button" class="owl-dot"><span></span></button><button role="button" class="owl-dot"><span></span></button><button role="button" class="owl-dot"><span></span></button></div></div>
            </div>

            <!-- end of carousel of popular mentors -->
        </section>


        <section class="section path-section">
            <div class="section-header text-center aos aos-init aos-animate" data-aos="fade-up">
                <div class="container">
                    <span>Join</span>
                    <h2>NOW</h2>
                    <p class="sub-title"></p>
                </div>
            </div>
            <div class="learning-path-col">
                <div class="container">

                    <div id="skillslist" class="row">

                        <!-- categories/subcategories/skills -->
                        
                        <!-- end of categories/subcategories/skills -->

                    </div>
                    <!--this button will load more skills-->
                    <div class="view-all text-center aos aos-init aos-animate" data-aos="fade-up">
                        <button onclick="loadMore()" class="btn btn-primary">yes sir</button>
                    </div>
                </div>
            </div>
        </section>


        <script>
<!--        ajax use to load more skills-->
            function loadMore() {
//            get the already-have skills in the current dom
                var amount = document.getElementsByClassName("countskills").length;
                $.ajax({
                    //call to loadskills controller
                    url: "/codecoach/loadskills",
                    type: 'get',
                    //push the data to the load skill controller
                    data: {
                        exist: amount
                    },
                    //if success binding to dom
                    success: function (data) {
                        var skillslist = document.getElementById("skillslist");
                        skillslist.innerHTML += data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>

        <!-- Pre footer -->
        <section class="section statistics-section">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>Top 5</span>
                            <h3>university rank</h3>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>99.69%</span>
                            <h3>job guaranteed</h3>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">
                        <div class="statistics-list text-center aos aos-init aos-animate" data-aos="fade-up">
                            <span>100%</span>
                            <h3>no scam</h3>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end of Pre footer -->

        <!--Content end-->

        <!--Footer start-->
        



    <footer class="footer">
        <div class="footer-top aos aos-init aos-animate" data-aos="fade-up">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-6">

                        <div class="footer-widget footer-about">
                            <div class="footer-logo" style="
    height: auto;
    width: 300px;
">
                                <img src="assets/img/logo1.png" alt="Not Found" onerror="this.src=&quot;../assets/img/logo1.png&quot;" style="
    /* size: a3; */
    /* height: 235px; */
    width: 55%;
    height: auto;
">
                            </div>
                            <div class="footer-about-content" style="
    /* margin-top: -106px; */
    /* margin-left: 20px; */
">
                                <p style="/* margin-left: 20px; */">If you see me calling
Thì xin em không nhấc máy
Mà nếu như em lỡ nghe rồi thì cho anh xin nốt lần này
I'm talking 'bout
When you see me calling
Thì xin em không nhấc máy
'Cause when that Henny hit me
Thì cool boy cũng trở thành lầy</p>
                                <div class="social-icon">
                                    <ul>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-facebook-f"></i> </a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-twitter"></i> </a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-instagram"></i></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><i class="fab fa-dribbble"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-2 col-md-6"></div>
                    <div class="col-lg-2 col-md-6"></div>


                    <div class="col-lg-4 col-md-6" style="
    /* margin-top: 36px; */
">

                        <div class="footer-widget footer-contact">
                            <h2 class="footer-title">Contact Us</h2>
                            <div class="footer-contact-info">
                                <div class="footer-address">
                                    <span><i class="fas fa-map-marker-alt"></i></span>
                                    <p>MKD University Thach That, Viet Nam</p>
                                </div>
                                <p>
                                    <i class="fas fa-phone-alt"></i>
                                    0989889999
                                </p>
                                <p>
                                    <i class="fas fa-envelope"></i>
                                    contact@mkd.edu.vn
                                </p>
                                <p>
                                    <i class="fas fa fa-globe"></i>
                                    www.mkd.edu.vn
                                </p>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container-fluid">

                <div class="copyright">
                    <div class="row">
                        <div class="col-12 text-center">
                            <div class="copyright-text">
                                <p class="mb-0">© All rights reserved by MKD Group</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </footer>


        

    </div>


    <script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <script src="assets/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/owl.carousel.min.js"></script>

    <script src="assets/plugins/aos/aos.js"></script>

    <script src="assets/js/script.js"></script>










</body>
</html>
