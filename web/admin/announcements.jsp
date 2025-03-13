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
            <c:if test="${users.roleId == 1}">
                <div class="breadcrumb-bar">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-12">
                                <h2 class="breadcrumb-title">Edit Announcement</h2>
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

                                <div class="row">
                                    <div class="col-md-12">
                                        <h4 class="mb-4">Announcements</h4>

                                        <!--add faq start-->
                                        <button onclick="showAddForm()" type="button" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-success">Add Announcement</button>
                                        <!-- addForm start here -->
                                        <div id="addFormContainer" style="display: none;">
                                            <div class="card card-form">
                                                <div class="card-body">
                                                    <h4 class="card-title">Add Announcement</h4>
                                                    <form action="addannouncement" method="POST">
                                                        <!-- Form fields -->
                                                        <div class="form-group">
                                                            <label>AnnouncementID:</label>
                                                            <input type="number" class="form-control" name="announcementId" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>AdminID:</label>
                                                            <select class="form-control" name="adminId" >
                                                                <option value="1" >1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                            </select>
                                                        </div>
                                                        <!-- Title -->
                                                        <div class="form-group">
                                                            <label>Title:</label>
                                                            <input type="text" class="form-control" name="title" required>
                                                        </div>
                                                        <!-- Content -->
                                                        <div class="form-group">
                                                            <label>Content:</label>
                                                            <textarea class="form-control" name="content" rows="5" required></textarea>
                                                        </div>
                                                        <!-- DatePosted -->
                                                        <div class="form-group">
                                                            <label>Date Posted:</label>
                                                            <input type="date" class="form-control" name="datePosted">
                                                        </div>

                                                        <input type="hidden" name="action" value="add">
                                                        <button type="submit" class="btn btn-primary">Save</button>
                                                        <button type="button" class="btn btn-secondary" onclick="hideAddForm()">Cancel</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- addForm end here -->

                                    <!--table start-->
                                    <div class="card card-table">
                                        <div class="card-body">
                                            <div class="table-responsive">

                                                <table style="border-collapse: collapse; width: 100%;" class="table table-hover table-center">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 10px;">Title</th>
                                                            <th style="width: 250px;">Full Content</th>
                                                            <th style="width: 20px;">Date Posted</th>
                                                            <th style="width: 100px;">ACTION</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listAnnouncement}" var="announcement">
                                                            <tr>
                                                                <td style="width: 10px; white-space: pre-wrap;">${announcement.title}</td>
                                                                <td style="width: 250px; white-space: pre-wrap;">${announcement.content}</td>
                                                                <td style="width: 20px; white-space: pre-wrap;">${announcement.datePosted}</td>
                                                                <td style="width: 100px;">
                                                                    <button class="btn btn-primary" onclick="toggleEditForm(this)">Edit</button>
                                                                    <button onclick="doDelete(${announcement.announcementID})" class="btn btn-danger">Delete</button>
                                                                </td>
                                                            </tr>
                                                            <%-- Hidden row for the edit form start--%>
                                                            <tr class="edit-row" style="display: none;">
                                                                <td colspan="4">
                                                                    <form action="editannouncement" method="POST">
                                                                        <input type="hidden" name="announcementId" value="${announcement.announcementID}">

                                                                        <!-- AdminID -->
                                                                        <div class="form-group">
                                                                            <label>AdminID:</label>
                                                                            <select class="form-control" name="adminId">
                                                                                <option value="1" ${announcement.adminID == 1 ? "selected" : ""}>1</option>
                                                                                <option value="2" ${announcement.adminID == 2 ? "selected" : ""}>2</option>
                                                                                <option value="3" ${announcement.adminID == 3 ? "selected" : ""}>3</option>
                                                                            </select>
                                                                        </div>

                                                                        <!-- Title -->
                                                                        <div class="form-group">
                                                                            <label>Title:</label>
                                                                            <input type="text" class="form-control" name="title" value="${announcement.title}" required>
                                                                        </div>

                                                                        <!-- Content -->
                                                                        <div class="form-group">
                                                                            <label>Content:</label>
                                                                            <textarea class="form-control" name="content" rows="5" required>${announcement.content}</textarea>
                                                                        </div>

                                                                        <!-- DatePosted -->
                                                                        <div class="form-group">
                                                                            <label>Date Posted:</label>
                                                                            <input type="date" class="form-control" name="datePosted" 
                                                                                   value="${announcement.datePosted}">
                                                                        </div>

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
        <c:if test="${!empty users && users.roleId != 1}">
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



