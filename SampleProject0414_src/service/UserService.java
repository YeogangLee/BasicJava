package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.UserDao;

public class UserService {

	//적절히 나눠줄 필요가 있다 - 기준은 알아서 적당히
	//user 관련 화면, 게시판 관련 화면 .. 선생님은 이렇게 나누려는 것
	
	//싱글톤 패턴
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	
	//회원가입 메서드
	public int join(){
		System.out.println("[회원가입] ===========================");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.print("이름>");
		String userName = ScanUtil.nextLine();
		//아이디 중복 확인 생략
		//비밀번호 확인 생략
		//정규표현식(유효성 검사) 생략
		//지금은 생략하고, 나중에 만들 때 추가로 만들어주세요.
		
		//입력받은 자료 데이터베이스에 저장 -> dao
		//UserDao 클래스 생성
		
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		int result = userDao.insertUser(param); //1줄이 영향을 받았다면 성공
		
		if(0 < result){
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
	}
	
	//로그인
	public int login(){
		System.out.println("[로그인 화면] =========================");
		System.out.println("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
		
		//입력 받은 후 -> 이런 회원이 있나, 두 데이터 다 일치하는 회원을 찾기 -> dao에도 이런 데이터를 만들어줘야 비교 가능
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력했습니다.");
		} else {
			System.out.println("로그인 성공");
			//로그인을 성공하면 거기서 끝나는 게 아니라, 이 회원을 기억하고 있는 것이고 이를 위해 접속한 회원 정보를 어딘가에 저장해둬야 한다.
			//저장할 공간 -> Controller 클래스에 변수 생성
			Controller.loginUser = user;
			
			//로그인 이후에는 회원가입 창 보여주지 않아도 된다.
			return View.BOARD_LIST;
		}
		
		
		return View.LOGIN;
	}
}
