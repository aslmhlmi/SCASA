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

    <title>	SCASA 2 - Admin</title>

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
                        <a class="collapse-item" href="/SCASA/AttendanceController?action=viewAttendanceList">Attendance List</a>
<!--                         <a class="collapse-item" href="cards.html">Staffs</a> -->
                    </div>
                </div>
            </li>
            
            <%if (role == "HOD"){ %>
            
		                     <!-- Nav Item - Admin Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
                    aria-expanded="true" aria-controls="collapseThree">
                    <i class="fas fa-fw fa-user-friends"></i>
                    <span>Admin</span>
                </a>
                <div id="collapseThree" class="collapse show" aria-labelledby="headingsTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Admin Components:</h6>
                        <a class="collapse-item active" href="/SCASA/AdminController?action=viewAdminList">Admin List</a>
                    </div>
                </div>
            </li>
		         
		         
		      <% } %>
            
			<!-- Nav Item - Admin Collapse Menu 
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
                    aria-expanded="true" aria-controls="#collapseThree">
                    <i class="fas fa-fw fa-user-friends"></i>
                    <span>Admin</span>
                </a>
                <div id="#collapseThree" class="collapse show" aria-labelledby="headingThree" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Admin Components:</h6>
                        <a class="collapse-item active" href="/SCASA/AdminController?action=viewAdminList">Admin List</a>
                    </div>
                </div>
            </li> -->

			<!-- Nav Item - Staff Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-users"></i>
                    <span>Staffs</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#collapseUtilities">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Staffs Components:</h6>
                        <a class="collapse-item" href="/SCASA/StaffController?action=viewStaffList">Staff List</a>
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
            </li>  -->

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
                    <h1 class="h3 mb-2 text-gray-800">Admins Tables</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="md-8 font-weight-bold text-primary">DataTables of Admin</h6>                            
                        </div>
                        <div class="card-header py-3">
                            <button  type="button" data-toggle="modal" data-target="#AddAdminModal" 
                            class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm " >
                            
                            <i class="fas fa-plus-square fa-sm text-white-50"></i> Add New Admin </button>
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Admin ID</th>
                                            <th>Staff ID</th>
                                            <th>Name</th>
                                            <th>Role</th>
                                            <th>Department</th>
                                            <th>Gender</th>
                                            <th>Start date</th>
                                            <th>RFID Tag ID</th>
                                            <th>Status</th>
                                            <th>Details</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${admins}" var="admin">                                    
                                        <tr>
                                        	<td><c:out value="${admin.adminid}" /></td>                                        	
                                            <td><c:out value="${admin.astaffid}" /></td>
                                            <td><c:out value="${admin.aname}" /></td>
                                            <td><c:out value="${admin.role}" /></td>
                                            <td><c:out value="${admin.adepartment}" /></td>
                                            <td><c:out value="${admin.agender}" /></td>
                                            <td><c:out value="${admin.astartdate}" /></td>
                                            <td><c:out value="${admin.arfid}" /></td>
                                            <td><c:out value="${admin.astatus}" /></td>
                                            <td>                                           
                                            	<div class="dropdown mb-4">
                                        			<button class="btn btn-primary btn-sm dropdown-toggle" type="button"
                                            		id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                            		aria-expanded="false">
                                            		Dropdown
                                        			</button>
                                        		<div class="dropdown-menu animated--fade-in"
                                            		aria-labelledby="dropdownMenuButton">
                                            		
                                            		<a class="dropdown-item UpdateAdminModal" role="button"
                                            		data-toggle="modal" data-target="#UpdateAdminModal"
                                            
                                            		data-aid		="${admin.adminid}"   
													data-hodid		="${admin.hodid }"  	 	
													data-astaffid	="${admin.astaffid }" 
													data-aname		="${admin.aname }" 
													data-agender	="${admin.agender }" 
													data-anotel		="${admin.anotel }" 
													data-aemail		="${admin.aemail }" 
													data-adepartment="${admin.adepartment }"  
													data-aposition	="${admin.aposition }" 
													data-role		="${admin.role }" 
													data-anric		="${admin.anric }" 
													data-arfid		="${admin.arfid }" 
													data-astatus	="${admin.astatus }" 
													data-astartdate	="${admin.astartdate }" 
													data-apassword	="${admin.apassword }"  		

                                            		 >
                                            		 <i class="fas fa-edit fa-sm fa-fw mr-2 text-gray-400"></i>Edit</a>
                                            		 
                                            		<a class="dropdown-item " href="/SCASA/AdminController?action=deleteAdmin&id=${admin.adminid}"
                                            		onclick="return confirm('Are you sure?')"
                                            		
                                            		
                                            		>
                                            		
