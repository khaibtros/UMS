<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Grades</title>

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
                                <h2 class="breadcrumb-title">Student Grades</h2>
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
                                        <h4 class="mb-4">Student Grades</h4>

                                        <!--table start-->
                                        <div class="card card-table">
                                            <div class="card-body">
                                                <div class="table-responsive">

                                                    <table style="border-collapse: collapse; width: 100%;" class="table table-hover table-center">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 10px">Student ID</th>
                                                                <th style="width: 10px">Course Name</th>
                                                                <th style="width: 100px">Assignment</th>
                                                                <th style="width: 100px">Midterm</th>
                                                                <th style="width: 100px">Final</th>
                                                                <th style="width: 100px">Total</th>
                                                                <th style="width: 100px;">ACTION</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${grades}" var="grade">
                                                                <tr>
                                                                    <td style="width: 10px">${grade.studentID}</td>
                                                                    <td style="width: 10px">${grade.courseName}</td>
                                                                    <td  style="width: 100px">${grade.assignment}</td>
                                                                    <td  style="width: 100px">${grade.midterm}</td>
                                                                    <td  style="width: 100px">${grade.finalExam}</td>
                                                                    <td  style="width: 100px">${grade.total}</td>
                                                                    <td style="width: 100px;">
                                                                        <button class="btn btn-primary" onclick="toggleEditForm(this)">Edit</button>
                                                                    </td>
                                                                </tr>
                                                                <%-- Hidden row for the edit form start--%>
                                                                <tr class="edit-row" style="display: none;">
                                                                    <td colspan="4">
                                                                        <form action="editgrade" method="POST">
                                                                            <input type="hidden" name="gradeId" value="${grade.gradeID}"> 

                                                                            <div class="form-group">
                                                                                <label>Assignment</label>
                                                                                <input type="number" class="form-control" name="assignment" id="assignment" value="${grade.assignment}" step="any" required oninput="calculateTotal()">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Midterm</label>
                                                                                <input type="number" class="form-control" name="midterm" id="midterm" value="${grade.midterm}" step="any" required oninput="calculateTotal()">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <label>Final</label>
                                                                                <input type="number" class="form-control" name="finalExam" id="finalExam" value="${grade.finalExam}" step="any" required oninput="calculateTotal()">
                                                                            </div>

                                                                            <div class="form-group">
                                                                                <input type="hidden" class="form-control" name="total" id="total" value="${grade.total}" step="any">
                                                                            </div

                                                                            <input type="hidden" name="action" value="edit">
                                                                            <button type="submit" class="btn btn-primary">Save Changes</button>
                                                                        </form>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
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

                                                                            function calculateTotal() {
                                                                                let assignment = parseFloat(document.getElementById("assignment").value) || 0;
                                                                                let midterm = parseFloat(document.getElementById("midterm").value) || 0;
                                                                                let finalExam = parseFloat(document.getElementById("finalExam").value) || 0;

                                                                                if (assignment !== "" && midterm !== "" && finalExam !== "") {
                                                                                    let total = (parseFloat(assignment) * 0.3) + (parseFloat(midterm) * 0.3) + (parseFloat(finalExam) * 0.4);
                                                                                    document.getElementById("total").value = total.toFixed(2);
                                                                                } else {
                                                                                    // If any field is empty, clear the total field
                                                                                    document.getElementById("total").value = "";
                                                                                }
                                                                            }
        </script>

    </body>
</html>



