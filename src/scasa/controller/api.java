package scasa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scasa.dao.ApiDAO;
import scasa.dao.AttendanceDAO;
import scasa.dao.StaffDAO;
import scasa.model.Api;
import scasa.model.Attendance;
import scasa.model.Staff;

/**
 * Servlet implementation class api
 */
@WebServlet("/api")
public class api extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ApiDAO daoApi;
	private StaffDAO daoStaff;
	private AttendanceDAO attendanceDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public api() {
		super();
		// TODO Auto-generated constructor stub
		daoApi = new ApiDAO();

		daoStaff = new StaffDAO();
		attendanceDAO = new AttendanceDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("create?")) {

			String rfid = request.getParameter("rfid");
			float temp = Float.parseFloat(request.getParameter("temp"));

//			HttpSession session = request.getSession(true);
//			int adminid = (int) session.getAttribute("adminid");

//			Api api = new Api(rfid,temp);

//			daoApi.updateApi(api);
//			daoApi.updateApi(rfid,temp);

//			api.setRfid(rfid);
//			api.setTemp(temp);

//			System.out.println("Your RFID is " + rfid);
//			System.out.println("Your body temperature is " + temp + "°C Celcius ");

//			try {
//				daoApi.add(api);
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//						
//			try {
//				daoApi.add(api);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println();
		}

		doPost(request, response);
		handleRequest(request);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

//		ApiDAO daoApi;

		handleRequest(request);
		String action = request.getParameter("action");

//		if(action.equalsIgnoreCase("create?")) {

		System.out.println("ini do post");

		String rfid = request.getParameter("rfid");
		float temp = Float.parseFloat(request.getParameter("temp"));

//			HttpSession session = request.getSession(true);
//			int adminid = (int) session.getAttribute("adminid");

//			Api api = new Api(rfid,temp);

//			api.setRfid(rfid);
//			api.setTemp(temp);

		System.out.println("Your RFID is " + rfid);
//			System.out.println("Your body temperature is " + String.valueOf(temp) + "°C Celcius ");
		System.out.println("1234 ");
//			daoApi.updateApi(rfid,temp);			
		Api api = new Api(rfid, temp);
//			daoApi.updateApi(api);			
//			api.setRfid(rfid);
//			api.setTemp(temp);

		System.out.println("1234 ");
		Staff staff = daoStaff.getStaffBySrfid(rfid);

		var attendanceList = attendanceDAO.findAllBySrfidAndAdate(rfid, LocalDate.now());
		
		attendanceList.forEach(it -> System.out.println("-> aid user in list" + it.getAid()));

		if (attendanceList.isEmpty()) {
			System.out.println("attendanceList is empty");
			daoApi.addApi(api, staff);
		} else {
			Attendance latestAttendance = attendanceList.stream()
					.reduce((first, second) -> first)
					.get();

			System.out.println("-> latest aid user " + latestAttendance.getAid());
			
			Optional.ofNullable(latestAttendance.getCheckout())
			.ifPresentOrElse(it -> {
				System.out.println("-> create new attandance record");
				daoApi.addApi(api, staff);
			}, () -> {
				System.out.println("-> update attandance record");
				attendanceDAO.updateCheckout(latestAttendance);
			});
		}

		response.sendRedirect("/SCASA/AttendanceController?action=attendanceCreate");
	}

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
