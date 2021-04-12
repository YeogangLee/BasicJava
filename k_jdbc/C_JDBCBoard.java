package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import e_oop.ScanUtil;

public class C_JDBCBoard {

	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
		 * 테이블 : TB_JDBC_BOARD
		 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 */
		
		new C_JDBCBoard().start();
		//JDBC 사용을 위한 데이터베이스 정보를
		//클래스 내의 각 메소드마다 중복해서 작성하지 않기 위해,
		//main에서 실행되던 코드를 start라는 메소드를 만들어 일부 옮기고
		//데이터베이스 정보는 밑처럼 전역변수로 선언한다
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "stu";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
	
	private void start() {
		while(true){
			try {
				con = DriverManager.getConnection(url, user, password);
				
							//컬럼명은 일일이 적어주는 게 좋다, * 사용 => 실행 속도 느려짐
				String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, WDATE FROM TB_JDBC_BOARD";
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				System.out.println("-----------------------------------");
				System.out.println("번호\t제목\t작성자\t작성일");
				System.out.println("-----------------------------------");
				while(rs.next()){
					java.util.Date date = rs.getDate("WDATE");
					String regDate = format.format(date);
					
					System.out.println(rs.getInt("board_no") + "\t"
							+ rs.getString("title") + "\t"
							+ rs.getString("WRITER") + "\t"
							+ regDate);
				}
				System.out.println("-----------------------------------");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			System.out.println("1.조회\t2.등록\t0.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1://조회
				selectBoard();
				break;
				
			case 2://등록
				insertBoard();
				break;
				
			case 0://종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}

	private void selectBoard() {
		System.out.print("조회할 게시물 번호>");
		int input = ScanUtil.nextInt();
		int boardNo = 0;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, WDATE"
					+ " FROM TB_JDBC_BOARD"
					+ " WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, input);
			
			rs = ps.executeQuery();
			
			//while문이 아닌 if문도 괜찮을 듯 보인다
			while(rs.next()){
				boardNo = rs.getInt("board_no");
				System.out.println("번호\t: " + rs.getInt("board_no"));
				System.out.println("작성자\t: " + rs.getString("writer"));
				System.out.println("작성일\t: " + rs.getDate("wdate"));
				System.out.println("제목\t: " + rs.getString("title"));
				System.out.println("내용\t: " + rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		System.out.println("1.수정\t2.삭제\t0.목록");
		System.out.print("입력>");
		input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //수정
			updateBoard(boardNo);
			break;
		case 2: //삭제
			deleteBoard(boardNo);
			break;
		}
	}

	private void updateBoard(int boardNo) {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "UPDATE TB_JDBC_BOARD"
					+ " SET TITLE = ?"
					+ " , CONTENT = ?"
					+ " WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, boardNo);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("수정이 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}

	private void deleteBoard(int boardNo) {
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE FROM TB_JDBC_BOARD"
					+ " WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("삭제가 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}

	private void insertBoard() {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("작성자>");
		String user = ScanUtil.nextLine();
		
		try {
			con = DriverManager.getConnection(url, this.user, password);
			
			String sql = "INSERT INTO TB_JDBC_BOARD VALUES("
					// 글번호는 쿼리로 생성, 번호의 맥스값을 찾은 후 + 1 한 것
					+ "(SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
					//GROUP BY 없이 MAX() 함수를 써도 괜찮은 것은,
					//SELECT 절에 MAX() 외에 다른 컬럼이 함께 선택되지 않아서,
					//이 자체로 GROUP으로 묶여 쓰인다 ex.SUM도 마찬가지로 단독으로 사용 가능
					+ ",?,?,?,SYSDATE)"; //날짜는 현재 날짜
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, user);
			
			int result = ps.executeUpdate();
			if(0 < result){
				System.out.println("등록이 완료되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}

}








