package scasa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scasa.dao.AdminLoginDAO;
import scasa.connection.ConnectionManager;
import scasa.model.Admin;


/**
 * Servlet implementation class loginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLoginDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		dao = new AdminLoginDAO();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String action = request.getParameter("action");
		
//		if(session.getAttribute("role")==null) {
//		
//			response.sendRedirect("login.jsp");
//		}
		
		
		if(action.equalsIgnoreCase("Logout")) {
			session.setAttribute("role",null);
			session.setAttribute("aemail",null);
			session.setAttribute("adminid",null);
			
			session.invalidate();
			
			System.out.println("Logged Out");
			
			response.sendRedirect("login.jsp");
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String role 	= request.getParameter("role");
		String aemail 	= request.getParameter("aemail");
		String apassword= request.getParameter("apassword");
		
		HttpSession session = request.getSession(true);//declare session
		
		ConnectionManager cm = new ConnectionManager();
		Admin admin = null;
		
		try {
			admin = cm.login(aemail, apassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (admin == null) {
			
			System.out.println("");
			request.setAttribute("fail", "Invalid Email and/or Password! Please refresh or login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (admin.getRole().equals("HOD")){
			
			session.setAttribute("role","HOD");
			session.setAttribute("aemail",admin.getAemail());
			session.setAttribute("hodid",admin.getHodid());
			session.setAttribute("aname",admin.getAname());
			
			session.setAttribute("adminid",admin.getAdminid());
			
			System.out.println(admin.getRole());
			System.out.println(admin.getAname());
			System.out.println(aemail);
			System.out.println(apassword);
			
			response.sendRedirect("/SCASA/AttendanceController?action=today_staff");
			//request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else if (admin.getRole().equals("Admin")){
				
			session.setAttribute("role","Admin");
			session.setAttribute("aemail",admin.getAemail());
			//session.setAttribute("admin",admin.getAdminid());
			session.setAttribute("aname",admin.getAname());
			
			session.setAttribute("adminid",admin.getAdminid());
			
			System.out.println(admin.getRole());
			System.out.println(admin.getAname());
			System.out.println(aemail);
			System.out.println(apassword);
			
			response.sendRedirect("/SCASA/AttendanceController?action=today_staff");
			//request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}		
	}
}