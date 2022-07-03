<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%
	String role		="";
	String aemail	="";
	String aname	="";
	int adminid	=0;

	
	if(session.getAttribute("role")!=null && session.getAttribute("role")!=null)
	{
		role 	= (String)session.getAttribute("role");
		aemail 	= (String)session.getAttribute("aemail");
		aname 	= (String)session.getAttribute("aname");
		adminid = (Integer)session.getAttribute("adminid");

	}
	else
	{
		%>
		<script>
          alert('Invalid User!!');
          window.location='login.jsp';
        </script>
		<%
	}
	%>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>	SCASA 2 - Staffs</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-business-time"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SCASA <sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            
            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" >
                    <span>
                    <h9> Welcome ! </h9>  
                    <h3> <%out.println(aname);%></h3>
                    <h9> <%out.println(role);%></h9>                    
                    </span>
                </a>

            <!-- Nav Item - Dashboard -->
            <li class="nav-item ">
                <a class="nav-link" href="/SCASA/AttendanceController?action=today_staff">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">
            
               <!-- Heading -->
            <div class="sidebar-heading">
                Manage Profile
            </div>
            

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="/SCASA/ProfileController?action=profile&adminid=<%=adminid %>">
                    <i class="fas fa-fw fa-user"></i>
                    <span>Profile</span></a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider">
            
            <!-- Heading -->
            <div class="sidebar-heading">
                Manage Staff
            </div>

            <!-- Nav Item - Attendance Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Attendance</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Attendance Components:</h6>
                        <a class="collapse-item " class="fas fa-fw fa-table" href="/SCASA/AttendanceController?action=viewAttendanceList">Attendance List</a>
<!--                         <a class="collapse-item" href="cards.html">Staffs</a> -->
                    </div>
                </div>
            </li>
            
            <%if (role == "HOD"){ %>
		                     <!-- Nav Item - Admin Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
                    aria-expanded="true" aria-controls="collapseThree">
                    <i class="fas fa-fw fa-user-friends"></i>
                    <span>Admin</span>
                </a>
                <div id="collapseThree" class="collapse" aria-labelledby="headingsTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Admin Components:</h6>
                        <a class="collapse-item" href="/SCASA/AdminController?action=viewAdminList">Admin List</a>
                    </div>
                </div>
            </li>
		         
		         
		      <% } %>            

			<!-- Nav Item - Admin Collapse Menu 
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
                    aria-expanded="false" aria-controls="#collapseThree">
                    <i class="fas fa-fw fa-user-friends"></i>
                    <span>Admin</span>
                </a>
                <div id="#collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Admin Components:</h6>
                        <a class="collapse-item" href="/SCASA/AdminController?action=viewAdminList">Admin List</a>
                    </div>
                </div>
            </li> -->

            <!-- Nav Item - Staffs Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-users"></i>
                    <span>Staffs</span>
                </a>
                <div id="collapseUtilities" class="collapse show" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Staffs Components:</h6>
                        <a class="collapse-item active" href="/SCASA/StaffController?action=viewStaffList">Staff List</a>
