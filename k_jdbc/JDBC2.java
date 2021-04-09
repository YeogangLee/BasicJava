package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		
		//데이터베이스 접속정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//try-catch로 감쌀 때 ctrl + 1 사용
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * "
					+      "FROM cart "
					+ "    WHERE cart_member = ? "
					+ "      AND cart_qty >= ?";
			ps = con.prepareStatement(sql);
			//Statement vs prepareStatement
			//-> 쿼리를 사용할 때, 물음표를 작성할 수 있느냐 없느냐의 차이
			//prepareStatement는 물음표 사용 가능 + 더 자주 사용
			// ?의 역할 : where절 작성, 왼쪽 컬럼 = 오른쪽 값
			//값 대신에 ?를 적는다, ?는 코드로 작성해서 따로 값을 넣어준다
			
			//?에 값 넣기 set자료형(물음표의 인덱스, 조회할 sql행 안의 값);
			ps.setString(1, "a001");
			ps.setInt(2, 10);
			
			rs = ps.executeQuery();
			//쿼리 실행 후 반환값인 ResultSet을 받아준다
			
			
			//ctrl 1 누르고 ...variable 목록 찾아보고 엔터
			//반환값에 맞춰 알아서 자료형을 만들어준다, 여기서는 ResultSetMetaData  
			ResultSetMetaData metaData = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터 -> 행이 몇개가 있고, 컬럼이 몇개가 있는지.
			int columnCount = metaData.getColumnCount();   //컬럼 수
			/*
			 * - metaData.getColumnCount()
			 * : 아까 next로 1번, 2번, 3번 ... 이렇게 뽑았는데
			 *   컬럼 수를 알면, next + for문 사용으로 반복해서 자동으로 조회 가능
			 */
			for(int i = 1; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					Object value = rs.getObject(i); //getObject() : 타입에 상관없이 가져올 수 있다
					System.out.print(value + "\t\t");
				}
				System.out.println();
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
