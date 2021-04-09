package k_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import e_oop.ScanUtil;

public class JDBC_INSERT {

	public static void main(int BOARD_NO) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		java.util.Date date = new java.util.Date(); 
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO TB_JDBC_BOARD"
					+ "	  	   VALUES(?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			System.out.print("제목>");
			String title = ScanUtil.nextLine();
			ps.setString(2, title);
			System.out.print("내용>");
			String content = ScanUtil.nextLine();
			ps.setString(3, content);
			System.out.print("이름>");
			String writer = ScanUtil.nextLine();
			ps.setString(4, writer);
			ps.setDate(5, new Date(date.getTime()));
			ps.setInt(1, BOARD_NO);
			System.out.println(BOARD_NO);
			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 영향을 받았습니다.");
			System.out.println(result + "개의 행이 성공적으로 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
}

//sql의 날짜타입 세팅
//java.util.Date date = new java.util.Date(); //데이트타입 객체 생성만해도 현재시간이 들어간다
//date.setYear(2021);							//근데 특정시간을 나타내고 싶으면 이것처럼 date.set자료형(날짜값)이용
//date.setMonth(3); //월은 0부터 시작해서, 3은 4월
//date.setDate(9);
//date.setHours(16);
//date.setMinutes(42);
//date.setSeconds(30);
//ps.setDate(1, new Date(date.getTime()));

//밑처럼 사용하는게 최선, 시분초설정까지는 안된다.
//ps.setDate(1, Date.valueOf("2021-04-09"));