<!--                                             		data-toggle="modal" data-target="#DeleteAdminModal"                                           		 
 -->                                            		
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
    
    
	<!-- Add New Admin  Modal-->
	<div class="modal fade" id="AddAdminModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title"> Add New Admin </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
				<form  name="form1" method="post" id="create" action="/SCASA/AdminController?action=createAdmin">
                        <div class="pl-lg-10">
                            <div class="row">
                               <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="addadminid" >Staff ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="astaffid" class="form-control" name="astaffid" placeholder="Staff ID" value=""  >
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="addaname">Name<span class="small text-danger">*</span></label>
                                        <input type="text" id="aname" class="form-control" name="aname" placeholder="Full Name" value="">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="agender" >Gender<span class="small text-danger">*</span></label>

										<select id="agender" class="form-control" name="agender">									      
                                        <option value="" disabled selected>Choose your Gender</option>
									    	<option value="Male">	Male</option>
									    	<option value="Female">	Female</option>

									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="addanotel">No. Tel<span class="small text-danger">*</span></label>
                                        <input type="tel" id="anotel" class="form-control" name="anotel" pattern="[0-9]{11}" placeholder="No Tel 0122345678" value="">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label class="form-control-label" for="addaemail">Email Address<span class="small text-danger">*</span></label>
                                        <input type="email" id="aemail" class="form-control" name="aemail" placeholder="example@example.com" value="">
                                    </div>
                                </div>
                            </div>  
                            


                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="adepartment">Department<span class="small text-danger">*</span></label>
                                        
										<select id="adepartment" class="form-control" name="adepartment">									      
                                        <option value="" disabled selected>Choose your option</option>
									    	<option value="IT">				IT</option>
									    	<option value="Human Resources">Human Resources</option>
									    	<option value="Marketing">		Marketing</option>
									    	<option value="Finance">		Finance</option>
									    	<option value="Production">		Production</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="aposition"> Position<span class="small text-danger">*</span></label>
                                        <input type="text" id="aposition" class="form-control" name="aposition" placeholder="Position" value="">
                                    </div>
                                </div>
                            </div>
                                                   
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="role">Roles<span class="small text-danger">*</span></label>
                                        <select id="role" class="form-control" name="role">									      
                                        <option value="" disabled selected>Choose your option</option>
									    	<option value="Admin">		Admin</option>
									    	<option value="HOD">		HOD</option>
									    	<option value="No Roles">	No Roles</option>
									    </select>                                    
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="anric">NRIC ID<span class="small text-danger">*</span></label>
                                        <input type="number" id="anric" class="form-control" name="anric" pattern="[0-9]{11}" name="anric" placeholder="970212105454" value="">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="arfid">RFID Tag ID</label>
                                        <input type="text" id="arfid" class="form-control" name="arfid" placeholder="RFID Tag ID">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">                                
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="astatus">Status</label>
                                        <select id="astatus" class="form-control" name="astatus">									      
                                        <option value="" disabled selected>Choose your option</option>
									    	<option value="Full-Time">	Full-Time</option>
									    	<option value="Part-Time">	Part-Time</option>
									    	<option value="Contract">	Contract</option>
									    	<option value="Pending">	Pending</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="astartdate">Start Date</label>
                        				<input type="date" class="form-control" id="astartdate" name="astartdate"/>
                       					<span class="input-group-addon glyphicon glyphicon-calendar" class="input-group-text" id="basic-addon2">
                      				  </span>										
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="apassword">Admin Password</label>
                        				<input type="password" class="form-control" id="apassword" name="apassword" placeholder="Admin Password">
                        			</div>
                                </div>    
                        	</div>
                        </div>
                     </form>
				</div>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary submitaddadmin " id= submitaddadmin type="button" value="" onclick="event.preventDefault();document.getElementById('create').submit();" disabled> Submit</button>
				</div>
			</div>
		</div>
	</div>
    
    <!-- Edit Admin  Modal-->
	<div class="modal fade" id="UpdateAdminModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="UpdateAdminModal"> Update Admin </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form method="post" id="update" action="/SCASA/AdminController?action=updateAdmin">
				<div class="modal-body">
                        <div class="pl-lg-10">
                            <div class="row">
                             	<div class="col-lg-2">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Admin ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="editadminid" class="form-control" name=adminid placeholder="Full Name" readonly >
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update" >Staff ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="editastaffid" class="form-control" name="astaffid" placeholder="Staff ID" readonly >
                                    </div>
                                </div>
                                 <div class="col-lg-2">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">HOD ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="edithodid" class="form-control" name="hodid" placeholder="Full Name" readonly>
                                    </div>
                                </div> 
								<div class="col-lg-6">
		                            <div class="form-group focused">
		                            	<label class="form-control-label" for="update">Name<span class="small text-danger">*</span></label>
                                    	<input type="text" id="editaname" class="form-control" name="aname" placeholder="Full Name" >
		                            </div>
		                    	</div>
							</div>
							<div class="row">	                             	
	                                <div class="col-lg-4">
	                                    <div class="form-group focused">
	                                        <label class="form-control-label" for="update" >Gender<span class="small text-danger">*</span></label>
	
											<select id="editagender" class="form-control" name="agender">									      
	                                        <option value="" disabled selected>Choose your Gender</option>
										    	<option value="Male">	Male</option>
										    	<option value="Female">	Female</option>
	
										    </select>
	                                    </div>
	                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">No. Tel<span class="small text-danger">*</span></label>
                                        <input type="text" id="editanotel" class="form-control" name="anotel" placeholder="No Tel">
                                    </div>
                                </div>        
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label class="form-control-label" for="update">Email Address<span class="small text-danger">*</span></label>
                                        <input type="email" id="editaemail" class="form-control" name="aemail" placeholder="example@example.com" value="<c:out value="${admin.aemail}" />">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Department<span class="small text-danger">*</span></label>
                                        
										<select id="editadepartment" class="form-control" name="adepartment">									      
                                        <option value="" disabled selected>Choose your Department</option>
									    	<option value="IT">				IT</option>
									    	<option value="Human Resources">Human Resources</option>
									    	<option value="Marketing">		Marketing</option>
									    	<option value="Finance">		Finance</option>
									    	<option value="Production">		Production</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update"> Position<span class="small text-danger">*</span></label>
                                        <input type="text" id="editaposition" class="form-control" name="aposition" placeholder="Position" value="<c:out value="${admin.aposition}" />">
                                    </div>
                                </div>
                            </div>
                                                   
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Roles<span class="small text-danger">*</span></label>
                                        <select id="editrole" class="form-control" name="role">									      
                                        <option value="" disabled selected>Choose your Roles</option>
									    	<option value="Admin">		Admin</option>
									    	<option value="HOD">		HOD</option>
									    	<option value="No Roles">	No Roles</option>
									    </select>                                    
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">NRIC ID<span class="small text-danger">*</span></label>
                                        <input type="number" id="editanric" class="form-control" name="anric" value="<c:out value="${admin.anric}" />" placeholder="950302010213">
                                    </div>
                                </div>

                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">RFID Tag ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="editarfid" class="form-control" name="arfid" value="<c:out value="${admin.arfid}" />" placeholder="RFID Tag ID">
                                    </div>
                                </div>
                           </div>
                           <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Status</label>
                                        <select id="editastatus" class="form-control" name="astatus">									      
                                        <option value="" disabled selected>Choose Staff Status</option>
									    	<option value="Full-Time">	Full-Time</option>
									    	<option value="Part-Time">	Part-Time</option>
									    	<option value="Contract">	Contract</option>
									    	<option value="Pending">	Pending</option>
									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Start Date</label>
                        				<input type="date" class="form-control" id="editastartdate" name="astartdate" value="<c:out value="${admin.astartdate}" />"readonly/>
                       					<span class="input-group-addon glyphicon glyphicon-calendar" class="input-group-text" id="basic-addon2">
                      				  </span>										
                                    </div>
                                </div>
                                 <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="update">Admin Password</label>
                        				<input type="text" class="form-control" id="editapassword" name="apassword" value="<c:out value="${admin.apasssword}" />"/>
										
                                    </div>
                                </div>                                    
                            </div>
                        </div>
					</div>
				</form>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary submiteditadmin" type="button" name="" value="" onclick="event.preventDefault();document.getElementById('update').submit();" >Submit</button>
				</div>
			</div>
		</div>
	</div>
    
    <!-- Delete Staff Modal-->
    <div class="modal fade" id="DeleteAdminModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Selected Admin?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Are you sure you want to delete the Admin?
                <br>
                <br>
                Select "Delete" below if you are ready to delete selected Staff. 
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" 	type="button" data-dismiss="modal">Cancel</button>
                    
                    
                    <a class="btn btn-primary" href="/SCASA/AdminController?action=deleteAdmin?id=${admin.adminid}"> Delete</a>
                	 
                    
                    
                    
                    <!-- <button class="btn btn-primary" 	type="button" name="action" value="delete" onclick="event.preventDefault();document.getElementById('deleteAdmin').submit();">Delete</button>
                	  --><!-- href="/SCASA/AdminController?action=deleteAdmin" -->
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
	
	<!-- Disable modal edit -->
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		$(".UpdateAdminModal").click(function(){

			$("#editadminid"). val($(this).data('aid'));	
			$("#edithodid").val($(this).data('hodid'));	
			$("#editastaffid").val($(this).data('astaffid'));
			$("#editaname").val($(this).data('aname'));
			$("#editagender").val($(this).data('agender'));
			$("#editanotel").val($(this).data('anotel'));
			$("#editaemail").val($(this).data('aemail'));
			$("#editadepartment").val($(this).data('adepartment'));
			$("#editaposition").val($(this).data('aposition'));
			$("#editrole").val($(this).data('role'));
			$("#editanric").val($(this).data('anric'));
			$("#editarfid").val($(this).data('arfid'));
			$("#editastatus").val($(this).data('astatus'));
			$("#editastartdate").val($(this).data('astartdate'));
			$("#editapassword").val($(this).data('apassword'));
			
			$('#UpdateAdminModal').modal('show')


		});		
	});
	
	</script>	
	
	
 	<script type="text/javascript">
 	
	<!-- Add Admin List Javascript -->
 	
	$(document).ready(function() {
	
		$("#adminid").keyup(function(event) {
			validateInputs();
		});
		
		$("#hodid").keyup(function(event) {
			validateInputs();
		});
		
		$("#astaffid").keyup(function(event) {
			validateInputs();
		});
		
		$("#aname").keyup(function(event) {
			validateInputs();
		});	
	
		$("#agender").keyup(function(event) {
			validateInputs();
		});
		
		$("#anotel").keyup(function(event) {
			validateInputs();
		});
		
		$("#aemail").keyup(function(event) {
			validateInputs();
		});
		
		$("#adepartment").keyup(function(event) {
			validateInputs();
		});
		
		$("#aposition").keyup(function(event) {
			validateInputs();
		});

		$("#role").keyup(function(event) {
			validateInputs();
		});		
		
		$("#anric").keyup(function(event) {
			validateInputs();
		});
		
		$("#arfid").keyup(function(event) {
			validateInputs();
		});
		
		$("#astatus").keyup(function(event) {
			validateInputs();
		});
		
		$("#astartdate").keyup(function(event) {
			validateInputs();
		});

		$("#apassword").keyup(function(event) {
			validateInputs();
		});
		
		<!-- Edit Admin List Javascript -->
		function validateInputs(){
			
			var val1 = $("#astaffid").val();
			var val2 = $("#aname").val();
			var val3 = $("#agender").val();
			var val4 = $("#anotel").val();
			var val5 = $("#aemail").val();
			var val6 = $("#adepartment").val();
			var val7 = $("#aposition").val();
			var val8 = $("#role").val();		
			var val9 = $("#anric").val();
			var val10 = $("#arfid").val();
			var val11 = $("#astatus").val();
			var val12 = $("#astartdate").val();
			var val13 = $("#apassword").val();
			
	        if(val1.length == 0 || val2.length == 0|| val4.length == 0 || val5.length == 0 || val7.length == 0 || val9.length == 0 || val10.length == 0 || val13.length == 0){
	        	 $('.submitaddadmin').attr('disabled', true);
	        } else {
	        	$('.submitaddadmin').attr('disabled', false);
	        }
		}
		
		$("#editadminid").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#edithodid").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editastaffid").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editaname").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editagender").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editanotel").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editaemail").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editadepartment").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editaposition").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editrole").keyup(function(event) {
	    	validatepredit();
	    });
		
		$("#editanric").keyup(function(event) {
	    	validatepredit();
	    });
		

		$("#editarfid").keyup(function(event) {
	    	validatepredit();
	    });
		

		$("#editastatus").keyup(function(event) {
	    	validatepredit();
	    });
		

		$("#editastartdate").keyup(function(event) {
	    	validatepredit();
	    });

		$("#editapassword").keyup(function(event) {
	    	validatepredit();
	    });
		
		function validatepredit(){
			 
	        var val1 = $("#editadminid").val(); 
	        var val2 = $("#edithodid").val();	        
	        var val3 = $("#editastaffid").val();
	        var val4 = $("#editaname").val();		
	        var val5 = $("#editagender").val();
	        var val6 = $("#editanotel").val();
	        var val7 = $("#editaemail").val();
	        var val8 = $("#editadepartment").val();        
	        var val9 = $("#editaposition").val();
	        var val10 = $("#editrole").val();
	        var val11 = $("#editanric").val();
	        var val12 = $("#editarfid").val();
	        var val13 = $("#editastatus").val();
	        var val14 = $("#editastartdate").val();
	        var val15 = $("#editapassword").val();
	        
	 
	        if(val4.length == 0 || val6.length == 0 || val7.length == 0 || val9.length == 0 || val11.length == 0 || val12.length == 0 ){
	        	 $('.submiteditadmin').attr('disabled', true);
	        } else {
	        	$('.submiteditadmin').attr('disabled', false);
	        }
	    	}
		});
	
	</script>
	
	    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
		$("#submitaddadmin").click(function(){
			
/* 			var astaffid = $("#astaffid").val();
			var aname = $("#aname").val();
			var aemail = $("#aemail").val();
			var agender = $("#agender").val();
			var anotel = $("#anotel").val();
			var adepartment = $("#adepartment").val();
			var anric = $("#anric").val(); */
			
			var val1 = $("#astaffid").val();
			var val2 = $("#aname").val();
			var val3 = $("#agender").val();
			var val4 = $("#anotel").val();
			var val5 = $("#aemail").val();
			var val6 = $("#adepartment").val();
			var val7 = $("#aposition").val();
			var val8 = $("#role").val();		
			var val9 = $("#anric").val();
			var val10 = $("#arfid").val();
			var val11 = $("#astatus").val();
			var val12 = $("#astartdate").val();
			var val13 = $("#apassword").val();
			
			if(val1.length == 0 || val2.length == 0 || val4.length == 0 || val5.length == 0 || val7.length == 0 || val9.length == 0 || val10.length == 0 || val13.length == 0){
				swal({
					  title: "Feild Empty!",
					  text: "Please chck the issing field !",
					  icon: "warning",
					  button: "OK!",
					});
				
			}else{
				
				swal({
					  title: "Good job!",
					  text: "Admin have been created !",
					  icon: "success",
					  button: "OK",
					});
			}
			});
		
	</script>
	
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
	<script>
	
	$("#submiteditadmin").click(function(){
		
        var val1 = $("#editadminid").val(); 
        var val2 = $("#edithodid").val();	        
        var val3 = $("#editastaffid").val();
        var val4 = $("#editaname").val();		
        var val5 = $("#editagender").val();
        var val6 = $("#editanotel").val();
        var val7 = $("#editaemail").val();
        var val8 = $("#editadepartment").val();        
        var val9 = $("#editaposition").val();
        var val10 = $("#editrole").val();
        var val11 = $("#editanric").val();
        var val12 = $("#editarfid").val();
        var val13 = $("#editastatus").val();
        var val14 = $("#editastartdate").val();
        var val15 = $("#editapassword").val();
        
        if(val4.length == 0 || val6.length == 0 || val7.length == 0 || val9.length == 0 || val11.length == 0 || val12.length == 0 ){
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
	
</body>


</html>