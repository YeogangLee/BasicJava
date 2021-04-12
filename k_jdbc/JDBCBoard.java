package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class JDBCBoard {

	static int wcount; 
	public static void main(String[] args) {

		//오라클 데이터베이스에 생성한 게시판 테이블을 이용해 게시판 프로그램을 만들어주세요.
		/*
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * -------------------------------
		 * 번호	제목			작성자	작성일
		 * -------------------------------
		 * 1	안녕하세요		홍길동	7/23
		 * 1	안녕하세요		홍길동	7/23
		 * 1	안녕하세요		홍길동	7/23
		 * -------------------------------
		 *  1.조회	2.등록	3.종료
		 */
				
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		
		while(true){
			printLine();
			wcount = boardList();
			printLine();
			printLine();
			System.out.println("1.조회\t2.등록\t0.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				//조회 SELECT
				System.out.print("게시글 번호 입력>");
				int boardNo = ScanUtil.nextInt();
				if(boardNo > wcount){
					System.out.println("잘못된 번호입니다.");
					break;
				}
				//SELECT 클래스
				k_jdbc.JDBC_SELECT.main(boardNo);
				break;
				
			case 2:
				//등록 INSERT 클래스
				k_jdbc.JDBC_INSERT.main(wcount+1);
				break;
				
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
	
	//전체 글 목록 보여주기
	static int boardList(){
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "stu";
		String pass = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT * "
					+      "FROM TB_JDBC_BOARD"
					+ "	   ORDER BY BOARD_NO DESC";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();  
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			System.out.print(metaData.getColumnName(1) + "\t");
			for(int i = 2; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t\t");
			}
			System.out.println();
			printLine();
			
			while(rs.next()){
				for(int j = 1; j <= columnCount; j++){
					Object value = rs.getObject(j);
					System.out.print(value + "\t\t");
				}
				System.out.println();
				wcount++;
				//글 개수 세려고 1행 다 출력하면 wcount를 증가
				//그런데, 1행을 출력하면 wcount를 증가시키니까,
				//글 개수가 늘어난 게 아닌데 wcount 숫자가 증가된다.
				//조회를 1번 할 때는 괜찮지만, 조회를 2번 이상하면서부터 제대로 작동하지 않는 구조
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		if(wcount == 0) System.out.println("조회되는 행이 없습니다.");
		return wcount;
	}	
		
	static void printLine(){
		System.out.println("--------------------------------------------------------------------------------------");
	}
}
