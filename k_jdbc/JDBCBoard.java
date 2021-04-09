package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		//06:27
		
		
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
				k_jdbc.JDBC_SELECT.main(boardNo);
				break;
				
			case 2:
				//등록 INSERT
				k_jdbc.JDBC_INSERT.main(wcount+1);
//				wcount++;
				break;
				
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
		
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


			while(rs.next()){
				for(int j = 1; j <= columnCount; j++){
					Object value = rs.getObject(j);
					System.out.print(value + "\t\t");
				}
				System.out.println();
				wcount++;
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
		
		/*
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		//조회 SELECT
		static void read(ArrayList<HashMap<String, Object>> boardList){
			System.out.print("게시글 번호 입력>");
			int boardNo = ScanUtil.nextInt();
			
			HashMap<String, Object> board = null;
			for(int i = 0; i < boardList.size(); i++){
				if((Integer)boardList.get(i).get("board_no") == boardNo){
					board = boardList.get(i);
					break;
				}
			}
			
			System.out.println("--------------------------");
			System.out.println("번호\t: " + board.get("board_no"));
			System.out.println("작성자\t: " + board.get("user"));
			System.out.println("작성일\t: " + board.get("reg_date"));
			System.out.println("제목\t: " + board.get("title"));
			System.out.println("내용\t: " + board.get("content"));
			System.out.println("--------------------------");
			System.out.println("1.수정\t2.삭제\t0.목록");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				//수정 UPDATE
				update(board);
				break;
				
			case 2:
				//삭제 DELETE
				delete(boardList, board);
				break;
				
			case 0:
				break;
			}
		}
		
		//수정 UPDATE
		static void update(HashMap<String, Object> board){
			System.out.print("제목>");
			String title = ScanUtil.nextLine();
			System.out.print("내용>");
			String content = ScanUtil.nextLine();
			
			board.put("title", title);
			board.put("content", content);
			
			System.out.println("수정이 완료되었습니다.");
		}
		
		//삭제 DELETE
		static void delete(ArrayList<HashMap<String, Object>> boardList, HashMap<String, Object> board){
			for(int i = 0; i < boardList.size(); i++){
				if(boardList.get(i).get("board_no") == board.get("board_no")){
					boardList.remove(i);
					System.out.println("삭제가 완료되었습니다.");
					break;
				}
			}
		}

		//등록 INSERT
		static void insert(ArrayList<HashMap<String, Object>> boardList){
			System.out.print("제목>");
			String title = ScanUtil.nextLine();
			System.out.print("내용>");
			String content = ScanUtil.nextLine();
			System.out.print("이름>");
			String user = ScanUtil.nextLine();
			
			int maxBoardNo = 0;
			for(int i = 0; i < boardList.size(); i++){
				int boardNo = (Integer)boardList.get(i).get("board_no");
				if(maxBoardNo < boardNo){
					maxBoardNo = boardNo;
				}
			}
			
			HashMap<String, Object> temp = new HashMap<>();
			temp.put("board_no", maxBoardNo + 1);
			temp.put("title", title);
			temp.put("content", content);
			temp.put("user", user);
			temp.put("reg_date", new Date());
			
			boardList.add(temp);
			System.out.println("게시물 등록이 완료되었습니다.");
			*/

	static void printLine(){
		System.out.println("----------------------------------------------------------------------------------");
	}
}
