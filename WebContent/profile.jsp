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

    <title>SCASA 2 - Profile</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
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
            <li class="nav-item">
                <a class="nav-link" href= "/SCASA/AttendanceController?action=today_staff">
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
            <li class="nav-item active">
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
                <div id="collapseTwo" class="collapse" aria-labelledby="headingsTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Attendance Components:</h6>
                        <a class="collapse-item" href="/SCASA/AttendanceController?action=viewAttendanceList">Attendance List</a>
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
            </li> -->

            <!-- Nav Item - Staff Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-users"></i>
                    <span>Staffs</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Staffs Components:</h6>
                        <a class="collapse-item" href="/SCASA/StaffController?action=viewStaffList">Staff List</a>
<!--                         <a class="collapse-item" href="utilities-border.html">Overtime</a>
                        <a class="collapse-item" href="utilities-animation.html">Cash Advance</a>
                        <a class="collapse-item" href="utilities-other.html">Schedules</a> -->
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading 
            <div class="sidebar-heading">
                Addons
            </div>

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
            </li> 

            <!-- Nav Item - Charts 
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li>

            <!-- Nav Item - Tables 
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li>

            <!-- Divider 
            <hr class="sidebar-divider d-none d-md-block"> -->

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
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

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
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small" >Hi, <% out.println(aname); %> </span>
                                
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/SCASA/ProfileController?action=profile&adminid=<%=adminid %>" >
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400" ></i>
                                    Profile
                                    
                                </a>
                                <!-- <a class="dropdown-item" href="#">
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
                    <h1 class="h3 mb-2 text-gray-800">Profiles</h1>

                    <!-- DataTales Example -->
                    
                    <div class="row">
                    