<!--                         <a class="collapse-item" href="utilities-border.html">Overtime</a>
                        <a class="collapse-item" href="utilities-animation.html">Cash Advance</a>
                        <a class="collapse-item" href="utilities-other.html">Schedules</a> -->
                    </div>
                </div>
            </li>

            <!-- Divider 
            <hr class="sidebar-divider"> -->

            <!-- Heading 
            <div class="sidebar-heading">
                Addons
            </div> -->

            <!-- Nav Item - Pages Collapse Menu 
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Pages</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Login Screens:</h6>
                        <a class="collapse-item" href="login.html">Login</a>
                        <a class="collapse-item" href="register.html">Register</a>
                        <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Other Pages:</h6>
                        <a class="collapse-item" href="404.html">404 Page</a>
                        <a class="collapse-item" href="blank.html">Blank Page</a>
                    </div>
                </div>
            </li> -->

            <!-- Nav Item - Charts 
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li> -->

            <!-- Nav Item - Tables 
            <li class="nav-item ">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li> -->

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Hi, <% out.println(aname); %></span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/SCASA/ProfileController?action=profile&adminid=<%=adminid %>">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
<!--                                 <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a> -->
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Staff Tables</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="md-8 font-weight-bold text-primary">DataTables of Staff</h6>                            
                        </div>
                        <div class="card-header py-3">
                            <button type="button" data-toggle="modal" data-target="#AddEmployeesModal" 
                            class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" >
                            
                            <i class="fas fa-plus-square fa-sm text-white-50"></i> Add New Staff </button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Staff ID</th>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Department</th>
                                            <th>Gender</th>
                                            <th>Start date</th>
                                            <th>RFID Tag ID</th>
                                            <th>Status</th>
                                            <th>Details</th>
                                        </tr>
                                    </thead>                                    
                                    <tbody>
                                    <c:forEach items="${staffs}" var="staff">
                                        <tr>
                                        	<td><c:out value="${staff.staffid}" /></td>
                                            <td><c:out value="${staff.sname}" /></td>
                                            <td><c:out value="${staff.sposition}" /></td>
                                            <td><c:out value="${staff.sdepartment}" /></td>
                                            <td><c:out value="${staff.sgender}" /></td>
                                            <td><c:out value="${staff.sstartdate}" /></td>
                                            <td><c:out value="${staff.srfid}" /></td>
                                            <td><c:out value="${staff.sstatus}" /></td>
                                            <td>                                           
                                            	<div class="dropdown mb-4">
                                        			<button class="btn btn-primary btn-sm dropdown-toggle" type="button"
                                            		id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                            		aria-expanded="false">
                                            		Dropdown
                                        			</button>
                                        		<div class="dropdown-menu animated--fade-in"
                                            		aria-labelledby="dropdownMenuButton">
                                            		
                                            		<a class="dropdown-item UpdateEmployeesModal" role="button"
                                            		data-toggle="modal" data-target="#UpdateEmployeesModal" 
                                            		
                                            		data-sid		="${staff.staffid}"
                                            		data-sname		="${staff.sname }"
                                            		data-sgender	="${staff.sgender }"
                                            		data-snotel		="${staff.snotel }"
                                            		data-semail		="${staff.semail }"
                                            		data-sdepartment="${staff.sdepartment }"
                                            		data-sposition	="${staff.sposition }"
                                            		data-snric		="${staff.snric }"
                                            		data-srfid		="${staff.srfid }"
                                            		data-sstatus	="${staff.sstatus }"
                                            		data-sstartdate	="${staff.sstartdate }"
                                          		                                          		
                                            		 > 
                                            		 <i class="fas fa-edit fa-sm fa-fw mr-2 text-gray-400"></i>Edit</a>
                                            		
                                            		<a class="dropdown-item " href="/SCASA/StaffController?action=deleteStaff&id=${staff.staffid}"
                                            		onclick="return confirm('Are you sure you want to delete Staff ?')"
                                            		> 
                                            		
                                            		<!-- data-toggle="modal" data-target="#DeleteEmployeesModal" -->
                                            		
                                            		<i class="fas fa-trash fa-sm fa-fw mr-2 text-gray-400"></i>Delete</a>
                                        		
                                        		</div> 
                                    			</div>
                                            </td>
                                        </tr>                                                                             
                                    </c:forEach>
                                    </tbody> 
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; SCASA by OSO Solution Sdn. Bhd. Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/SCASA/LoginController?action=Logout">Logout</a>
                </div>
            </div>
        </div>
    </div>
    
    
	<!-- Add New Staff  Modal-->
	<div class="modal fade" id="AddEmployeesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="AddEmployeesModal"> Add New Staff </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="form1"  method="post" id="create" action="/SCASA/StaffController?action=createStaff">
                        <div class="pl-lg-10">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="staffid" >Staff ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="staffid" class="form-control" name="staffid" placeholder="Staff ID" value="" required>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sname">Name<span class="small text-danger">*</span></label>
                                        <input type="text" id="sname" class="form-control" name="sname" placeholder="Full Name" value="" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sgender" >Gender<span class="small text-danger">*</span></label>

										<select id="sgender" class="form-control" name="sgender">									      
                                        <option value="" disabled selected>Choose your Gender</option>
									    	<option value="Male">Male</option>
									    	<option value="Female">Female</option>

									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="snotel">No. Tel<span class="small text-danger">*</span></label>
                                        <input type="text" id="snotel" class="form-control" name="snotel" placeholder="No Tel" value="" required>
                                    </div>
                                </div>
                            </div>                       

                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label class="form-control-label" for="email">Email Address<span class="small text-danger">*</span></label>
                                        <input type="email" id="semail" class="form-control" name="semail" placeholder="example@example.com" value="">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sdepartment">Department<span class="small text-danger">*</span></label>
                                        
										<select id="sdepartment" class="form-control" name="sdepartment">									      
                                        <option value="" disabled selected>Choose your Department</option>
									    	<option value="IT">IT</option>
									    	<option value="Human Resources">Human Resources</option>
									    	<option value="Marketing">Marketing</option>
									    	<option value="Finance">Finance</option>
									    	<option value="Production">Production</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sposition"> Position<span class="small text-danger">*</span></label>
                                        <input type="text" id="sposition" class="form-control" name="sposition" placeholder="Position" value="">
                                    </div>
                                </div>
