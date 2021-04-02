package f_game;

import e_oop.ScanUtil;

//랭크변경x
//공부한 언어 중복 문제
//3. 순위보기
//한국어영어 문제 검열


public class home_Learning {
	
	static boolean flagFirst = false;
	static int learnedLang = 0;
	home_User user;
	home_Quiz[] quizzes;
	home_Quiz quiz;
		
	home_Learning(){
		user = new home_User(0, 50, 0, 0, 5, "듀오", "대한민국", "2019/11/19", "Bronze");
		
		user.languages[0] = "영어";
		user.languages[1] = "독일어";
				
		this.quizzes = new home_Quiz[5];
		quizzes[0] = new home_Quiz("Sail", "항해", "Sail", "항구", "관찰", "항해", 2);
		quizzes[1] = new home_Quiz("the pen", "der Stift", "the pen", "der Fernseher", "der Stift", "der Fernsehen", 1);
		quizzes[2] = new home_Quiz("We are of the same age.", "우리 동갑이에요.", "We are of the same age.", "우리 동갑이에요.", "그 동갑이야.", "그녀 동갑이다.", 0);
		quizzes[3] = new home_Quiz("Es ____ im Januar.", "Es schneit im Januar.", "It snows in January.", "schneit", "schneet", "schniet", 0);
	}
	
	public static void main(String[] args) {
		new home_Learning().start();
	}
	
	private void start() {
		int input = 0;
		
		while(true){
			System.out.println("==================================================");
			System.out.println("1.내 정보        2.언어 학습하기        3.순위 보기        0.종료");
			input = ScanUtil.nextInt();
			
			switch(input){
			case 1:
				user.showProfile();
				break;
			case 2:
				if(user.heart != 0) {
					showQuizzes();
				} else {
					boolean flagDummy = user.noHeart();
				}
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
	
	int selectLanguage(){
		for (int i = 0; i < user.languages.length; i++) {
			if (user.languages[i] != null) {
				System.out.print((i+1) + "." + user.languages[i] + "    ");
			}
		}
		System.out.println("0.이전으로");
		int input = ScanUtil.nextInt();
		return input-1;
	}	
	
	void showQuizzes() {
		int country = selectLanguage();
		if(country == -1) return; //'이전으로' 선택시 메서드 종료
		int index = 0;
		int count = 0;
		boolean flagStop = false;
		while (true) {
			if (index < quizzes.length && quizzes[index] != null) {
				// 짝수 인덱스 - 영어 문제, 홀수 인덱스 - 독일어 문제
				if (index % 2 == country) {
					count++;
					System.out.println("[문제" + (count) + "] ");
					quiz = quizzes[index];
					int answer = quiz.showQuiz();
					System.out.print(">");
					int input = ScanUtil.nextInt();
					//정답
					if ((answer + 1) == input) {
						user.answerTrue();
						quiz.showMeaning();
						user.learned[learnedLang++] = "[" + quiz.meanSent + " / " + quiz.baseSent + "]";
					} else { //오답
						user.answerFalse(user.heart);
						quiz.showAnswer();
						if(user.heart <= 0) flagStop = user.noHeart();
						if(flagStop == true) break;
					}
				} 
			} else {
				System.out.println("== 문제를 다 풀었습니다. ==");
				if(user.goal < user.exp && flagFirst == false){
					user.getLingot();
					flagFirst = true;
				}
				user.checkRank();
				break;
			}	
			index++;
		}//while문 끝
	}
	
	void showRank(){
		int[] usersRank = new int[5]; 
		String[] users = {""};
		System.out.println("==================================================");
		System.out.println("[현재 랭크]-----------------------------------------");
		System.out.println("==================================================");
		System.out.println("[Diamond]-----------------------------------------");
		
		System.out.println("[Gold]--------------------------------------------");
		
		System.out.println("[Silver]------------------------------------------");
		
		System.out.println("[Bronze]------------------------------------------");
		
//		System.out.println("이름\t| " + name);
//		System.out.println("거주지\t| " + country);
		
	}
	
}
