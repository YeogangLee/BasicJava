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
	home_Quiz quiz;
		
	home_Learning(){
		user = new home_User(1, 0, 50, 0, 5, "듀오", "대한민국", "2019/11/19", "Diamond");
		
		user.languages[0] = "영어";
		user.languages[1] = "독일어";
				
		this.quizzes = new home_Quiz[5];
		quizzes[0] = new home_Quiz("Es ____ im Januar.", "Es schneit im Januar.", "It snows in January.", "schneit", "schneet", "schniet", 0);
		quizzes[1] = new home_Quiz("Sail", "항해", "Sail 항해", "항구", "관찰", "항해", 2);
		quizzes[2] = new home_Quiz("the pen", "der Stift", "pen : der Stift", "der Fernseher", "der Stift", "der Fernsehen", 1);
		quizzes[3] = new home_Quiz("We are of the same age.", "우리 동갑이에요.", "We are of the same age.\n우리는 동갑이에요.", "우리 동갑이에요.", "그 동갑이야.", "그녀 동갑이다.", 0);
		
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
		int count = 0;
		language : while(true){
			for (int i = 0; i < user.languages.length; i++) {
				if (user.languages[i] != null) {
					System.out.print((i+1) + "." + user.languages[i] + "  ");
				}
			}
			System.out.println("0. 이전으로");
			
			int input = ScanUtil.nextInt();
			count = showQuiz(input, count);
			System.out.println("다음 문제로");
			System.out.println("1.예\t 2.아니오");
			input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				count = showQuiz(input, count);
				break;
			case 2:
				break language;
			default:
				break language;
			}
		}
	}
	
	private void learnEng() {
		
		for(int i = 0; i < quizzes.length && quizzes[i] != null; i++){
			System.out.print("문제"+(i+1)+". ");
			quiz = quizzes[i];
			int answer = quiz.showQuiz();
			System.out.print(">");
			int input = ScanUtil.nextInt();
			if((answer+1) == input){
				user.answerTrue();
				quiz.showMeaning();
			} else {
				user.answerFalse(user.heart);
				quiz.showAnswer();
			}
		}		
		
	}
	
	private void learnGer() {
		int country=0;
		int input;
		int count = 0;
		do{
			showQuiz(country, count);
			System.out.println("다음 문제로");
			System.out.println("1.예\t 2.아니오");
			input = ScanUtil.nextInt();
			count++;
		}while(input != 2);
		
	}	
	
	int showQuiz(int country, int count){
		//this.count = count;
		if(count < quizzes.length){
			//홀수문제 영어, 짝수문제 독일어
			int index = country + count*2;
			System.out.print("문제"+(count+1)+". ");
			quiz = quizzes[index];
			int answer = quiz.showQuiz();
			System.out.print(">");
			int input = ScanUtil.nextInt();
			if((answer+1) == input){
				user.answerTrue();
				quiz.showMeaning();
			} else {
				boolean flag = false;
				flag = user.answerFalse(user.heart);
				if(flag)quiz.showAnswer();
			}
			return count++;
		} else {
			System.out.println("문제를 다 풀었습니다");
			return count;
		}
	}

	void showRank(){
		
	}
	
	
//	String friendsInfo(){
//		return info;
//	}
	
	
	
}
