/**
 * 
 */
package scasa.dao;

/**
 * @author USER
 *
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import scasa.connection.ConnectionManager;
import scasa.model.Attendance;
import scasa.model.Admin;
import scasa.model.Staff;

public class AttendanceDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	static int aid, staffid, adminid;
	static float btemp;
	static String adate, checkin, checkout;
	static String saname, sgender, snotel, semail, sdepartment, sposition, snric, srfid, sstatus;

	public static Attendance getAttendance(Attendance attendance) {
		aid = attendance.getAid();

		String searchQuery = "select * from attendances where aid='" + aid + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			System.out.println(searchQuery);

			// if user exists set the isValid variable to true
			if (more) {
				attendance.setValid(true);
			}

			else if (!more) {
				attendance.setValid(false);
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return attendance;
	}

	public void updateCheckout(Attendance attendance) {
		System.out.println("updateCheckout " + attendance.getAid());
		try {

			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update attendances set checkout = (?) where aid = (?)");

			ps.setTimestamp (1, Timestamp.valueOf(LocalDateTime.now()));
			ps.setInt(2, attendance.getAid());
			
			ps.executeUpdate();

			System.out.println("Your staffid is " + staffid);
			System.out.println("Your adminid is " + adminid);

		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}

	}

	public void add(Attendance attendance) {

		try {

			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement(
					"insert into attendances (aid, staffid, adminid, btemp, checkin, checkout, adate) values (attendances_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, attendance.getAid());
			ps.setInt(2, attendance.getStaffid());
			ps.setInt(3, attendance.getAdminid());
			ps.setFloat(4, attendance.getBtemp());
			ps.setTimestamp(7, Timestamp.valueOf(attendance.getCheckin()));
			ps.setTimestamp(7, Timestamp.valueOf(attendance.getCheckout()));
			ps.setDate(8, Date.valueOf(LocalDate.now()));

			ps.executeUpdate();

			System.out.println("Your staffid is " + staffid);
			System.out.println("Your adminid is " + adminid);

		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}

	}

	public List<Attendance> getAllAttendance() {
		List<Attendance> attendances = new ArrayList<Attendance>();

		try {

			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = " SELECT s.staffid, s.sname, s.sposition, s.sdepartment, s.srfid, a.btemp, a.checkin,a.checkout,a.adate FROM staffs s JOIN attendances a ON s.staffid = a.staffid";

			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Attendance attendance = new Attendance();

				
				// ATTENDANCE
				// attendance.setAid (rs.getString("aid"));
				// attendance.setAdminid (rs.getString("adminid"));

				attendance.setStaffid(rs.getInt("staffid"));
				attendance.setBtemp(rs.getFloat("btemp"));

				var checkin = rs.getTimestamp("checkin");

				String checkinDate = null;
				if (checkin != null) {
					checkinDate = sdf1.format(checkin);
				}
				attendance.setCheckin(checkinDate);

				var checkout = rs.getTimestamp("checkout");
				String checkoutDate = null;
				if (checkout != null) {
					checkoutDate = sdf1.format(checkout);
				}
				attendance.setCheckout(checkoutDate);

				attendance.setAdate(rs.getDate("adate").toString());

				attendance.setSname(rs.getString("sname"));
				attendance.setSposition(rs.getString("sposition"));
				attendance.setSdepartment(rs.getString("sdepartment"));
				attendance.setSrfid(rs.getString("srfid"));

				attendances.add(attendance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return attendances;
	}
	//DISPLAY NUMBER OF ATTENDANCE TODAY
	public int getTodayStaff() {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement(
					"select count(distinct(staffid)) as count_today_staff from attendances where adate = TO_DATE((?),'YYYY-MM-DD') ");

			ps.setString(1, LocalDate.now().toString());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("count_today_staff");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//DISPLAY NUMBER OF TOTAL STAFF
	public int getTotalStaff() {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement(
					"select count(staffid) as count_total_staff from staffs");

//			ps.setString(1, LocalDate.now().toString());
			ResultSet rs = ps.executeQuery();
			
//			System.out.print(rs);
			
			if (rs.next()) {
				return rs.getInt("count_total_staff");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	//DISPLAY NUMBER OF ATTENDANCE ABSEN TODAY
	public int getTodayAbsenStaff() {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement(
					"select count(distinct(staffid)) as count_today_staff from attendances where adate = TO_DATE((?),'YYYY-MM-DD') ");

			ps.setString(1, LocalDate.now().toString());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("count_today_staff");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	

	public List<Attendance> findAllBySrfidAndAdate(String srfid, LocalDate adate) {
		System.out.println("findAllBySrfidAndAdate " + srfid + " " + adate);
		List<Attendance> attendances = new ArrayList<Attendance>();

		try {

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "SELECT * " + "FROM attendances " + "WHERE srfid = '" + srfid + "' " + "AND adate = TO_DATE('"
					+ adate.toString() + "','YYYY-MM-DD') ORDER BY checkin DESC";

			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Attendance attendance = new Attendance();
				
				attendance.setAid(rs.getInt("aid"));

				attendance.setStaffid(rs.getInt("staffid"));
				attendance.setBtemp(rs.getFloat("btemp"));

				var checkin = rs.getString("checkin");

				String checkinDate = null;
				if (checkin != null) {
					checkinDate = sdf1.format(sdf1.parse(checkin));
				}
				attendance.setCheckin(checkinDate);

				var checkout = rs.getString("checkout");
				String checkoutDate = null;
				if (checkout != null) {
					checkoutDate = sdf1.format(sdf1.parse(checkout));
				}
				attendance.setCheckout(checkoutDate);

				attendance.setAdate(rs.getString("adate"));

				attendance.setSname(rs.getString("sname"));
				attendance.setSposition(rs.getString("sposition"));
				attendance.setSdepartment(rs.getString("sdepartment"));
				attendance.setSrfid(rs.getString("srfid"));

				attendances.add(attendance);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		return attendances;
	}

	/*
	 * public void deleteAttendance(String aid) { String searchQuery =
	 * "delete from attendances where aid=" + "'" + aid + "'";
	 * 
	 * System.out.println(searchQuery);
	 * 
	 * try {
	 * 
	 * currentCon = ConnectionManager.getConnection(); stmt =
	 * currentCon.createStatement(); stmt.executeUpdate(searchQuery);
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public Attendance getAttendanceById(String id) {
		Attendance attendance = new Attendance();
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("select * from staffs where staffid=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				attendance.setStaffid(rs.getInt("staffid"));
				attendance.setBtemp(rs.getFloat("btemp"));
				attendance.setCheckin(rs.getString("checkin"));
				attendance.setCheckout(rs.getString("checkout"));
				attendance.setAdate(rs.getString("adate"));

				attendance.setSname(rs.getString("sname"));
				attendance.setSposition(rs.getString("sposition"));
				attendance.setSdepartment(rs.getString("sdepartment"));
				attendance.setSrfid(rs.getString("srfid"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendance;
	}

	/*
	 * public void updateAttendance(Attendance attendance) {
	 * 
	 * aid = attendance.getAid(); staffid = attendance.getStaffid(); adminid =
	 * attendance.getAdminid(); btemp = attendance.getBtemp(); checkin =
	 * attendance.getCheckin(); checkout = attendance.getCheckout(); adate =
	 * attendance.getAdate();
	 * 
	 * String searchQuery = "UPDATE attendances SET  staffid='" + staffid +
	 * "' , adminid='" + adminid + "' , btemp='" + btemp + "' " + ", checkin='" +
	 * checkin + "' , checkout='" + checkout + "' , adate='" + adate + "' , " +
	 * "WHERE aid= '" + aid + "'";
	 * 
	 * try {
	 * 
	 * currentCon = ConnectionManager.getConnection(); stmt =
	 * currentCon.createStatement(); stmt.executeUpdate(searchQuery);
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
