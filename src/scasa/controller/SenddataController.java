package scasa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scasa.dao.AdminDAO;
import scasa.dao.AdminLoginDAO;
import scasa.dao.AttendanceDAO;
import scasa.dao.StaffDAO;
import scasa.model.Admin;

import scasa.model.Attendance;
import scasa.model.Staff;
import scasa.model.Admin;

@WebServlet("/SenddataController")
public class SenddataController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String CREATE_ATTENDANCE = "attendancecreate.jsp";
	private static String LIST_ATTENDANCE 	= "stafflist.jsp";
	
	private StaffDAO daoStaff;
	private AdminDAO daoAdmin;
	private AttendanceDAO daoAttendance;
	
	String forward="";
	
	public SenddataController() {
        super();
        daoAttendance = new AttendanceDAO();
        daoAdmin	  = new AdminDAO();
        daoStaff	  = new StaffDAO();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String action = request.getParameter("action");
//		
//		if (action.equalsIgnoreCase("listAttendance")) {
//			
//			forward = LIST_ATTENDANCE;
//            request.setAttribute("attendances", daoAttendance.getAllAttendance());
//					
//		} else if (action.equalsIgnoreCase("deleteStaff")) {
//	    	
//				int id= Integer.parseInt(request.getParameter("id"));
//	    	
//				daoStaff.deleteStaff(id);
//	    	
//				forward = CREATE_ATTENDANCE;
//				request.setAttribute("staffs", daoStaff.getAllStaff()); 
//	   
//			}
//		RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request);
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("create")) {
			
			int    staffid 		= Integer.parseInt(request.getParameter("staffid"));
			String sname 		= request.getParameter("sname");
			String sgender 		= request.getParameter("sgender");
			long    snotel 		= Long.parseLong(request.getParameter("snotel"));
			String semail 		= request.getParameter("semail");
			String sdepartment 	= request.getParameter("sdepartment");
			String sposition	= request.getParameter("sposition");
			long    snric 		= Long.parseLong(request.getParameter("snric"));	
			String srfid 		= request.getParameter("srfid");
			String sstatus 		= request.getParameter("sstatus");
			String sstartdate	= request.getParameter("sstartdate");
			
			Staff staff = new Staff(staffid, sname, sgender, snotel, semail, sdepartment, sposition, snric, srfid, sstatus, sstartdate);
			
			daoStaff.add(staff);
	    	
	    	response.sendRedirect("/SCASA/SenddataController?action=createStaff");
	    	
		}
	}
	public void handleRequest(HttpServletRequest req) throws IOException {
	    Enumeration<String> parameterNames = req.getParameterNames();
	    System.out.println("");
	    System.out.println("////////////////// -start- //////////////////");
	    System.out.println("");
	    while (parameterNames.hasMoreElements()) {
	        String paramName = parameterNames.nextElement();
	        System.out.println("Name  : " + paramName);
	        String[] paramValues = req.getParameterValues(paramName);
	        for (int i = 0; i < paramValues.length; i++) {
	            String paramValue = paramValues[i];
	            System.out.println("Value : " + paramValue);
	        }
	    }
	    System.out.println("");
	    System.out.println("////////////////// -end- //////////////////");
	    System.out.println("");
	}
	
	
}



//
//
//<?php
//date_default_timezone_set('Asia/Kuala_Lumpur');
//$rfid = $_GET['rfid'];
//$temp = $_GET['temp'];
//$date = date("d/m/Y");
//$time = date("H:i") ;
//include_once("connect.php");
//		$query="SELECT * FROM student_data WHERE rfid='$rfid'";
//		$data_check=mysqli_query($mysqli,$query);
//		$check=mysqli_num_rows($data_check);
//		
//		$qq1="SELECT class_id,subject  from classroom_timetable where '$time' between time_start and time_end";
//       $result11=mysqli_query($mysqli,$qq1); 
//        while ($row = mysqli_fetch_array($result11))
//            {
//                $class_id=$row['class_id'];
//                $subject=$row['subject'];
//            }
//		
//    
//		
//if($check>0)
//{
//    $query1="SELECT * FROM attendance_record WHERE rfid='$rfid' AND time_out LIKE '' AND date='$date'";
//	$data_check1=mysqli_query($mysqli,$query1);
//	$check1=mysqli_num_rows($data_check1);
//
//if($check1>0)
//{
//    
//  $update="UPDATE attendance_record SET time_out='$time' WHERE rfid='$rfid' and time_out LIKE '' ";
//  $result3=mysqli_query($mysqli,$update);   
//  echo "Bye Bye ";
//}
//else{
//$result = "INSERT INTO attendance_record(rfid,date,time_in,time_out,body_temp,class_id,subject) 
//		VALUES('$rfid','$date','$time','','$temp','$class_id','$subject')";
//
//      if(mysqli_query($mysqli, $result)){
//          $qq="SELECT attendance_record.rfid,student_data.student_name  from attendance_record INNER JOIN student_data ON attendance_record.rfid=student_data.rfid where student_data.rfid='$rfid' GROUP BY rfid";
//       $result1=mysqli_query($mysqli,$qq); 
//        while ($row = mysqli_fetch_array($result1))
//            {
//                echo $row['student_name'];
//            }
//    } 
//    else {echo("Error description: " . $mysqli -> error);}
//    
//}
//}
//else 
//{	echo "Please Register"; 
//
//	$Write="<?php $" . "UIDresult='" . $rfid . "'; " . "echo $" . "UIDresult;" . " ?>";
//	file_put_contents('UIDContainer.php',$Write);
//    
//}
//
//    
//    ?>