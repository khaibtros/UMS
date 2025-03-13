<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Attendances</title>

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
            <c:if test="${users.roleId == 2}">
                <div class="breadcrumb-bar">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-12">
                                <h2 class="breadcrumb-title">Attendance</h2>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="content">
                    <div class="container-fluid">
                        <div class="row">

                            <!--Admin sidebar start-->
                            <%@include file="studentsidebar.jsp" %>
                            <!--Admin sidebar end-->

                            <div class="col-md-7 col-lg-8 col-xl-9">

                                <div class="row">
                                    <div class="col-md-12">
                                        <h4 class="mb-4">Attendances</h4>
                                    </div>
                                    <!-- addForm end here -->

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
                                                        <tr>
                                                            <td style="width: 100px; white-space: pre-wrap;">${attendance.attendanceID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${attendance.studentID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${attendance.lessonID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${attendance.status}</td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <!--table end-->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <!--Admin user end-->

        <!--not admin start-->
        <c:if test="${!empty users && users.roleId != 2}">
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
    <script type="text/javascript">
        // prompt if you want to delete
        function doDelete(id) {
            if (confirm("Are you sure to delete this?:")) {
                window.location = "deleteannouncement?id=" + id;
            }
        }
        //show add faq form
        function showAddForm() {
            document.getElementById('addFormContainer').style.display = 'block';
        }
        //hide add faq form
        function hideAddForm() {
            document.getElementById('addFormContainer').style.display = 'none';
        }
        //show and hide edit faq form
        function toggleEditForm(button) {
            var editRow = button.parentNode.parentNode.nextElementSibling;
            var display = editRow.style.display;
            if (display === 'none' || display === '') {
                // Show the edit form
                editRow.style.display = 'table-row';
                button.innerText = 'Cancel';
            } else {
                // Hide the edit form
                editRow.style.display = 'none';
                button.innerText = 'Edit';
            }
        }
    </script>

</body>
</html>



