<%-- 
    Document   : listsemester
    Created on : Mar 11, 2025, 10:19:42 AM
    Author     : ManhTD
--%>

<%@page import="Models.Semester"%>
<%@page import="java.util.List"%>
<%@page import="DAO.SemesterDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>List Semesters</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">

        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <body>

        <div class="main-wrapper">

            <%@include file="header.jsp" %>

            <div class="breadcrumb-bar">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-md-12 col-12">
                            <h2 class="breadcrumb-title">List of Semesters</h2>
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
                                            <i class="fas fa-calendar-alt"></i>
                                        </div>
                                    </div>
                                    <div class="dash-widget-info">
                                        <%int totalSemesters = (int) request.getAttribute("totalSemesters");%>
                                        <h3><%= totalSemesters%></h3>
                                        <h6>Semesters</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="datatable table table-hover table-center align-middle mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Semester ID</th>
                                                    <th>Semester Name</th>
                                                    <th>Start Date</th>
                                                    <th>End Date</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="semester" items="${listSemester}">
                                                    <tr>
                                                        <td>${semester.semesterID}</td>
                                                        <td>${semester.name}</td>
                                                        <td>${semester.startDate}</td>
                                                        <td>${semester.endDate}</td>
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

                <%@include file="footer.jsp" %>
            </div>

            <script src="assets/js/jquery-3.6.0.min.js"></script>
            <script src="assets/js/bootstrap.bundle.min.js"></script>
            <script src="assets/js/feather.min.js"></script>
            <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
            <script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="assets/plugins/datatables/datatables.min.js"></script>
            <script src="assets/js/script.js"></script>

    </body>
</html>