<!--                             </div>
                                                   
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="name">Roles<span class="small text-danger">*</span></label>
                                        <select id="name" class="form-control" name="name">									      
                                        <option value="" disabled selected>Choose your Roles</option>
									    	<option value="Admin">Admin</option>
									    	<option value="Staff">Manager</option>
									    	<option value="No Roles">No Roles</option>
									    </select>                                    
                                    </div>
                                </div> -->
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="snric">NRIC ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="snric" class="form-control" name="snric" placeholder="123456101234" value="">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="srfid">RFID Tag ID</label>
                                        <input type="text" id="srfid" class="form-control" name="srfid" placeholder="RFID Tag ID">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sstatus">Status</label>
                                        <select id="sstatus" class="form-control" name="sstatus">									      
                                        <option value="" disabled selected>Choose Staff Status</option>
									    	<option value="Full-Time">Full-Time</option>
									    	<option value="Part-Time">Part-Time</option>
									    	<option value="Contract">Contract</option>
									    	<option value="Pending">Pending</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="sstartdate">Start Date</label>
                        				<input type="date" class="form-control" id="sstartdate" name="sstartdate"/>
                       					<span class="input-group-addon glyphicon glyphicon-calendar" class="input-group-text" id="basic-addon2">
                      				  </span>										
                                    </div>
                                </div>                                
                            </div>
                        </div>
                    </form>
				</div>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary submitaddstaff" type="button" value="" onclick="event.preventDefault();document.getElementById('create').submit();" disabled>Submit</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Edit Staff  Modal-->
	<div class="modal fade" id="UpdateEmployeesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="UpdateEmployeesModal"> Update Staff </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form name="form1" method="post" id="update" action="/SCASA/StaffController?action=updateStaff">
				<div class="modal-body">
                        <div class="pl-lg-10">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="name" >Staff ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="editstaffid" class="form-control" name="staffid" placeholder="Staff ID" readonly >
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="last_name">Name<span class="small text-danger">*</span></label>
                                        <input type="text" id="editsname" class="form-control" name="sname" placeholder="Full Name"  >
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="editsgender" >Gender<span class="small text-danger">*</span></label>

										<select id="editsgender" class="form-control" name="sgender">									      
                                        <option value="" disabled selected>Choose your Gender</option>
									    	<option value="Male">Male</option>
									    	<option value="Female">Female</option>

									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="last_name">No. Tel<span class="small text-danger">*</span></label>
                                        <input type="text" id="editsnotel" class="form-control" name="snotel" placeholder="No Tel">
                                    </div>
                                </div>
                            </div>                       

                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label class="form-control-label" for="email">Email Address<span class="small text-danger">*</span></label>
                                        <input type="email" id="editsemail" class="form-control" name="semail" placeholder="example@example.com" value="<c:out value="${staff.semail}" />">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="editsdepartment">Department<span class="small text-danger">*</span></label>
                                        
										<select id="editsdepartment" class="form-control" name="sdepartment">									      
                                        <option value="" disabled selected>Choose your Department</option>
									    	<option value="IT">IT</option>
									    	<option value="Human Resources">Human Resources</option>
									    	<option value="Marketing">Marketing</option>
									    	<option value="Finance">Finance</option>
									    	<option value="Production">Production</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="last_name"> Position<span class="small text-danger">*</span></label>
                                        <input type="text" id="editsposition" class="form-control" name="sposition" placeholder="Position" value="<c:out value="${staff.sposition}" />">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="last_name">NRIC ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="editsnric" class="form-control" name="snric" placeholder="123456101234" value="<c:out value="${staff.snric}" />">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="current_password">RFID Tag ID</label>
                                        <input type="text" id="editsrfid" class="form-control" name="srfid" value="<c:out value="${staff.srfid}" />" placeholder="RFID Tag ID" readonly>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="new_password">Status</label>
                                        <select id="editsstatus" class="form-control" name="sstatus">									      
                                        <option value="" disabled selected>Choose Staff Status</option>
									    	<option value="Full-Time">Full-Time</option>
									    	<option value="Part-Time">Part-Time</option>
									    	<option value="Contract">Contract</option>
									    	<option value="Pending">Pending</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="confirm_password">Start Date</label>
                        				<input type="date" class="form-control" id="editsstartdate" name="sstartdate"  value="<c:out value="${staff.sstartdate}" />" readonly/> <!-- pattern="dd-MM-yyyy - hh:mm:ss:mm" -->
                       					<span class="input-group-addon glyphicon glyphicon-calendar" class="input-group-text" id="basic-addon2" >
                      				  </span>										
                                    </div>
                                </div>                                
                            </div>
                        </div>
				</div>
				</form>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary submiteditstaff" type="button" name="action" value="Update" onclick="event.preventDefault();document.getElementById('update').submit();">Submit</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Delete Staff Modal-->
    <div class="modal fade" id="DeleteEmployeesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="#DeleteEmployeesModal">Delete Selected Staffs?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Are you sure you want to delete the Staff?
                <br>
                <br>
                Select "Delete" below if you are ready to delete selected Staff. 
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <button class="btn btn-primary"   type="button" name="action" value="deleteStaff" onclick="event.preventDefault();document.getElementById('deleteAdmin').submit();">Delete</button>                    
                </div>
            </div>
        </div>
    </div>
    
    
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
    
    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
