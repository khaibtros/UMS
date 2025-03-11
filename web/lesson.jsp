<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Lessons</title>

        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">

        <link rel="stylesheet" href="assets/plugins/aos/aos.css">

        <link rel="stylesheet" href="assets/css/style.css">
        <script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    </head>
    <body>
        <div class="main-wrapper">

            <!-- Header is placed here -->
            <%@include file="header.jsp" %>
            <!--End of header-->

            <!--Admin user start-->
            <%--<c:if test="${users.roleId == 1}">--%>
            <div class="breadcrumb-bar">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="col-md-12 col-12">
                            <h2 class="breadcrumb-title">Edit Lessons</h2>
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
                                    <h4 class="mb-4">Lessons</h4>

                                    <!--add faq start-->
                                    <button onclick="showAddForm()" type="button" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-success">Add Lesson</button>
                                    <!-- addForm start here -->
                                    <div id="addFormContainer" style="display: none;">
                                        <div class="card card-form">
                                            <div class="card-body">
                                                <h4 class="card-title">Add Lesson</h4>
                                                <form action="addlesson" method="POST">
                                                    <!-- Form fields -->
                                                    <div class="form-group">
                                                        <label>LessonID:</label>
                                                        <input type="number" class="form-control" name="lessonId" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>CourseID:</label>
                                                        <select class="form-control" name="courseId" >
                                                            <option value="1" >1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="19">19</option>
                                                            <option value="20">20</option>
                                                            <option value="21">21</option>
                                                            <option value="37">37</option>
                                                            <option value="38">38</option>
                                                            <option value="39">39</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>ClassID:</label>
                                                        <select class="form-control" name="classId" >
                                                            <option value="1" >1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>InstructorID:</label>
                                                        <select class="form-control" name="instructorId">
                                                            <option value="1" >1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="4">4</option>
                                                            <option value="5">5</option>
                                                            <option value="6">6</option>
                                                            <option value="7">7</option>
                                                            <option value="8">8</option>
                                                            <option value="9">9</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>RoomID:</label>
                                                        <select class="form-control" name="roomId">
                                                            <option value="1" >1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="4">4</option>
                                                            <option value="5">5</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="date">Select Date:</label>
                                                        <input type="date" class="form-control" name="date" required>
                                                        <!-- Day of the Week Selection -->
                                                        <div class="form-group">
                                                            <label for="dayOfWeek">Day of the Week:</label>
                                                            <select class="form-control" name="dayOfWeek" required>
                                                                <option value="Monday">Monday</option>
                                                                <option value="Tuesday">Tuesday</option>
                                                                <option value="Wednesday">Wednesday</option>
                                                                <option value="Thursday">Thursday</option>
                                                                <option value="Friday">Friday</option>
                                                            </select>
                                                        </div>

                                                        <!-- Start Time Selection -->
                                                        <div class="form-group">
                                                            <label for="startTime">Start Time:</label>
                                                            <input type="time" class="form-control" name="startTime" required>
                                                        </div>

                                                        <!-- End Time Selection -->
                                                        <div class="form-group">
                                                            <label for="endTime">End Time:</label>
                                                            <input type="time" class="form-control" name="endTime" required>
                                                        </div>

                                                        <!-- Content Text Area -->
                                                        <div class="form-group">
                                                            <label for="content">Lesson Content:</label>
                                                            <textarea class="form-control" name="content" rows="4" placeholder="Enter lesson content"></textarea>
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
                                                        <th style="width: 100px;">LessonID</th>
                                                        <th style="width: 100px;">CourseID</th>
                                                        <th style="width: 100px;">ClassID</th>
                                                        <th style="width: 100px;">InstructorID</th>
                                                        <th style="width: 100px;">RoomID</th>
                                                        <th style="width: 100px;">ACTION</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${listLesson}" var="lesson">
                                                        <tr>
                                                            <td style="width: 10px; white-space: pre-wrap;">${lesson.lessonID}</td>
                                                            <td style="width: 100px;white-space: pre-wrap;">${lesson.courseID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${lesson.classID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${lesson.instructorID}</td>
                                                            <td style="width: 100px; white-space: pre-wrap;">${lesson.roomID}</td>
                                                            <td style="width: 100px;">
                                                                <button class="btn btn-primary" onclick="toggleEditForm(this)">Edit</button>
                                                                <button onclick="doDelete(${lesson.lessonID})" class="btn btn-danger">Delete</button>
                                                            </td>
                                                        </tr>
                                                        <%-- Hidden row for the edit form start--%>
                                                        <tr class="edit-row" style="display: none;">
                                                            <td colspan="4">
                                                                <form action="editlesson" method="POST">
                                                                    <input type="hidden" name="lessonId" value="${lesson.lessonID}">
                                                                    <!-- CourseID -->
                                                                    <div class="form-group">
                                                                        <label>CourseID:</label>
                                                                        <select class="form-control" name="courseId">
                                                                            <option value="1" ${lesson.courseID == 1 ? "selected" : ""}>1</option>
                                                                            <option value="2" ${lesson.courseID == 2 ? "selected" : ""}>2</option>
                                                                            <option value="3" ${lesson.courseID == 3 ? "selected" : ""}>3</option>
                                                                            <option value="19" ${lesson.courseID == 19 ? "selected" : ""}>19</option>
                                                                            <option value="20" ${lesson.courseID == 20 ? "selected" : ""}>20</option>
                                                                            <option value="21" ${lesson.courseID == 21 ? "selected" : ""}>21</option>
                                                                            <option value="37" ${lesson.courseID == 37 ? "selected" : ""}>37</option>
                                                                            <option value="38" ${lesson.courseID == 38 ? "selected" : ""}>38</option>
                                                                            <option value="39" ${lesson.courseID == 39 ? "selected" : ""}>39</option>
                                                                        </select>
                                                                    </div>

                                                                    <!-- ClassID -->
                                                                    <div class="form-group">
                                                                        <label>ClassID:</label>
                                                                        <select class="form-control" name="classId">
                                                                            <option value="1" ${lesson.classID == 1 ? "selected" : ""}>1</option>
                                                                            <option value="2" ${lesson.classID == 2 ? "selected" : ""}>2</option>
                                                                            <option value="3" ${lesson.classID == 3 ? "selected" : ""}>3</option>
                                                                        </select>
                                                                    </div>

                                                                    <!-- InstructorID -->
                                                                    <div class="form-group">
                                                                        <label>InstructorID:</label>
                                                                        <select class="form-control" name="instructorId">
                                                                            <option value="1" ${lesson.instructorID == 1 ? "selected" : ""}>1</option>
                                                                            <option value="2" ${lesson.instructorID == 2 ? "selected" : ""}>2</option>
                                                                            <option value="3" ${lesson.instructorID == 3 ? "selected" : ""}>3</option>
                                                                            <option value="4" ${lesson.instructorID == 4 ? "selected" : ""}>4</option>
                                                                            <option value="5" ${lesson.instructorID == 5 ? "selected" : ""}>5</option>
                                                                            <option value="6" ${lesson.instructorID == 6 ? "selected" : ""}>6</option>
                                                                            <option value="7" ${lesson.instructorID == 7 ? "selected" : ""}>7</option>
                                                                            <option value="8" ${lesson.instructorID == 8 ? "selected" : ""}>8</option>
                                                                            <option value="9" ${lesson.instructorID == 9 ? "selected" : ""}>9</option>
                                                                        </select>
                                                                    </div>

                                                                    <!-- RoomID -->
                                                                    <div class="form-group">
                                                                        <label>RoomID:</label>
                                                                        <select class="form-control" name="roomId">
                                                                            <option value="1" ${lesson.roomID == 1 ? "selected" : ""}>1</option>
                                                                            <option value="2" ${lesson.roomID == 2 ? "selected" : ""}>2</option>
                                                                            <option value="3" ${lesson.roomID == 3 ? "selected" : ""}>3</option>
                                                                            <option value="4" ${lesson.roomID == 4 ? "selected" : ""}>4</option>
                                                                            <option value="5" ${lesson.roomID == 5 ? "selected" : ""}>5</option>
                                                                        </select>
                                                                    </div>

                                                                    <!-- Date -->
                                                                    <div class="form-group">
                                                                        <label for="date">Select Date:</label>
                                                                        <input type="date" class="form-control" name="date" value="${lesson.date}" required>
                                                                    </div>

                                                                    <!-- Day of the Week -->
                                                                    <div class="form-group">
                                                                        <label for="dayOfWeek">Day of the Week:</label>
                                                                        <select class="form-control" name="dayOfWeek" required>
                                                                            <option value="Monday" ${lesson.dayOfWeek == 'Monday' ? "selected" : ""}>Monday</option>
                                                                            <option value="Tuesday" ${lesson.dayOfWeek == 'Tuesday' ? "selected" : ""}>Tuesday</option>
                                                                            <option value="Wednesday" ${lesson.dayOfWeek == 'Wednesday' ? "selected" : ""}>Wednesday</option>
                                                                            <option value="Thursday" ${lesson.dayOfWeek == 'Thursday' ? "selected" : ""}>Thursday</option>
                                                                            <option value="Friday" ${lesson.dayOfWeek == 'Friday' ? "selected" : ""}>Friday</option>
                                                                        </select>
                                                                    </div>

                                                                    <!-- Start Time -->
                                                                    <div class="form-group">
                                                                        <label for="startTime">Start Time:</label>
                                                                        <input type="time" class="form-control" name="startTime" value="${lesson.startTime}" required>
                                                                    </div>

                                                                    <!-- End Time -->
                                                                    <div class="form-group">
                                                                        <label for="endTime">End Time:</label>
                                                                        <input type="time" class="form-control" name="endTime" value="${lesson.endTime}" required>
                                                                    </div>

                                                                    <!-- Content -->
                                                                    <div class="form-group">
                                                                        <label for="content">Lesson Content:</label>
                                                                        <textarea class="form-control" name="content" rows="4">${lesson.content}</textarea>
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
        <%--</c:if>--%>
        <!--Admin user end-->

        <!--not admin start-->
        <%--<c:if test="${!empty users && users.roleId != 1}">--%>
        <%--<%@include file="accessdenied.jsp" %>--%>
        <%--</c:if>--%>
        <!--not admin end-->

        <!-- end of Pre footer -->
        <%@include file="footer.jsp" %>
        <!-- footer is place here -->

    </div>


    <script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <script src="assets/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/owl.carousel.min.js"></script>

    <script src="assets/plugins/aos/aos.js"></script>

    <script src="assets/js/script.js"></script>
    <script type="text/javascript">
                                                                    // prompt if you want to delete
                                                                    function doDelete(id) {
                                                                        if (confirm("Are you sure to delete this?:")) {
                                                                            window.location = "deletelesson?id=" + id;
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



