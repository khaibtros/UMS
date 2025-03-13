<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Lessons</title>

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
            <c:if test="${users.roleId == 3}">
                <div class="breadcrumb-bar">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-12">
                                <h2 class="breadcrumb-title">List of Lessons</h2>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="content">
                    <div class="container-fluid">
                        <div class="row">

                            <!--Admin sidebar start-->
                            <%@include file="instructorsidebar.jsp" %>
                            <!--Admin sidebar end-->

                            <div class="col-md-7 col-lg-8 col-xl-9">

                                <div class="row">
                                    <div class="col-md-12">
                                        <h4 class="mb-4">Lessons</h4>
                                    </div>

                                    <!--table start-->
                                    <div class="card card-table">
                                        <div class="card-body">
                                            <div class="table-responsive">

                                                <table style="border-collapse: collapse; width: 100%;" class="table table-hover table-center">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 10px;">LessonID</th>
                                                            <th style="width: 10px;">CourseID</th>
                                                            <th style="width: 10px;">ClassID</th>
                                                            <th style="width: 10px;">RoomID</th>
                                                            <th style="width: 10px;">Date</th>
                                                            <th style="width: 10px;">DayOfWeek</th>
                                                            <th style="width: 10px;">StartTime</th>
                                                            <th style="width: 10px;">EndTime</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listLesson}" var="lesson">
                                                            <tr>
                                                                <td style="width: 10px; white-space: pre-wrap;"><a href="attendances?lessonId=${lesson.lessonID}">${lesson.lessonID}</a></td>
                                                                <td style="width: 10px;white-space: pre-wrap;">${lesson.courseID}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.classID}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.roomID}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.date}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.dayOfWeek}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.startTime}</td>
                                                                <td style="width: 10px; white-space: pre-wrap;">${lesson.endTime}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <!--Admin user end-->

        <!--not admin start-->
        <c:if test="${!empty users && users.roleId != 3}">
            <%@include file="../accessdenied.jsp" %>
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
