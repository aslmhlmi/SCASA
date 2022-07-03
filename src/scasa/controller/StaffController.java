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

import scasa.dao.StaffDAO;
//import scasa.dao.StaffLoginDAO;
import scasa.model.Staff;



/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String CREATE_STAFF 	= "stafflist.jsp";
	private static String LIST_STAFF 	= "stafflist.jsp";
	private static String UPDATE_STAFF 	= "stafflist.jsp";
	private static String VIEW_STAFF 	= "stafflist.jsp";
	

	private static String TOTAL_STAFF = "dashboard.jsp";
	
	private StaffDAO daoStaff;
	
	String forward="";	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        daoStaff = new StaffDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listStaff")) {
			
			forward = LIST_STAFF;
            request.setAttribute("staffs", daoStaff.getAllStaff());
					
		} else if (action.equalsIgnoreCase("deleteStaff")) {
    	
			int id= Integer.parseInt(request.getParameter("id"));
    	
			daoStaff.deleteStaff(id);
    	
			forward = LIST_STAFF;
			request.setAttribute("staffs", daoStaff.getAllStaff()); 
   
		} else if (action.equalsIgnoreCase("updateStaff")) {	
        	
        	int id= Integer.parseInt(request.getParameter("id"));
        	
        	Staff staff = new Staff();
        	staff = daoStaff.getStaffById(id);
        	        	
        	forward = UPDATE_STAFF;
            request.setAttribute("staff", staff); 
	
        } else if (action.equalsIgnoreCase("viewStaff")) {
        	
        	int id= Integer.parseInt(request.getParameter("id"));
        	
        	Staff staff = new Staff();
        	staff = daoStaff.getStaffById(id);  
        	
//        	Staff srfids = new Staff();
//        	
//        	srfids = daoStaff.getStaffById(staff.getSrfid());
//        	staff.setSrfids(srfids);
        	
        	forward = VIEW_STAFF;       		
            request.setAttribute("staff", staff);        	
      
        } else if (action.equalsIgnoreCase("viewStaffList")) {
        	
        	forward = LIST_STAFF;       		
        	request.setAttribute("staffs", daoStaff.getAllStaff());        	
      
        } else if (action.equalsIgnoreCase("createStaff")) {
        	
        	forward = CREATE_STAFF;
        	
        	request.setAttribute("staffs", daoStaff.getAllStaff());
        	

		
        // TOTAL STAFF (DASHBOARD.JSP)	
        } else if (action.equalsIgnoreCase("today_staff")) {
        	
        	forward = TOTAL_STAFF;
        	request.setAttribute("staff", daoStaff.getTotalStaff());
        }
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	handleRequest(request);
	String action = request.getParameter("action");
	
//	int    staffid 		= Integer.parseInt(request.getParameter("staffid"));
//	String sname 		= request.getParameter("sname");
//	String sgender 		= request.getParameter("sgender");
//	long    snotel 		= Long.parseLong(request.getParameter("snotel"));
//	String semail 		= request.getParameter("semail");
//	String sdepartment 	= request.getParameter("sdepartment");
//	String sposition	= request.getParameter("sposition");
//	long    snric 		= Long.parseLong(request.getParameter("snric"));	
//	String srfid 		= request.getParameter("srfid");
//	String sstatus 		= request.getParameter("sstatus");
//	String sstartdate	= request.getParameter("sstartdate");
//	
//	HttpSession session = request.getSession(true);
//	int hodid = (int) session.getAttribute("adminid");
//	if(session != null) {
//		
//	}
	
//	Staff staff = new Staff(staffid, sname, sgender, snotel, semail, sdepartment, sposition, snric, srfid, sstatus, sstartdate);	
//	staff.setStaffid(staffid);
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
    	
    	response.sendRedirect("/SCASA/StaffController?action=createStaff");
    	
	}
	else if (action.equalsIgnoreCase("createStaff")) {
		
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
    	
    	response.sendRedirect("/SCASA/StaffController?action=createStaff");
    	
	}		
		
	else if(action.equalsIgnoreCase("updateStaff")) {
		
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
		staff.setStaffid(staffid);
		
		daoStaff.updateStaff(staff);
		
		response.sendRedirect("/SCASA/StaffController?action=viewStaffList");
    	
//		to get the new name of the updated address staff
//    	Staff addressStaffs = new Staff();
//    	addressStaffs = daoStaff.getStaffById(staffid);
//    	
//    	RequestDispatcher view = request.getRequestDispatcher("updateStaff");
//    	
//		request.setAttribute("staff", addressStaffs);
//		view.forward(request, response);
		
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

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
//	    PrintWriter out = res.getWriter();
//	    res.setContentType("text/plain");
	
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
	    
//	    out.close();
	
	}
	
}
