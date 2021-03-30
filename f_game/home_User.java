package f_game;

import e_oop.ScanUtil;

public class home_User {
	
	int grade;
	int exp;
	int heart;
	int maxHeart;
	int lingot;
	int goal;
	//int streak;
	String name;
	String country;
	String joinDate;
	String rank;
	String[] languages;
	String[] sentences;
	home_User[] friends;
	
	//int streak, 
	home_User(int grade, int exp, int goal, int lingot, int heart, 
			String name, String country, String joinDate, String rank){
		
		this.grade = 1;
		this.exp = 0;
		this.goal = 50;
		this.lingot = 0;
		//this.streak = 0;
		this.maxHeart = heart;
		this.heart = this.maxHeart;		
		
		this.name = name;
		this.country = country;
		this.joinDate = joinDate;
		this.rank = rank;
		this.languages = new String[10];
		this.sentences = new String[10];
		this.friends = new home_User[10];
	}
	
	void showProfile() {
		System.out.println("======================================");
		System.out.println("[프로필]-------------------------------");
		System.out.println("이름 :\t" + name);
		System.out.println("거주지 :\t" + country);
		System.out.println("가입일 :\t" + joinDate);
		System.out.println("\n[학습 현황]-----------------------------");
		System.out.print("배우는 언어 : ");
		for (int i = 0; i < languages.length; i++) {
			int cnt = 0;
			if (languages[i] != null) {
				System.out.print(languages[i]);
				cnt++;
			}
			if(i == cnt-1){
				System.out.print(", ");
			}
		}
		//System.out.println("\n연속일 : " + streak);
		System.out.println("\n랭크 : " + rank);
		System.out.println("순위 : " + grade);
		System.out.println("XP : " + exp);
		System.out.println("오늘의 목표 XP : " + exp + "/" + goal);
		System.out.println("하트 수 : " + heart);
		System.out.println("보유 링곳 수 : " + lingot);
		System.out.println("공부한 언어 : ");
		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i] != null) {
				System.out.print(sentences[i] + " " + ", ");
			}
		}
		
		System.out.println("\n[친구 목록]-----------------------------");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.print(friends[i] + " ");
			}
		}
	}
	
	void answerTrue(){
		int newXP = 30;
		System.out.println("(정답) " + newXP + "XP 획득");
		this.exp += newXP;
		
//		if(this.goal < this.exp){
//			getLingot();
//		}
	}
	
	boolean answerFalse(int heart){
		this.heart--;
		int input=0;
		boolean flag = true;
		if(1 <= this.heart){
			System.out.println("-오답-\n남은 하트 수 : " + this.heart);
		} else {
			System.out.println("하트가 부족합니다");
			System.out.println("여기서 학습을 종료하시겠습니까?");
			System.out.println("1.예    2.아니오");
			System.out.println("(아니오를 누르면 링곳으로 하트를 충전합니다)");
			System.out.println(">");
			input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				break;
			case 2:
				flag = useLingot();
				break;
			default:
				break;
			}
		}
		return flag;
	}
		
	void getLingot(){
		int newLingot = (int)(Math.random() * 40) + 10;
		System.out.println("오늘의 목표 XP 달성!");		
		System.out.println(newLingot + "링곳을 받으세요");		
		this.lingot += newLingot;
	}
	
	boolean useLingot(){
		boolean flag;
		int buyHeart = 40;
		if(buyHeart < this.lingot){
			this.lingot -= buyHeart;
			this.heart = this.maxHeart;
			System.out.println("하트를 충전했습니다\n현재 하트 수: " + heart);
			flag = true;
		} else {
			System.out.println("하트를 구매하기 위한 링곳이 부족합니다");
			flag = false;
		}
		return flag;
	}
	
}