<!--     <script>
    $(document).ready( function () {
        $('#dataTable').DataTable();
    } );
    
    </script> -->
	
	<!-- Show Data in Modal Table-->
	<script type="text/javascript">
	
	$(document).ready(function(){
		$(".UpdateEmployeesModal").click(function(){
			$("#editstaffid"). val($(this).data('sid'));
			$("#editsname").val($(this).data('sname'));
			$("#editsgender").val($(this).data('sgender'));
			$("#editsnotel").val($(this).data('snotel'));
			$("#editsemail").val($(this).data('semail'));
			$("#editsdepartment").val($(this).data('sdepartment'));
			$("#editsposition").val($(this).data('sposition'));
			$("#editsnric").val($(this).data('snric'));
			$("#editsrfid").val($(this).data('srfid'));
			$("#editsstatus").val($(this).data('sstatus'));
			$("#editsstartdate").val($(this).data('sstartdate'));

			$("#UpdateEmployeesModal").modal('show');
		});
	});    
	
	</script>
	
	<script type="text/javascript">

	$(document).ready(function() {
	
		$("#staffid").keyup(function(event) {
			validateInputs();
		});
		
		$("#sname").keyup(function(event) {
			validateInputs();
		});	
	
		$("#sgender").keyup(function(event) {
			validateInputs();
		});
		
		$("#snotel").keyup(function(event) {
			validateInputs();
		});
		
		$("#semail").keyup(function(event) {
			validateInputs();
		});
		
		$("#sdepartment").keyup(function(event) {
			validateInputs();
		});
		
		$("#sposition").keyup(function(event) {
			validateInputs();
		});
		
		$("#snric").keyup(function(event) {
			validateInputs();
		});
		
		$("#srfid").keyup(function(event) {
			validateInputs();
		});
		
		$("#sstatus").keyup(function(event) {
			validateInputs();
		});
		
		$("#sstartdate").on("keyup change",function(event) {
			validateInputs();
		});
		
		function validateInputs(){
			
			var val1 = $("#staffid").val();
			var val2 = $("#sname").val();
			var val3 = $("#sgender").val();
			var val4 = $("#snotel").val();
			var val5 = $("#semail").val();
			var val6 = $("#sdepartment").val();
			var val7 = $("#sposition").val();
			var val8 = $("#snric").val();
			var val9 = $("#srfid").val();
			var val10 = $("#sstatus").val();
			var val11 = $("#sstartdate").val();
			
	        if(val1.length == 0 || val2.length == 0 || val4.length == 0 || val5.length == 0 || val7.length == 0 || val8.length == 0 || val9.length == 0 ){
	        	 $('.submitaddstaff').attr('disabled', true);
	        } else {
	        	$('.submitaddstaff').attr('disabled', false);
	        }
		}
		
		$("#editstaffid").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsname").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsgender").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsnotel").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsemail").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsdepartment").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsposition").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsnric").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsrfid").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsstatus").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editsstartdate").keyup(function(event) {
	    	validatepredit();
	    });
		
		function validatepredit(){
			 
	        var val1 = $("#editstaffid").val();
	        var val2 = $("#editsname").val();
	        var val3 = $("#editsgender").val();
	        var val4 = $("#editsnotel").val();
	        var val5 = $("#editsemail").val();
	        var val6 = $("#editsdepartment").val();
	        var val7 = $("#editsposition").val();
	        var val8 = $("#editsnric").val();
	        var val9 = $("#editsrfid").val();
	        var val0 = $("#editsstatus").val();
	        var val11 = $("#editsstartdate").val();
	        
	 
	        if( val2.length == 0 || val4.length == 0 || val5.length == 0 || val7.length == 0 || val8.length == 0 ){
	        	 $('.submiteditstaff').attr('disabled', true);
	        } else {
	        	$('.submiteditstaff').attr('disabled', false);
	        }
	    }
	});
	
	</script> 
	
