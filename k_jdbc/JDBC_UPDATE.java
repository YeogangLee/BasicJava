package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import e_oop.ScanUtil;

public class JDBC_UPDATE {

	public static void main(int BOARD_NO) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "UPDATE TB_JDBC_BOARD "
					+ "      SET TITLE = ?,"
					+ "			 CONTENT = ?"
					+ "    WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			
			System.out.println("수정할 항목>");
			System.out.println("1.제목\t2.내용\t0.목록");
			int numM = ScanUtil.nextInt();
				switch (numM) {
				case 1:
					System.out.println("변경할 제목 입력>");
					String title = ScanUtil.nextLine();
					ps.setString(1, title);
					String content = rs.getString(2);
					ps.setString(2, content);
					ps.setInt(3, BOARD_NO);
					System.out.println("제목이 정상적으로 변경되었습니다.");
					break;
				case 2:
					System.out.println("변경할 내용 입력>");
					content = ScanUtil.nextLine();
					title = rs.getString(1);
					ps.setString(2, content);
					ps.setInt(3, BOARD_NO);
					System.out.println("내용이 정상적으로 변경되었습니다.");
					break;
				case 0: break;
				default: 
					System.out.println("잘못된 숫자 입력"); break;
				}
			
			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 영향을 받았습니다.");
			System.out.println(result + "개의 행이 성공적으로 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}

}
