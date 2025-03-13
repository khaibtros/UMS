<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <c:set var="users" value="${sessionScope.users}"/>
    <div class="main-wrapper">
        <header class="header">
            <div class="header-fixed">
                <nav class="navbar navbar-expand-lg header-nav">
                    <div class="navbar-header">
                        <a id="mobile_btn" href="javascript:void(0);">
                            <span class="bar-icon">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                        </a>
                        <a href="${pageContext.request.contextPath}/home.jsp" class="navbar-brand logo">
                            <img src="assets/img/logo.png" class="img-fluid" alt="Not Found" onerror=this.src="../assets/img/logo.png">
                        </a>
                    </div>
                    <div class="main-menu-wrapper">
                        <div class="menu-header">
                            <a href="${pageContext.request.contextPath}/home.jsp" class="menu-logo">
                                <img src="assets/img/logo.png" class="img-fluid" alt="Logo">
                            </a>
                            <a id="menu_close" class="menu-close" href="javascript:void(0);">
                                <i class="fas fa-times"></i>
                            </a>
                        </div>
                        <ul class="main-nav">
                            <li class="has-submenu">
                                <a href="${pageContext.request.contextPath}/home.jsp">Home <i class="fas"></i></a>
                            </li>

                            <!--                            <li class="has-submenu">
                                                            <a href='search?searchTxt='>Search mentor <i class="fas"></i></a>
                            
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="listchat">Chat <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="contactus">Contact Us <i class="fas "></i></a>
                                                        </li>
                                                        <li class="has-submenu">
                                                            <a href="faq">FAQ <i class="fas "></i></a>
                                                        </li>-->

                            <!--Admin, student, instructor dashboard button-->
                            <c:if test="${users.roleId == 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/admindashboard" target="">Admin Dashboard</a>
                                </li>
                            </c:if>
                            <c:if test="${users.roleId == 2}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/student/studentdashboard" target="">Student Dashboard</a>
                                </li>
                            </c:if>
                            <c:if test="${users.roleId == 3}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/instructor/instructordashboard" target="">Instructor Dashboard</a>
                                </li>
                            </c:if>
                            <!--end of  button-->

                            <li class="login-link">
                                <a href="login">Login / Signup</a>
                            </li>
                        </ul>
                    </div>

                    <!-- login header -->
                    <c:if test="${not empty users.userId}">
                        <ul class="nav header-navbar-rht">
                            <li class="nav-item dropdown nav has-arrow logged-item header-navbar-rht">
                                <a href="" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
                                    <span class="user-img">
                                        <img class="rounded-circle" src="assets/images/users/${users.userId}.png" width="31" onerror=this.src="../assets/images/users/${users.userId}.png">
                                    </span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <div class="user-header">
                                        <div class="avatar avatar-sm">
                                            <img src="assets/images/users/${users.userId}.png" alt="User Image"
                                                 class="avatar-img rounded-circle" onerror=this.src="../assets/images/users/${users.userId}.png">
                                        </div>
                                        <div class="user-text">

                                            <p class="text-muted mb-0"><c:if test="${users.roleId == 1}">Admin</c:if><c:if test="${users.roleId == 2}">Student</c:if><c:if test="${users.roleId == 3}">Instructor</c:if></p>
                                            </div>
                                        </div>

                                        <!--                                        <a class="dropdown-item" href="/ums/general-profile?go=edit-profile&user-id">Profile Settings</a>-->
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/changepassword.jsp">Change Password</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
                                    </div>
                                </li>

                            </ul>
                    </c:if>
                    <!-- end of login header -->


                    <!-- default header -->
                    <c:if test="${empty users.userId}">
                        <ul class="nav header-navbar-rht">

                            <li class="nav-item">
                                <a class="nav-link header-login" href="/ums/login">Login</a>
                            </li>
                            <!--                            <li class="nav-item">
                                                            <a class="nav-link header-login" href="logout">Logout</a>
                                                        </li>-->
                        </ul>
                    </c:if>
                    <!-- end of default header -->
                </nav>
            </div>
        </header>
    </div>
</html>
