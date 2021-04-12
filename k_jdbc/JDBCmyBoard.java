package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import e_oop.ScanUtil;

public class JDBCmyBoard {
	
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
		
		new JDBCmyBoard().start();
		
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "stu";
	String pass = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	
//	static int[] boardNum;
	
	void start(){
		while(true){
			printLine();
			boardList();
			printLine();
			printLine();
			countBoard();
			checkBoardNum();
			
			
			System.out.println("1.조회\t2.등록\t0.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				//조회
				selectBoard();
				break;
				
			case 2:
				//등록
				insertBoard();
				break;
				
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
	
	//전체 글 개수 가져오기
	void countBoard(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT COUNT(*) "
					+      "FROM TB_JDBC_BOARD";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();  
			
			while(rs.next()){
				int count = rs.getInt(1);
				System.out.println("글 개수 : " + count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	//글 번호 가져오기 메서드
	//오류
	void checkBoardNum(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT BOARD_NO "
					+      "FROM TB_JDBC_BOARD";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int i = 0;
			int[] boardNum = {0};
			while(rs.next()){
				//글 번호만 출력
				System.out.println("[0] = " + boardNum[0]);
				boardNum[i++] = rs.getInt(1);
				//좌측에는 늘 변수만 들어갈 수 있다
				//그래서 오류나는 듯
				System.out.print(boardNum[i] + ", ");
			}
			System.out.print("글 번호 : ");
			for(int j = 0; j < boardNum.length; j++){
				System.out.print(boardNum[j]+" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	//전체 글 목록 보여주기
	void boardList(){
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT * "
					+      "FROM TB_JDBC_BOARD"
					+ "	   ORDER BY BOARD_NO DESC";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();  
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			//컬럼명 출력
			System.out.print(metaData.getColumnName(1) + "\t");
			for(int i = 2; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t\t");
			}
			System.out.println();
			printLine();
			
			//행 단위로 가져와서 컬럼 출력
			while(rs.next()){
				for(int j = 1; j <= columnCount - 1; j++){
					Object value = rs.getObject(j);
					System.out.print(value + "\t\t");
				}
				//WDATE가 for문 안에서 출력되지 않아서, 이렇게 따로 출력
				java.util.Date date = rs.getDate("WDATE");
				String regDate = format.format(date);
				System.out.println(regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	//글 등록
	void insertBoard() {
				
		//java.util.Date date = new java.util.Date(); 
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO TB_JDBC_BOARD"
					+ "	  	   VALUES((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD), "
					+ "				  ?, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			
			System.out.print("제목>");
			String title = ScanUtil.nextLine();
			ps.setString(1, title);
			System.out.print("내용>");
			String content = ScanUtil.nextLine();
			ps.setString(2, content);
			System.out.print("이름>");
			String writer = ScanUtil.nextLine();
			ps.setString(3, writer);
			//ps.setDate(4, new Date(date.getTime()));
			int result = ps.executeUpdate();
			System.out.println(result + "개의 행이 영향을 받았습니다.");
			System.out.println(result + "개의 행이 성공적으로 삽입되었습니다.");
			//countBoard++; //변수가 0에서 시작하므로, 글이 이미 등록되어 있는 상태에서는 오류
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	//글 조회
	void selectBoard() {
		
		System.out.print("게시글 번호 입력>");
		int boardNo = ScanUtil.nextInt();
		//글 번호가 아닌 다른 숫자를 입력했을 때
//		if(boardNo > countBoard){
//			System.out.println("잘못된 번호입니다.");
//		}
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT *"
					+ "     FROM TB_JDBC_BOARD"
					+ "    WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			
			//ctrl 1 : Assign statement to new local variable
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i <= columnCount - 1; i++){
					Object object = rs.getObject(i);
					if(i == 1) { //tab 해주기 싫어서 조건문으로 따로 빼서 출력
						System.out.print(metaData.getColumnName(i) + "| "); // 컬럼이름
						System.out.println(object);					        // 컬럼값
						continue;
					}
					System.out.print(metaData.getColumnName(i) + "\t| "); // 컬럼이름
					System.out.println(object);					          // 컬럼값
				}
				//sql의 Date 클래스와 헷갈리지 않게 하기 위해
				//일부러 여기 java.util.Date 작성
				java.util.Date date = rs.getDate("WDATE");
				String regDate = format.format(date);
				System.out.print(metaData.getColumnName(columnCount) + "\t| ");
				System.out.println(regDate);
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
			updateBoard(boardNo);
			break;
			
		case 2:
			//삭제 DELETE 클래스
			deleteBoard(boardNo);
			break;
			
		case 0:
			break;
		}
	}
	
	//글 수정
	void updateBoard(int BOARD_NO) {

		try {
			con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("수정할 항목>");
			System.out.println("1.제목\t2.내용\t0.목록");
			int numM = ScanUtil.nextInt();
			
			switch (numM) {
			case 1:
				String sql = "UPDATE TB_JDBC_BOARD "
						+ "      SET TITLE = ?"
						+ "    WHERE BOARD_NO = ?";
				ps = con.prepareStatement(sql);
				
				System.out.println("변경할 제목 입력>");
				String title = ScanUtil.nextLine();
				ps.setString(1, title);
				
				ps.setInt(2, BOARD_NO);
				System.out.println("제목이 정상적으로 변경되었습니다.");
				break;
				
			case 2:
				sql = "UPDATE TB_JDBC_BOARD "
						+ "      SET CONTENT = ?"
						+ "    WHERE BOARD_NO = ?";
				ps = con.prepareStatement(sql);
				
				System.out.println("변경할 내용 입력>");
				String content = ScanUtil.nextLine();
				ps.setString(1, content);
				
				ps.setInt(2, BOARD_NO);
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
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}	
	
	//글 삭제
	void deleteBoard(int BOARD_NO) {
		
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

	void printLine(){
		System.out.println("---------------------------------------------------------------------------");
	}
}
