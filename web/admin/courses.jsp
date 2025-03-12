<%@page import="Models.Course"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>List Courses</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">

        <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="../assets/css/style.css">
    </head>

    <body>

        <div class="main-wrapper">

            <%@include file="../header.jsp" %>

            <div class="breadcrumb-bar">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-md-12 col-12">
                            <h2 class="breadcrumb-title">List of Courses</h2>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <%@include file="adminsidebar.jsp" %>

                        <div class="col-md-7 col-lg-8 col-xl-9">
                            <div class="col-md-12 col-lg-3 dash-board-list blue">
                                <div class="dash-widget">
                                    <div class="circle-bar">
                                        <div class="icon-col">
                                            <i class="fas fa-book"></i>
                                        </div>
                                    </div>
                                    <div class="dash-widget-info">
                                        <%int totalCourses = (int) request.getAttribute("totalCourses");%>
                                        <h3><%= totalCourses%></h3>
                                        <h6>Courses</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="datatable table table-hover table-center align-middle mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Course ID</th>
                                                    <th>Course Name</th>
                                                    <th>Code</th>
                                                    <th>Description</th>
                                                    <th>Major ID</th>
                                                    <th>Semester ID</th>
                                                    <th>Fee Amount</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="course" items="${listCourse}">
                                                    <tr>
                                                        <td>${course.courseID}</td>
                                                        <td>${course.name}</td>
                                                        <td>${course.code}</td>
                                                        <td>${course.description}</td>
                                                        <td>${course.majorID}</td>
                                                        <td>${course.semesterID}</td>
                                                        <td>${course.feeAmount}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="pagination justify-content-center">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%@include file="../footer.jsp" %>
            </div>

            <script src="../assets/js/jquery-3.6.0.min.js"></script>
            <script src="../assets/js/bootstrap.bundle.min.js"></script>
            <script src="../assets/js/feather.min.js"></script>
            <script src="../assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
            <script src="../assets/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="../assets/plugins/datatables/datatables.min.js"></script>
            <script src="../assets/js/script.js"></script>

    </body>
</html>