<!--                  	<div class="col-lg-4 order-lg-2">
		
		            <div class="card shadow mb-4">
		                <div class="card-profile-image mt-4">
		                    <figure class="rounded-circle avatar avatar font-weight-bold" style="font-size: 60px; height: 180px; width: 180px;" data-initial="{{ Auth::user()->name[0] }}"></figure>
		                </div>
		                <div class="card-body">
		
		                    <div class="row">
		                        <div class="col-lg-12">
		                            <div class="text-center">
		                                <h5 class="font-weight-bold"></h5>
		                                <p>Administrator</p>
		                            </div>
		                        </div>
		                    </div>
		
		                    <div class="row">
		                        <div class="col-md-4">
		                            <div class="card-profile-stats">
		                                <span class="heading">22</span>
		                                <span class="description">Friends</span>
		                            </div>
		                        </div>
		                        <div class="col-md-4">
		                            <div class="card-profile-stats">
		                                <span class="heading">10</span>
		                                <span class="description">Photos</span>
		                            </div>
		                        </div>
		                        <div class="col-md-4">
		                            <div class="card-profile-stats">
		                                <span class="heading">89</span>
		                                <span class="description">Comments</span>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div> -->
		        
		        
               <div class="col-lg-8 order-lg-1">
                    
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Edit Profile</h6>
                        </div>

					<div class="card-body">

                    <form method="POST" action="/SCASA/ProfileController" autocomplete="off" >
                        <input type="hidden" name="_token" value="">

                        <input type="hidden" name="_method" value="PUT">


                        <div class="pl-lg-4">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="adminid" >Admin ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="adminid" class="form-control" name="adminid" placeholder="User ID" value="<c:out value="${admin.adminid}" />"  readonly>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="aname">HOD ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="hodid" class="form-control" name="hodid" placeholder="Full Name" value="<c:out value="${admin.hodid}" />" readonly >
                                    </div>
                                </div>
                                  <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="aname">Staff ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="astaffid" class="form-control" name="astaffid" placeholder="Full Name" value="<c:out value="${admin.astaffid}" />" required>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                            	<div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="aname">Name<span class="small text-danger">*</span></label>
                                        <input type="text" id="aname" class="form-control" name="aname" placeholder="Full Name" value="<c:out value="${admin.aname}" />" required>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="aemail">Email Address<span class="small text-danger">*</span></label>
                                        <input type="email" id="aemail" class="form-control" name="aemail" placeholder="example@example.com" value="<c:out value="${admin.aemail}" />" required>
                                    </div>
                                </div>
                            </div>                                                        
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="agender" >Gender<span class="small text-danger">*</span></label>

										<select id="agender" class="form-control" name="agender" placeholder="">										
									    										      
                                        	<option hidden >${admin.agender}</option>
                                        	
									    	<option value="Male">Male</option>
									    	<option value="Female">Female</option>

									    </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="anotel">No. Tel<span class="small text-danger">*</span></label>
                                        <input type="text" id="anotel" class="form-control" name="anotel" placeholder="No Tel" value="<c:out value="${admin.anotel}" />" required >
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="adepartment">Department<span class="small text-danger">*</span></label>
                                        
                                        <select id="adepartment" class="form-control" name="adepartment">	
                                        	<option hidden >${admin.adepartment}</option>
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
                                        <label class="form-control-label" for="sposition"> Position<span class="small text-danger">*</span></label>
                                        <input type="text" id="aposition" class="form-control" name="aposition" placeholder="Position" value="<c:out value="${admin.aposition}" />"  readonly>             
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="role">Roles<span class="small text-danger">*</span></label>
                                        <input type="text" id="role" class="form-control" name="role" placeholder="Roles" value="<c:out value="${admin.role}" />"  readonly>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="last_name">NRIC ID<span class="small text-danger">*</span></label>
                                        <input type="text" id="anric" class="form-control" name="anric" placeholder="123456101234" value="<c:out value="${admin.anric}" />" required >
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="arfid">RFID Tag ID</label>
                                        <input type="text" id="arfid" class="form-control" name="arfid" placeholder="RFID Tag ID" value="<c:out value="${admin.arfid}" />" readonly>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="astatus">Status</label>
                                        <input type="text" id="astatus" class="form-control" name="astatus" placeholder="Status" value="<c:out value="${admin.astatus}" />" readonly >
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group focused">
                                        <label class="form-control-label" for="astartdate">Start Date</label>
                        				<input type="date" class="form-control" id="astartdate" name="astartdate" value="${admin.astartdate}" value="<c:out value="${admin.astartdate}" />" readonly>
                       					<span class="input-group-addon glyphicon glyphicon-calendar" class="input-group-text" id="basic-addon2">
                      				  </span>										
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <br>

                        <!-- Button -->
                        <div class="pl-lg-4">
                            <div class="row">
                                <div class="col text-center">
                                   <!-- <button type="button" data-toggle="modal" data-target="#ProfileModal" class="btn btn-primary" >Save Changes</button> -->
                                   <button type="submit" id="submit" value="update" name="action" class="btn btn-primary" >Save Changes</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div> 
                
                <!-- EDIT PASSWORD -->
				<div class="card-body"></div>
				</div>				
						<div class="card shadow mb-4">
		                        <div class="card-header py-3">
		                            <h6 class="m-0 font-weight-bold text-primary">Edit Password</h6>
		                        </div>
		
							<div class="card-body">
		
		                    <form method="POST" action="/SCASA/ProfileController" autocomplete="off" >
		                        <input type="hidden" name="_token" value="">
		
		                        <input type="hidden" name="_method" value="PUT">
									<div class="row">
				                    	<div class="col-lg-6">
				                        	<div class="form-group focused">
				                        		<label class="form-control-label" for="current_password">Current password</label>
				                                	<input type="text" id="apassword" class="form-control" name="apassword" placeholder="Current password" value="<c:out value="${admin.apassword}" />"disabled>
				                            </div>
				                        </div>
				                        <div class="col-lg-6">
				                           	<div class="form-group focused">
				                                <label class="form-control-label" for="new_password">New password</label>
				                           	        <input type="password" id="apassword" class="form-control" name="apassword" placeholder="New password" required>
				                            </div>
				                        </div>
				                        <div class="col-lg-4">
			                                <div class="form-group focused">
		                                        <label class="form-control-label" for="" hidden>Confirm StaffID</label>				                                        
                        						<input type="text" id="adminid" class="form-control" name="adminid" placeholder="User ID" value="<c:out value="${admin.adminid}" />"  hidden>                		                                        
