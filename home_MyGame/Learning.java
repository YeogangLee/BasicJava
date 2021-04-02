package home_MyGame;

import e_oop.ScanUtil;

public class Learning {
	
	static boolean flagFirst = false;
	static int learnedLang = 0;
	User user;
	Quiz[] quizzes;
	Quiz quiz;
		
	Learning(){
		user = new User(0, 50, 0, 0, 5, "나", "대한민국", "2019/11/19", "Bronze");
		
		user.languages[0] = "영어";
		user.languages[1] = "독일어";
				
		this.quizzes = new Quiz[5];
		quizzes[0] = new Quiz("Sail", "항해", "Sail", "항구", "관찰", "항해", 2);
		quizzes[1] = new Quiz("the pen", "der Stift", "the pen", "der Fernseher", "der Stift", "der Fernsehen", 1);
		quizzes[2] = new Quiz("We are of the same age.", "우리 동갑이에요.", "We are of the same age.", "우리 동갑이에요.", "그는 동갑이야.", "그녀는 동갑이다.", 0);
		quizzes[3] = new Quiz("Es ____ im Januar.", "Es schneit im Januar.", "It snows in January.", "schneit", "schneet", "schniet", 0);
	}
	
	public static void main(String[] args) {
		int[] usersScore = new int[5];
		String[] users = {"Andrea", "원경", "Kevin", "Miky", "Oscar"};
		for(int i = 0; i < usersScore.length; i++){
			usersScore[i] = (int)(Math.random()*230);
		}
		
		new Learning().start(usersScore, users);
	}
	
	private void start(int[] usersScore, String[] users){
		int input = 0;
		
		
		while(true){
			System.out.println("[듀오링고 : 외국어 학습 앱] ============================");
			System.out.println("--------------------------------------------------");
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
				showRank(usersScore, users);
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
	
	void showRank(int[] usersScore, String[] users){
		//배열 내림차순 선택 정렬
		for(int i = 0; i < usersScore.length-1; i++){
			int min = i;
			for(int j = i+1; j < usersScore.length; j++){
				if(usersScore[j] > usersScore[min]){
					min = j;
				}
			}
			int temp = usersScore[i];
			usersScore[i] = usersScore[min];
			usersScore[min] = temp;
			
			String temp2 = users[i];
			users[i] = users[min];
			users[min] = temp2;
		}
		
		System.out.println("[현재 랭크] =========================================");
		boolean[] flag = new boolean[4];
		boolean[] flagUser = {false, false, false, false};
		for (int i = 0; i < usersScore.length; i++) {
			final int rankUnit = 50;
			if (usersScore[i] > rankUnit * 3 || user.exp > rankUnit * 3) {
				if (flag[0] == false) {
					System.out.println("------------------- [Diamond] --------------------");
					flag[0] = true;
				}
				if (usersScore[i] > rankUnit * 3)
					System.out.println(users[i] + "\t| " + usersScore[i]);
				if (userRank(rankUnit) == 1 && flagUser[0] == false) {
					System.out.println(user.name + "\t| " + user.exp);
					flagUser[0] = true;
				}

			} else if (usersScore[i] > rankUnit * 2 || user.exp > rankUnit * 2) {
				if (flag[1] == false) {
					System.out.println("--------------------- [Gold] ---------------------");
					flag[1] = true;
				}
				if (usersScore[i] > rankUnit * 2)
					System.out.println(users[i] + "\t| " + usersScore[i]);
				if (userRank(rankUnit) == 2 && flagUser[1] == false) {
					System.out.println(user.name + "\t| " + user.exp);
					flagUser[1] = true;
				}

			} else if (usersScore[i] > rankUnit * 1 || user.exp > rankUnit * 1) {
				if (flag[2] == false) {
					System.out.println("-------------------- [Silver] --------------------");
					flag[2] = true;
				}
				if (usersScore[i] > rankUnit * 1)
					System.out.println(users[i] + "\t| " + usersScore[i]);
				if (userRank(rankUnit) == 3 && flagUser[2] == false) {
					System.out.println(user.name + "\t| " + user.exp);
					flagUser[2] = true;
				}

			} else {
				if (flag[3] == false) {
					System.out.println("-------------------- [Bronze] --------------------");
					flag[3] = true;
				}
				if (usersScore[i] <= rankUnit * 1)
					System.out.println(users[i] + "\t| " + usersScore[i]);
				if (userRank(rankUnit) == 0 && flagUser[3] == false) {System.out.println(user.name + "\t| " + user.exp); flagUser[3] = true;}
			}
			
			if (flag[3] == false && usersScore[i] <= rankUnit * 1) {
				System.out.println("-------------------- [Bronze] --------------------");
				flag[3] = true;
				System.out.println(users[i] + "\t| " + usersScore[i]);
			}
		}
		System.out.println();
	}
	
	int userRank(int rankUnit){
		if(user.exp > rankUnit*3) return 1;
		else if(user.exp > rankUnit*2) return 2;
		else if(user.exp > rankUnit*1) return 3;
		else return 0;
	}
}