<!--     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
	<script type="text/javascript">
	
	$("#submitaddstaff").click(function(){
		
		var staffid = $("#staffid").val();
		var sname = $("#sname").val();
		var sgender = $("#sgender").val();
		var snotel = $("#snotel").val();
		var semail = $("#semail").val();
		var sdepartment = $("#sdepartment").val();
		var sposition = $("#sposition").val();
		var snric = $("#snric").val();
		var srfid = $("#sfrid").val();
		var sstatus = $("#sstatus").val();
		var sstartdate = $("#sstartdate").val();
		
        if(staffid == 0  ){
			swal({
				  title: "Feild Empty!",
				  text: "Please chck the issing field !",
				  icon: "warning",
				  button: "OK!",
				});
			
		}else{
			
			swal({
				  title: "Good job!",
				  text: "Admin details have been updated !",
				  icon: "success",
				  button: "OK",
				});
			}

        });
	
	</script> -->
	
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
	<script type="text/javascript">
	
	$("#submitaddstaff").click(function(){	
		
		var val1 = $("#staffid").val();
		var val2 = $("#sname").val();
		var val3 = $("#sgender").val();
		var val4 = $("#snotel").val();
		var val5 = $("#semail").val();
		var val6 = $("#sdepartment").val();
		var val7 = $("#sposition").val();
		var val8 = $("#snric").val();
		var val9 = $("#srfid").val();
		var val10 = $("#sstatus").val();
		var val11 = $("#sstartdate").val();
		
        if(val1.length == 0 || val2.length == 0 || val4.length == 0 || val5.length == 0 || val7.length == 0 || val8.length == 0 || val9.length == 0 ){
			swal({
				  title: "Feild Empty!",
				  text: "Please chck the issing field !",
				  icon: "warning",
				  button: "OK!",
				});
			
		}else{
			
			swal({
				  title: "Good job!",
				  text: "Admin details have been updated !",
				  icon: "success",
				  button: "OK",
				});
			}

        });
	
	</script>
	
	<script type="text/javascript">

	$("#submiteditstaff").click(function(){
		
        var val1 = $("#editstaffid").val();
        var val2 = $("#editsname").val();
        var val3 = $("#editsgender").val();
        var val4 = $("#editsnotel").val();
        var val5 = $("#editsemail").val();
        var val6 = $("#editsdepartment").val();
        var val7 = $("#editsposition").val();
        var val8 = $("#editsnric").val();
        var val9 = $("#editsrfid").val();
        var val0 = $("#editsstatus").val();
        var val11 = $("#editsstartdate").val();
        
        if( val2.length == 0 || val4.length == 0 || val5.length == 0 || val7.length == 0 || val8.length == 0 ){
			swal({
				  title: "Feild Empty!",
				  text: "Please chck the issing field !",
				  icon: "warning",
				  button: "OK!",
				});
			
		}else{
			
			swal({
				  title: "Good job!",
				  text: "Admin details have been updated !",
				  icon: "success",
				  button: "OK",
				});
			}

      });

	
	</script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer">
	

	<!-- Add Post JS
	<script>
	
	$(document).ready(function(e) {
		//
		  $("#create").on("submit", function(event) {
			  
			  event.preventtDefult();
			  
			  console.log()
			  
			  let form = new FormData(this);
			  
				//Requesting From the Servlet
			    $.ajax({
			    	url: "StaffController",
			      	type: "POST",			      
			      	data: form,
			      	
			      	success: function(data, textStatus, jqXHR) {
			    	//"success"
			        console.log(data); 
			        if (data, textStatus, jqXHR) 
			        {
			        	swal("Data Saved!", "Data Saved Successfully!", "success");
			        } else
			        {
			        	swal("Error!", "Something went wrong try again!", "error");
			        }
			      },
			      error: function(errorThrown, textStatus, jqXHR) {
			    	  //error
			    	  swal("Error!", "Something went wrong try again!", "error");
			      },
			        processData: false,
			        contentType: false
			   
			    });
			  });
			});
	
	</script> -->

</body>

</html>