package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {

		/*
		 * JDBC(JAVA Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성단계
		 * 1. Connection 객체 생성(DB 연결)
		 * 2. Statement 객체 생성(쿼리 작성)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 순으로 닫기
		 * 
		 * 오늘 - 오라클 자바 연결 수업
		 * ojdbc jdk버전에 따라 다르게 사용하는데, 우리는 JDK7을 사용하니 ojdbc6 사용
		 *  
		 * ojdbc 들고오는 방법
		 * 소스파일 상위 파일 - JavaProgramming 위에서 우클릭
		 * > Java Build Path > Libraries 탭 > add external Jars 버튼 클릭
		 * 
		 * 앞으로 오라클과 연결해서 사용할 때마다, ojdbc 연결해서 사용할 것
		 * 왼쪽 패키지 탐색창 아래에 Referenced Libraries  
		 */
		
		
		//데이터베이스에 접속할 정보 필요
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
									  //주소는 골뱅이를 기준으로 앞부분은 고정이고, 뒷부분은 상황에 따라 달라질 수 있다
									  //로컬호스트가 아니라면 서버의 ip 주소를 적어주면 된다
		String user = "stu";
		String password = "java";
		
		
		//JDBC를 사용하기 위한 3가지 객체
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//try-catch 파이널리에 이 변수들이 있으면 닫을 수가 없으므로, 밖인 여기 선언
		
		
		try {
			//DriverManager : 데이터베이스는 접속하기 위한 드라이버를 관리해주는 클래스
			//드라이버 : 서로 다른 애들을 연결해주는 역할, 자바와 오라클은 서로 다르고, 그래서 드라이브가 다리의 역할을 한다
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM member"; //쿼리 마지막에 세미콜론 사용X
			ps = con.prepareStatement(sql);
			
			//select
			rs = ps.executeQuery();
			
			//insert, update, delete // sql의 이벤트 3가지
			//int result = ps.executeUpdate();
			// 몇 행이 영향 받았는지를 리턴한다, 변경된 행이 없을시 0 반환
			
			while(rs.next()){
				//next()를 호출하면 조회된 결과 중 첫 번째 행을 바라본다
				//첫 번째 행에서 데이터 추출 -> 호출할 때마다 다음 행을 바라본다
				//더 이상 데이터를 반환할 수 없을 때 false 반환 후 while문 종료
				
				String memId = rs.getString(1);
				//varchar2, 문자열을 나타내는 데이터면 이걸로 받는다
				//조회할 컬럼의 순서를 괄호 안에 넣어줄 수 있다
				
				String memPass = rs.getString("MEM_PASS");
				//컬럼명을 넘겨줄 수도 있다
				
//				rs.getInt(columnIndex)
//				rs.getDate(columnIndex)
				//상황과 타입에 맞게 알아서 선택해서 사용
				
				System.out.println("MEM_ID : " + memId + " / MEM_PASS : " + memPass);
				
				//실행이 끝났으니 객체 닫으러 가기 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //객체 닫기
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
	}

}
