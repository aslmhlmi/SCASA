/**
 * 
 */
package scasa.controller;

/**
 * @author USER
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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

import scasa.dao.AttendanceDAO;
import scasa.dao.StaffDAO;
import scasa.dao.AdminDAO;
/*import scasa.dao.StaffLoginDAO;*/

import scasa.model.Attendance;
import scasa.model.Staff;
import scasa.model.Admin;
/**
 * Servlet implementation class AttendanceController
 */
@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static String LIST_ATTENDANCE = "attendancelist.jsp";
	private static String VIEW_ATTENDANCE = "attendanceview.jsp";
	private static String CREATE_ATTENDANCE = "attendancecreate.jsp";
	
	private static String TODAY_STAFF = "dashboard.jsp";
	private static String TOTAL_STAFF = "dashboard.jsp";
	private static String ABSEN_STAFF = "dashboard.jsp";
	
	//private static String REPORT = "result.jsp";
	
	private StaffDAO daoStaff;
	private AdminDAO daoAdmin;
	private AttendanceDAO daoAttendance;
	
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceController() {
        super();
        daoAttendance = new AttendanceDAO();
        daoAdmin	  = new AdminDAO();
        daoStaff	  = new StaffDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listAttendance")) {
			
			forward = LIST_ATTENDANCE;
            request.setAttribute("attendances", daoAttendance.getAllAttendance());
					
		} 
		/*else if (action.equalsIgnoreCase("deleteAttendance")) {
			  
			
			String id= request.getParameter("id");
			
			daoAttendance.deleteAttendance(id);
			
			forward = LIST_ATTENDANCE; request.setAttribute("attendances",
			daoAttendance.getAllAttendance());
			
			 }*/
			 
		else if (action.equalsIgnoreCase("viewAttendance")) {
        	
        	String id= request.getParameter("id");
        	
        	Attendance attendance = new Attendance();
        	attendance = daoAttendance.getAttendanceById(id);  
        	
        	/*Attendance aid = new Attendance();
        	aid = daoAttendance.getAttendanceById(attendance.getAid());
        	attendance.setAid(aid);*/
        	
        	forward = VIEW_ATTENDANCE;       		
            request.setAttribute("attendance", attendance);        	
      
        } else if (action.equalsIgnoreCase("viewAttendanceList")) {
        	
        	forward = LIST_ATTENDANCE;       		
        	request.setAttribute("attendances", daoAttendance.getAllAttendance());        	
      
        } else if (action.equalsIgnoreCase("createAttendance")) {
        	
        	forward = CREATE_ATTENDANCE;
        	request.setAttribute("suppliers", daoAdmin.getAllAdmin());
        	
        // TODAY STAFF TODAY (DASHBOARD.JSP)	
        } else if (action.equalsIgnoreCase("today_staff")) {
        	
        	int absent = daoAttendance.getTotalStaff() - daoAttendance.getTodayStaff();
        	// TODAY STAFF TODAY
        	request.setAttribute("attendance", daoAttendance.getTodayStaff());
        	// TOTAL STAFF
        	request.setAttribute("total_staff", daoAttendance.getTotalStaff());
        	
        	request.setAttribute("absent_staff", absent);
        	
        	forward = TODAY_STAFF;        
        }
        // TOTAL STAFF (DASHBOARD.JSP)	
//        } else if (action.equalsIgnoreCase("total_staff")) {
//        	
//        	forward = TOTAL_STAFF;
//        	request.setAttribute("staffs", daoStaff.getTotalStaff());
//		
//        // ABSEN STAFF (DASHBOARD.JSP)	
//        } else if (action.equalsIgnoreCase("today_staff")) {
//        	
//        	forward = ABSEN_STAFF;
//        	request.setAttribute("staffs", daoStaff.getTotalStaff());
//        }
		
		
		
		/*
		 * else if (action.equalsIgnoreCase("report")) { String dateFrom =
		 * request.getParameter("start_date"); String dateUntil =
		 * request.getParameter("end_date");
		 * 
		 * forward = REPORT; try { request.setAttribute("reports",
		 * AttendanceDAO.generateReport(dateFrom, dateUntil)); } catch (ParseException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		 view.forward(request, response);
		 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//handleRequest(request, response);
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("create")) {
			int aid		 		= Integer.parseInt(request.getParameter("aid"));
			int staffid 		= Integer.parseInt(request.getParameter("staffid"));
			float btemp 		= Float.parseFloat(request.getParameter("btemp"));
			String checkin 		= request.getParameter("checkin");
			String checkout 	= request.getParameter("checkout");
			String adate 		= request.getParameter("adate");			
			
			HttpSession session = request.getSession(true);
			int adminid = (int) session.getAttribute("adminid");
						
			Attendance attendance = new Attendance();
			attendance.setAid(aid);
			attendance.setStaffid(staffid);
			attendance.setAdminid(adminid);
			attendance.setBtemp(btemp);
			attendance.setCheckin(checkin);
			attendance.setCheckout(checkout);
			attendance.setAdate(adate);
			
			try {
				daoAttendance.add(attendance);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
						
			try {
				daoAttendance.add(attendance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
        	
        	response.sendRedirect("/SCASA/AttendanceController?action=attendanceCreate");
		}
		

	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/plain");

        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String paramName = parameterNames.nextElement();
            String str = paramName + " : ";

            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                
                str += paramValue;
                System.out.println(str);
            }

        }
        
        out.close();

    }

}
