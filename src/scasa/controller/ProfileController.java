package scasa.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scasa.dao.AdminDAO;
import scasa.model.Admin;

/**
 * Servlet implementation class updateProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPDATE_ADMIN = "profile.jsp";
	
//	private static String UPDATE_PASSWORD = "profile.jsp";
	
	String forward="";	
	private AdminDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("profile")) {
			//int id = Integer.parseInt(request.getParameter("id"));
			forward = UPDATE_ADMIN;
			
			
			String test = (request.getParameter("adminid"));
			
			System.out.println(test);
			int id = Integer.parseInt(test);
					
					
			Admin admin = new Admin();
        	admin = dao.getAdminById(id);
        	
        	//System.out.println(admin.getAstartdate());
        	
        	request.setAttribute("admin", admin);
            
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
			
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		handleRequest(request);


		
		
//		int test = Integer.parseInt(request.getParameter("adminid"));
//		int test2 = Integer.parseInt(request.getParameter("hodid"));
//		
//		
//		admin.setAdminid(test);
//		System.out.println("ghjfjhtest");
//		admin.setHodid(test2);
//
//		System.out.println(test2);
//		

		if (action.equalsIgnoreCase("update")) {
        
			Admin admin = new Admin();	
			admin.setAdminid	(Integer.parseInt(request.getParameter("adminid")));
        admin.setHodid		(Integer.parseInt(request.getParameter("hodid")));
        admin.setRole		(request.getParameter("role"));
        admin.setAname		(request.getParameter("aname"));
        admin.setAgender	(request.getParameter("agender"));
        admin.setAnotel		(request.getParameter("anotel"));
        admin.setAemail		(request.getParameter("aemail"));
        admin.setAdepartment(request.getParameter("adepartment"));
        admin.setAposition	(request.getParameter("aposition"));    		          
        admin.setArfid		(request.getParameter("arfid"));
        admin.setAnric		(request.getParameter("anric"));
        admin.setAstatus	(request.getParameter("astatus"));
        admin.setAstartdate	(request.getParameter("astartdate"));
        admin.setApassword	(request.getParameter("apassword"));
        admin.setAstaffid	(request.getParameter("astaffid"));
		
		 dao.updateAdmin(admin);

		    response.sendRedirect("/SCASA/ProfileController?action=profile&adminid="+request.getParameter("adminid"));
		    
	} else if(action.equalsIgnoreCase("update1")) {
//		
		int    adminid 		= Integer.parseInt(request.getParameter("adminid"));
		String apassword 	= request.getParameter("apassword");
		
		Admin admin = new Admin(apassword);	
		admin.setAdminid(adminid);
		dao.updatePassword(admin);
	    response.sendRedirect("/SCASA/ProfileController?action=profile&adminid="+request.getParameter("adminid"));
		

		
		////		admin.setAdminid(adminid);
//        admin.setAdminid	(Integer.parseInt(request.getParameter("adminid")));
//        admin.setApassword	(request.getParameter("apassword"));
//   	
////		Admin admin = new Admin(a);
////		admin.setAdminid(adminid);
//		//		to get the new name of the updated address admin
////   	Admin addressAdmins = new Admin();
////   	addressAdmins = daoAdmin.getAdminById(adminid);
//   	
//   	daoAdmin.updateAdmin(admin);
//   	
//   	response.sendRedirect("/SCASA/AdminController?action=updateAdmin");
//   	
////   	RequestDispatcher view = request.getRequestDispatcher("/SCASA/AdminController?action=updateAdmin");    	    	
////		request.setAttribute("admin", daoAdmin.getAdminById(adminid));
////		view.forward(request, response);
//		
	}
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Admin admin = new Admin();
//		admin.setApassword	(request.getParameter("apassword"));
//		
//		 dao.updateAdmin(admin);
//
//		    response.sendRedirect("profile.jsp");
//	
//	}
	
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