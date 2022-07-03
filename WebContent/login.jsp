<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

       <%
	String role		="";
	String aemail	="";
	String aname	="";
	int adminid		=0;
	String fail		="";

	
	if(session.getAttribute("role")!=null && session.getAttribute("role")!=null)
	{
		role 	= (String)session.getAttribute("role");
		aemail 	= (String)session.getAttribute("aemail");
		aname 	= (String)session.getAttribute("aname");
		adminid = (Integer)session.getAttribute("adminid");
		
	}
	else
	{
		fail = (String)session.getAttribute("fail");
	
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

    <title>SCASA 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                        <h1 class="h4 text-gray-900 mb-4">S C A S A</h1>
                                        <h1 class="h6 text-gray-900 mb-4">Sign In</h1>
                                    </div>
                                    
                                    
                                    
                                    <form class="user" method="post" action="/SCASA/LoginController">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="aemail" name="aemail" aria-describedby="emailHelp"
                                                placeholder="Enter Email Address..." required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="apassword" name="apassword" placeholder="Password" required>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input  type="submit" name="login" value="login" class="btn btn-primary btn-user btn-block">

                                        <a href="index.jsp" class="btn btn-success btn-user btn-block">
                                            <i class="fab fa-home-f fa-fw"></i> Back to Homepage
                                        </a>
                                        <hr>
                                        <a href="index.jsp" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.jsp" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    
                                    
                                    
                                    
<!--                                         <form  method="post" id="ff" action="/SCASA/LoginController">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="aemail" name="aemail" aria-describedby="emailHelp"
                                                placeholder="Enter Email Address...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="apassword" name="apassword"  placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input  type="submit" name="login" value="login" class="btn btn-primary btn-user btn-block">

                                        <a href="index.jsp" class="btn btn-success btn-user btn-block">
                                            <i class="fab fa-home-f fa-fw"></i> Back to Homepage
                                        </a>
                                        <hr>
                                        <a href="index.jsp" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.jsp" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form> -->
                                    
                                    
                                    
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.jsp">Forgot Password?</a>
                                    </div>
<!--                                     <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                    </div>
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
    
    <script>
		function changeToUpperCase(event,obj) {
			charValue = (document.all) ? event.keyCode : event.which;
			if (charValue!="8" && charValue!="0" && charValue != "27"){
				obj.value += String.fromCharCode(charValue).toUpperCase();
				return false;
			} else {
				return true;
			}
		}
</script>

</body>

</html>