package scasa.controller;

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

import scasa.dao.AdminDAO;
import scasa.dao.AdminLoginDAO;
import scasa.model.Admin;



/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static String CREATE_ADMIN 	= "adminlist.jsp";
	private static String LIST_ADMIN 	= "adminlist.jsp";
	private static String UPDATE_ADMIN 	= "adminlist.jsp";
	private static String VIEW_ADMIN 	= "adminlist.jsp";
	
	private AdminDAO daoAdmin;
	
	String forward="";	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        daoAdmin = new AdminDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		if (action.equalsIgnoreCase("listAdmin")) {
			
			forward = LIST_ADMIN;
            request.setAttribute("admins", daoAdmin.getAllAdmin());
					
		} else if (action.equalsIgnoreCase("deleteAdmin")) {
    	
			int id= Integer.parseInt(request.getParameter("id"));
			
			System.out.println(id);
    	
			daoAdmin.deleteAdmin(id);
    	
			forward = LIST_ADMIN;
			request.setAttribute("admins", daoAdmin.getAllAdmin()); 
   
		} else if (action.equalsIgnoreCase("updateAdmin")) {	
        	
        	int id= Integer.parseInt(request.getParameter("id"));
        	
        	Admin admin = new Admin();
        	admin = daoAdmin.getAdminById(id);
        	        	
        	forward = UPDATE_ADMIN;
            request.setAttribute("admin", admin); 
	
        } else if (action.equalsIgnoreCase("viewAdmin")) {
        	
        	int id= Integer.parseInt(request.getParameter("id"));
        	
        	Admin admin = new Admin();
        	admin = daoAdmin.getAdminById(id);  
        	
//        	Admin arfids = new Admin();
//        	
//        	arfids = daoAdmin.getAdminById(admin.getArfid());
//        	admin.setArfids(arfids);
        	
        	forward = VIEW_ADMIN;       		
            request.setAttribute("admin", admin);        	
      
        } else if (action.equalsIgnoreCase("viewAdminList")) {
        	
        	forward = LIST_ADMIN;       		
        	request.setAttribute("admins", daoAdmin.getAllAdmin());        	
      
        } else if (action.equalsIgnoreCase("createAdmin")) {
        	
        	forward = CREATE_ADMIN;
        	request.setAttribute("admins", daoAdmin.getAllAdmin());
        	
        }
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	handleRequest(request);
//	handleRequest(request,response);
	String action = request.getParameter("action");
	
//	int    adminid 		= Integer.parseInt(request.getParameter("adminid"));
//	String role 		= request.getParameter("role");
//	String aname 		= request.getParameter("aname");
//	String agender 		= request.getParameter("agender");
//	String anotel		= request.getParameter("anotel");
//	String aemail 		= request.getParameter("aemail");
//	String adepartment 	= request.getParameter("adepartment");
//	String aposition	= request.getParameter("aposition");
//	String anric	 	= request.getParameter("anric");
//	String arfid 		= request.getParameter("arfid");
//	String astatus 		= request.getParameter("astatus");
//	String astartdate	= request.getParameter("astartdate");
//	String apassword 	= request.getParameter("apassword");
	
	
//	HttpSession session = request.getSession(true);
//	int hodid = (int) session.getAttribute("adminid");
	
//	Admin admin = new Admin( role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword);	
//	admin.setAdminid(adminid);
	if(action.equalsIgnoreCase("create")) {
		
		
		String role 		= request.getParameter("role");
		String aname 		= request.getParameter("aname");
		String agender 		= request.getParameter("agender");
		String anotel		= request.getParameter("anotel");
		String aemail 		= request.getParameter("aemail");
		String adepartment 	= request.getParameter("adepartment");
		String aposition	= request.getParameter("aposition");
		String anric	 	= request.getParameter("anric");
		String arfid 		= request.getParameter("arfid");
		String astatus 		= request.getParameter("astatus");
		String astartdate	= request.getParameter("astartdate");
		String apassword 	= request.getParameter("apassword");
		String astaffid 	= request.getParameter("astaffid");
		
		Admin admin = new Admin( role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword,astaffid);
		
		daoAdmin.add(admin);
		
    	response.sendRedirect("/SCASA/AdminController?action=createAdmin");
	}
	else if (action.equalsIgnoreCase("createAdmin")) {
    	
		String role 		= request.getParameter("role");
		String aname 		= request.getParameter("aname");
		String agender 		= request.getParameter("agender");
		String anotel		= request.getParameter("anotel");
		String aemail 		= request.getParameter("aemail");
		String adepartment 	= request.getParameter("adepartment");
		String aposition	= request.getParameter("aposition");
		String anric	 	= request.getParameter("anric");
		String arfid 		= request.getParameter("arfid");
		String astatus 		= request.getParameter("astatus");
		String astartdate	= request.getParameter("astartdate");
		String apassword 	= request.getParameter("apassword");
		String astaffid 	= request.getParameter("astaffid");
		
		Admin admin = new Admin( role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword,astaffid);
		
		daoAdmin.add(admin);
		
    	response.sendRedirect("/SCASA/AdminController?action=createAdmin");
    	
	}	
