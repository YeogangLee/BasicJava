package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import e_oop.ScanUtil;

public class JDBC_SELECT {

	public static void main(int BOARD_NO) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT *"
					+ "     FROM TB_JDBC_BOARD"
					+ "    WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, BOARD_NO);
			
			rs = ps.executeQuery();
			
			//ctrl 1 : Assign statement to new local variable
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			System.out.print(metaData.getColumnName(1) + "\t");
			for(int i = 2; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i < columnCount; i++){
					Object object = rs.getObject(i);
					System.out.print(object + "\t\t");
				}
				System.out.println();
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
				
		System.out.println("1.수정\t2.삭제\t0.목록");
		System.out.print("입력>");
		int input2 = ScanUtil.nextInt();
		
		switch (input2) {
		case 1:
			//수정 UPDATE 클래스
			k_jdbc.JDBC_UPDATE.main(BOARD_NO);
			break;
			
		case 2:
			//삭제 DELETE 클래스 
			k_jdbc.JDBC_DELETE.main(BOARD_NO);
			break;
			
		case 0:
			break;
		}
	}

}
