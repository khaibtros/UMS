<%-- 
    Document   : listmajor
    Created on : Mar 11, 2025
    Author     : ManhTD
--%>

<%@page import="Models.Major"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>List Majors</title>
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

            <!--Admin user start-->
            <c:if test="${users.roleId == 1}">
                <div class="breadcrumb-bar">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-12">
                                <h2 class="breadcrumb-title">List of Majors</h2>
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
                                                <i class="fas fa-book-open"></i>
                                            </div>
                                        </div>
                                        <div class="dash-widget-info">
                                            <%int totalMajors = (int) request.getAttribute("totalMajors");%>
                                            <h3><%= totalMajors %></h3>
                                            <h6>Majors</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="datatable table table-hover table-center align-middle mb-0">
                                                <thead>
                                                    <tr>
                                                        <th>Major ID</th>
                                                        <th>Major Code</th>
                                                        <th>Name</th>
                                                        <th>Description</th>
                                                        <th>Total Semesters</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach var="majorItem" items="${listMajor}">
                                                        <tr>
                                                            <td>${majorItem.majorID}</td>
                                                            <td>${majorItem.majorCode}</td>
                                                            <td>${majorItem.name}</td>
                                                            <td>${majorItem.description}</td>
                                                            <td>${majorItem.totalSemester}</td>
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
                </c:if>
                <!--Admin user end-->

                <!--not admin start-->
                <c:if test="${users.roleId != 1 || empty users}">
                    <%@include file="../accessdenied.jsp" %>
                </c:if>

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
