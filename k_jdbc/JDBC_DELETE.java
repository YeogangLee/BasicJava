package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_DELETE {

	public static void main(int BOARD_NO) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "DELETE FROM TB_JDBC_BOARD"
					+ "	   WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, BOARD_NO);
			
			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 영향을 받았습니다.");
			System.out.println(result + "개의 행이 성공적으로 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}

}