<!-- 		                                        <input type="text" id="adminid" class="form-control" name="adminid" placeholder="Staff ID"> -->
				                            </div>
				                        </div> 
						        	</div>
						        	
						        	<br>
						        	
							      	<!-- Button Password -->
			                        <div class="pl-lg-4">
			                            <div class="row">
			                                <div class="col text-center">
			                                   <!-- <button type="button" data-toggle="modal" id=submit data-target="#PasswordModal" class="btn btn-primary" >Save Changes</button> -->
	                                   				<button type="submit" id="submit" value="update1" name="action" class="btn btn-primary" >Save Changes</button> 
			                                </div>
			                            </div>
			                        </div>	        
					        	</form>
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
    
    <!-- Update Profile Modal-->
	<div class="modal fade" id="ProfileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"> User Information </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Update User Information ? </div>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="submit" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary" type="button" value="" >Proceed</button>
				</div>
			</div>
		</div>
	</div>
	
	    <!-- Update Password Modal-->
	<div class="modal fade" id="PasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"> User Information </h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Update Profile Password ? </div>
				<div class="modal-footer">
						<button class="btn btn-secondary" type="submit" data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="profile.jsp">Proceed</a>
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
        
    <!-- Page level custom scripts -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    

    <!-- Page level plugins 
    <script src="vendor/chart.js/Chart.min.js"></script> -->

    <!-- Page level custom scripts 
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>-->
    

    
<!--     <script>
    
	$("#update").click(function() {
		
		var val1 = $("#adminid").val();
		var val2 = $("#hodid").val();
		var val3 = $("#aname").val();
		var val4 = $("#agender").val();
		var val5 = $("#anotel").val();
		var val6 = $("#aemail").val();
		var val7 = $("#adepartment").val();
		var val8 = $("#aposition").val();
		var val9 = $("#role").val();
		var val0 = $("#anric").val();
		var val11= $("#arfid").val();
		var val12= $("#astatus").val();
		var val13= $("#astartdate").val();
		var val14= $("#astaffid").val();
		
        //if(val1.length == 0 || val2.length == 0 || val3.length == 0  || val4.length == 0 || val5.length == 0 || val6.length == 0 || val7.length == 0 || val8.length == 0 || val9.length == 0 || val10.length == 0 || val11.length == 0 || val12.length == 0 || val13.length == 0 val14.length == 0){
        if(val1 == 0 || val2 == 0 || val3 == 0  || val4 == 0 || val5 == 0 || val6 == 0 || val7 == 0 || val8 == 0 || val9 == 0 || val10 == 0 || val11 == 0 || val12 == 0 || val13 == 0 val14 == 0){
                	
        	swal({
        		title: "Fail !",
        		text: "You data have not Update !",
        		icon: "warning",
        		button: "OK",
        		});

        } else {
        	swal({
        		title: "Successfully !",
        		text: "You data have  Update !",
        		icon: "success",
        		button: "OK",
        		});
        }
	)};
	)};
    
    </script> -->
    
    	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    	<script>
		$("#submit").click(function(){
			
			var astaffid = $("#astaffid").val();
			var aname = $("#aname").val();
			var aemail = $("#aemail").val();
			var agender = $("#agender").val();
			var anotel = $("#anotel").val();
			var adepartment = $("#adepartment").val();
			var anric = $("#anric").val();
			
			if( astaffid == '' || aname =="" || aemail ==""  ){
				swal({
					  title: "Feild Empty!",
					  text: "Please chck the issing field !",
					  icon: "warning",
					  button: "OK!",
					});
				
			}else{
				
				swal({
					  title: "Good job!",
					  text: "You profile have been updated !",
					  icon: "success",
					  button: "OK",
					});
			}
			});
		
	</script>

</body>
</html>