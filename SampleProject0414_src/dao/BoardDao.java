package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {

	//싱글톤 패턴
	private BoardDao (){}
	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//게시판 목록 조회 메서드, 아이디가 아니라 이름 출력을 위해 JOIN
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.WDATE"
					 + " FROM TB_JDBC_BOARD A"
					 + " LEFT OUTER JOIN TB_JDBC_USER B"
					   + " ON A.WRITER = B.USER_NAME"
					+ " ORDER BY A.BOARD_NO DESC"; //가장 최근 글이 위에 올라오도록 정렬
		
		return jdbc.selectList(sql);
	}
	
	public int insertBoard(Map<String, Object> param){
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "	  	   VALUES((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD), "
				+ "				  ?, ?, ?, SYSDATE)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("TITLE"));
		p.add(param.get("CONTENT"));
		p.add(param.get("WRITER"));
		
		return jdbc.update(sql, p);
	}
	
	public Map<String, Object> selectBoard(int boardNo){
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, WDATE"
				+ "     FROM TB_JDBC_BOARD"
				+ "    WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(boardNo);
		
		return jdbc.selectOne(sql, param);
	}
	
}
