package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 소감(ppt에도 각 인원마다 1줄씩 넣어주길)
		 * 발표인원 : 발표자 1명, ppt 및 시연도우미 1명
		 * 발표시간 : 15분 내외
		 * 
		 * Controller : 화면 이동 - 넘겨주는 역할만 하고
		 * Service : 화면 기능 - 실제 기능
		 * Dao : 쿼리 작성 - 게시판 이용 (Data Access Object)
		 * 
		 * 오늘 할 일 : 회원가입, 로그인, 게시판 목록 출력
		 */
		
		new Controller().start();		
	}
	
	//로그인한 회원을 기억해두기 위해
	//원래 web에서는 세션에 저장해두는데 자바에는 세션 공간이 없으니, 새로운 공간 생성
	public static Map<String, Object> loginUser;
	
	//UserService 사용을 위한 전역변수 - join() 메서드 사용을 위해
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();

	
	//화면 이동 기능
	private void start() {
		//이 화면이 어떤 화면인지를 구분할 수 있어야 한다.
		//가장 쉬운 방법은 숫자 붙이기 - ex.3번 화면  but 3번이 무엇을 의미?
		//그래서 상수를 만들것 - util의 View 클래스 생성
		
		int view = View.HOME; // 가장 먼저 시작하면 home화면일거라 home값으로 초기화
		
		while(true){
			switch(view){
			case View.HOME : view = home(); break;
			case View.LOGIN : view = userService.login(); break;
			case View.JOIN : view = userService.join(); break;
			case View.BOARD_LIST : view = boardService.boardList(); break;
			}
		}
	}

	private int home() {
		//int 리턴 = 다음 화면 리턴
		//모든 화면은 호출 후 리턴값이 있어야 한다
		
		System.out.println("[홈 화면] ----------------------------");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("------------------------------------");
		System.out.println("번호 입력>");
		
		int input = ScanUtil.nextInt();
		
		switch (input){
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0: 
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		return View.HOME;
	}

}




