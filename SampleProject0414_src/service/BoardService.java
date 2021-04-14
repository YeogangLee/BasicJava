package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;

public class BoardService {

	//싱글톤 패턴
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}

	private BoardDao boardDao = BoardDao.getInstance();
	
	//게시판 목록 출력 메서드
	public int boardList(){
		//데이터베이스에서 게시판 목록 가져오기 -> BoardDao 클래스 생성
		
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("====================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("------------------------------------");
		for(Map<String, Object> board : boardList){ //keySet() 어디갔지?
			System.out.println(board.get("BOARD_NO")
					+ "\t" + board.get("TITLE")
					+ "\t" + board.get("WRITER")
					+ "\t" + board.get("WDATE"));
		}
		System.out.println("====================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.println("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch(input){
		//조회
		case 1:
			selectBoard();
			break;
		//등록
		case 2:
			insertBoard();
			break;
		//로그아웃 - 가지고 있던 로그인 정보를 삭제 Cotroller에 있다
		case 0:
			Controller.loginUser = null;
			return View.HOME;
		}
		
		return View.BOARD_LIST;
	}
	
	//조회 메서드
	public int selectBoard(){
		System.out.println("조회할 글의 번호>");
		int boardNo = ScanUtil.nextInt();
		
		boardDao.selectBoard(boardNo);
		
		return View.BOARD_LIST;
	}
	
	//등록 메서드
	public int insertBoard(){
		System.out.println("[글 등록] ============================");
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		Map<String, Object> param = new HashMap<>();
		param.put("TITLE",title);
		param.put("CONTENT",content);
		param.put("WRITER",Controller.loginUser.get("USER_NAME"));
		
		int result = boardDao.insertBoard(param);
		
		if(0 < result){
			System.out.println("글이 등록되었습니다.");
		} else {
			System.out.println("글 등록에 실패했습니다.");
		}
		
		return View.BOARD_LIST;
	}
	
}
