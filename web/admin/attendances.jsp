<%-- 
    Document   : enrollment
    Created on : Jun 9, 2023, 4:08:36 PM
    Author     : Khai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Attendance</title>

        <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="../assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="../assets/css/owl.theme.default.min.css">

        <link rel="stylesheet" href="../assets/plugins/aos/aos.css">

        <link rel="stylesheet" href="../assets/css/style.css">
        <script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    </head>
    <body>
        <div class="main-wrapper">

            <!-- Header is placed here -->
            <%@include file="../header.jsp" %>
            <!--End of header-->

            <!--Admin user start-->
            <c:if test="${users.roleId == 1}">
            <div class="breadcrumb-bar">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-md-12 col-12">
                            <h2 class="breadcrumb-title">List Attendance</h2>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content">
                <div class="container-fluid">
                    <div class="row">

                        <!--Admin sidebar start-->
                        <%@include file="adminsidebar.jsp" %>
                        <!--Admin sidebar end-->

                        <div class="col-md-7 col-lg-8 col-xl-9">

                            <div class="search-box">
                                <form action="attendances" method="get"> 
                                    <div class="form-group search-info">
                                        <input name="lessonId" type="text" class="form-control"
                                               placeholder="Enter Lesson ID">
                                    </div>
                                    <button type="submit" class="btn btn-primary search-btn">
                                        <i><img src="../assets/img/search-submit.png" alt></i> 
                                        <span>Search</span>
                                    </button>
                                </form>
                            </div>

                            <c:if test="${not empty listAttendance}">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h4 class="mb-4">Attendance Lists</h4>

                                        <!--table start-->
                                        <div class="card card-table">
                                            <div class="card-body">
                                                <div class="table-responsive">

                                                    <table style="border-collapse: collapse; width: 100%;" class="table table-hover table-center">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 100px;">AttendanceID</th>
                                                                <th style="width: 100px;">StudentID</th>
                                                                <th style="width: 100px;">LessonID</th>
                                                                <th style="width: 100px;">Status</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <% int counter = 1;%>
                                                            <c:forEach items="${listAttendance}" var="attendance">
                                                                <tr>
                                                                    <td style="width: 10px; white-space: pre-wrap;">${attendance.attendanceID}</td>
                                                                    <td style="width: 100px; white-space: pre-wrap;">${attendance.studentID}</td>
                                                                    <td style="width: 100px; white-space: pre-wrap;">${attendance.lessonID}</td>
                                                                    <td style="width: 100px; white-space: pre-wrap;">${attendance.status}</td>
                                                                </tr>
                                                                <% counter++;%>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--table end-->
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>
            <!--Admin user end-->

            <!--not admin start-->
            <c:if test="${users.roleId != 1 || empty users}">
                <%@include file="accessdenied.jsp" %>
            </c:if>
            <!--not admin end-->

            <!-- end of Pre footer -->
            <%@include file="../footer.jsp" %>
            <!-- footer is place here -->

        </div>


        <script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="../assets/js/jquery-3.6.0.min.js"></script>

        <script src="../assets/js/bootstrap.bundle.min.js"></script>

        <script src="../assets/js/owl.carousel.min.js"></script>

        <script src="../assets/plugins/aos/aos.js"></script>

        <script src="../assets/js/script.js"></script>

    </body>
</html>
