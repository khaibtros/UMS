<%-- 
    Document   : listrooms
    Created on : Mar 9, 2025, 2:30:15 PM
    Author     : ManhTD
--%>

<%@page import="Models.Room"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RoomDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>List Rooms</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">

        <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="../assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="../assets/css/style.css">
    </head>

    <body>

        <div class="main-wrapper">

            <!--Admin user start-->

            <%@include file="../header.jsp" %>

            <c:if test="${users.roleId == 1}">
                <div class="breadcrumb-bar">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-12">
                                <h2 class="breadcrumb-title">List of Rooms</h2>
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
                                                <i class="fas fa-door-open"></i>
                                            </div>
                                        </div>
                                        <div class="dash-widget-info">
                                            <%int totalRooms = (int) request.getAttribute("totalRooms");%>
                                            <h3><%= totalRooms%></h3>
                                            <h6>Rooms</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="datatable table table-hover table-center align-middle mb-0">
                                                <thead>
                                                    <tr>
                                                        <th>Room ID</th>
                                                        <th>Room Name</th>
                                                        <th>Type</th>
                                                        <th>Capacity</th>
                                                        <th>Status</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach var="roomItem" items="${listRoom}">
                                                    <tr>
                                                        <td>${roomItem.roomID}</td>
                                                        <td>${roomItem.name}</td>
                                                        <td>${roomItem.type}</td>
                                                        <td>${roomItem.capacity}</td>
                                                        <td>${roomItem.status}</td>
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