//	(yang ni untuk update modal)
	else if(action.equalsIgnoreCase("updateAdmin")) {
			
		int    adminid 		= Integer.parseInt(request.getParameter("adminid"));
//		int    hodid 		= Integer.parseInt(request.getParameter("hodid"));
		String role 		= request.getParameter("role");
		String aname 		= request.getParameter("aname");
		String agender 		= request.getParameter("agender");
		String anotel		= request.getParameter("anotel");
		String aemail 		= request.getParameter("aemail");
		String adepartment 	= request.getParameter("adepartment");
		String aposition	= request.getParameter("aposition");
		String anric	 	= request.getParameter("anric");
		String arfid 		= request.getParameter("arfid");
		String astatus 		= request.getParameter("astatus");
		String astartdate	= request.getParameter("astartdate");
		String apassword 	= request.getParameter("apassword");
		String astaffid 	= request.getParameter("astaffid");
    	
		Admin admin = new Admin( role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, apassword,astaffid);
		admin.setAdminid(adminid);
		//		to get the new name of the updated address admin
//    	Admin addressAdmins = new Admin();
//    	addressAdmins = daoAdmin.getAdminById(adminid);
    	
    	daoAdmin.updateAdmin1(admin);
    	
    	response.sendRedirect("/SCASA/AdminController?action=viewAdminList");
    	
//    	RequestDispatcher view = request.getRequestDispatcher("/SCASA/AdminController?action=updateAdmin");    	    	
//		request.setAttribute("admin", daoAdmin.getAdminById(adminid));
//		view.forward(request, response);
		
	}
//	 (yang ni untuk profile)
	else if(action.equalsIgnoreCase("update")) {
		
		int    adminid 		= Integer.parseInt(request.getParameter("adminid"));
		int    hodid 		= Integer.parseInt(request.getParameter("hodid"));
		String role 		= request.getParameter("role");
		String aname 		= request.getParameter("aname");
		String agender 		= request.getParameter("agender");
		String anotel		= request.getParameter("anotel");
		String aemail 		= request.getParameter("aemail");
		String adepartment 	= request.getParameter("adepartment");
		String aposition	= request.getParameter("aposition");
		String anric	 	= request.getParameter("anric");
		String arfid 		= request.getParameter("arfid");
		String astatus 		= request.getParameter("astatus");
		String astartdate	= request.getParameter("astartdate");
//		String apassword 	= request.getParameter("apassword");
		String astaffid 	= request.getParameter("astaffid");
    	
		Admin admin = new Admin(hodid, role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, astaffid);
		admin.setAdminid(adminid);
		//		to get the new name of the updated address admin
//    	Admin addressAdmins = new Admin();
//    	addressAdmins = daoAdmin.getAdminById(adminid);
    	
    	daoAdmin.updateAdmin(admin);
    	
    	response.sendRedirect("/SCASA/AdminController?action=updateAdmin");
    	
//    	RequestDispatcher view = request.getRequestDispatcher("/SCASA/AdminController?action=updateAdmin");    	    	
//		request.setAttribute("admin", daoAdmin.getAdminById(adminid));
//		view.forward(request, response);
		
	}
	
//	 (yang ni untuk profile password)
	else if(action.equalsIgnoreCase("update")) {
		
		int    adminid 		= Integer.parseInt(request.getParameter("adminid"));
		int    hodid 		= Integer.parseInt(request.getParameter("hodid"));
		String role 		= request.getParameter("role");
		String aname 		= request.getParameter("aname");
		String agender 		= request.getParameter("agender");
		String anotel		= request.getParameter("anotel");
		String aemail 		= request.getParameter("aemail");
		String adepartment 	= request.getParameter("adepartment");
		String aposition	= request.getParameter("aposition");
		String anric	 	= request.getParameter("anric");
		String arfid 		= request.getParameter("arfid");
		String astatus 		= request.getParameter("astatus");
		String astartdate	= request.getParameter("astartdate");
//		String apassword 	= request.getParameter("apassword");
		String astaffid 	= request.getParameter("astaffid");
   	
		Admin admin = new Admin(hodid, role, aname, agender, anotel, aemail, adepartment, aposition, anric, arfid, astatus, astartdate, astaffid);
		admin.setAdminid(adminid);
		//		to get the new name of the updated address admin
//   	Admin addressAdmins = new Admin();
//   	addressAdmins = daoAdmin.getAdminById(adminid);
   	
   	daoAdmin.updateAdmin(admin);
   	
   	response.sendRedirect("/SCASA/AdminController?action=updateAdmin");
   	
//   	RequestDispatcher view = request.getRequestDispatcher("/SCASA/AdminController?action=updateAdmin");    	    	
//		request.setAttribute("admin", daoAdmin.getAdminById(adminid));
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
