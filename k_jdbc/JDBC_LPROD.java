package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_LPROD {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		
		try {
			String sql = "SELECT * FROM LPROD";
			
			con = DriverManager.getConnection(url, user, password);		
			ps = con.prepareStatement(sql); //prepared XX prepare OO
			rs = ps.executeQuery();
			
//		while (rs.next()) {
//			String lprodID = rs.getString(1);
//			String lprodGU = rs.getString(2);
//			String lprodNM = rs.getString(3);
//			System.out.println("lprodID : " + lprodID + " / lprodGU : " + lprodGU + " / lprodMN : " + lprodNM);
//		}
		System.out.print("LPROD_ID\tLPROD_GU\tLPROD_NM");
		System.out.println();
		while (rs.next()) {
			String lprodID = rs.getString(1);
			String lprodGU = rs.getString(2);
			String lprodNM = rs.getString(3);
			System.out.println(lprodID + "\t\t" + lprodGU + "\t\t" + lprodNM);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(ps != null) try {ps.close();} catch(Exception e) {}
		if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		
		
		
	}

}
