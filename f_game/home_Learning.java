package f_game;

import e_oop.ScanUtil;

//문장
//한글, 영어
//1. 문장비교
//모국어 원래문장 스트링1, 학습언어 순서랜덤 배열1, 정답 문자열 1, 입력 문자열1 
//2. 단어 짝꿍
//3. 명사 성은 나중에 ..
//4. 학습 주제별 

public class home_Learning {
	
	home_User user;
	home_Quiz[] quizzes;
	
	home_Learning(){
		user = new home_User(1, 0, 50, 0, 0, 5, 0, "듀오", "대한민국", "2019/11/21", "Diamond");
		
		user.languages[0] = "영어";
		user.languages[1] = "독일어";
				
		this.quizzes = new home_Quiz[5];		
		quizzes[0] = new home_Quiz("Es ____ im Januar.", "It snows in January.", "schneit", "schneet", "schniet", 0);
	}
	
	public static void main(String[] args) {
		new home_Learning().start(); //컴파일에러 빨간줄 ctrl + 1 -> 자동 메서드 생성
	}
	
	private void start() {
		int input = 0;
		while(true){
			System.out.println("======================================");
			System.out.println("1.내 정보    2.언어 학습하기    3.순위 보기    0.종료");
			input = ScanUtil.nextInt();
			
			switch(input){
			case 1:
				user.showProfile();
				break;
			case 2:
				selectLanguage();
				break;
			case 3:
				showRank();
				break;
			case 0:
				System.out.println("학습 종료");
				System.exit(0);
				break;
			}
		}
	}
	
	void selectLanguage(){
		
		int input = 0;
		language : while(true){
			for (int i = 0; i < user.languages.length; i++) {
				if (user.languages[i] != null) {
					System.out.print((i+1) + "." + user.languages[i] + "  ");
				}
			}
			System.out.println("0. 이전으로");
			
			input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				learnEng();
				break;
			case 2:
				learnGer();
				break language;
			default:
				break language;
			}
		}
		
	}
	
	private void learnEng() {
		System.out.println("영어");
		
	}
	
	private void learnGer() {
		System.out.println("독일어");
		//int answer = home_Quiz.showQuiz();
		
	}	

	void showRank(){
		
	}
	
	
//	String friendsInfo(){
//		return info;
//	}
	
	
	
}
