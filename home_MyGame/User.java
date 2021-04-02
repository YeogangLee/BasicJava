package home_MyGame;

import e_oop.ScanUtil;

public class User {
	
	static boolean firstXP;
	int exp;
	int heart;
	int maxHeart;
	int lingot;
	int goal;
	int streak;
	String name;
	String country;
	String joinDate;
	String rank;
	String[] languages;
	String[] learned;
	
	User(int exp, int goal, int streak, int lingot, int heart, 
			String name, String country, String joinDate, String rank){
		
		this.exp = 0;
		this.goal = 50;
		this.lingot = 0;
		this.streak = 0;
		this.maxHeart = heart;
		this.heart = this.maxHeart;		
		
		this.name = name;
		this.country = country;
		this.joinDate = joinDate;
		this.rank = rank;
		this.languages = new String[10];
		this.learned = new String[10];
	}
	
	void showProfile() {
		System.out.println("==================================================");
		System.out.println("[프로필]-------------------------------------------");
		System.out.println("이름\t| " + name);
		System.out.println("거주지\t| " + country);
		System.out.println("가입일\t| " + joinDate);
		System.out.println("\n[학습 현황]-----------------------------------------");
		System.out.print("배우는 언어  | ");
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
		System.out.println("\n연속일\t | " + streak);
		System.out.println("랭크\t | " + rank);
		System.out.println("XP\t | " + exp);
		System.out.println("오늘 목표 XP| " + exp + "/" + goal);
		System.out.println("하트 수\t | " + heart);
		System.out.println("보유 링곳 수 | " + lingot);
		System.out.println("공부한 언어  | ");
		removeWordsArr();
		System.out.println();
	}
	
	private void removeWordsArr() {
		int cnt = 0;
		for (int i = 0; i < learned.length; i++) {
			if (learned[i] != null) {
				cnt++;
			}
		}
		
		int cntRmv = 0;
		String[] temp = new String[learned.length];
		for(int i = 0; i < cnt; i++){
			boolean flag = true;
			for(int j = 0; j < cnt; j++){
				if(learned[i].equals(temp[j])){
					flag = false;
				}
			}
			if(flag){
				temp[cntRmv++] = learned[i];
			}
		}

		String[] result = new String[cntRmv];
		for(int i = 0; i < cntRmv; i++){
			result[i] = temp[i];
			System.out.println((i+1)+". "+result[i]);
		}
	}

	void answerTrue(){
		int plusXP = 30;
		System.out.println("(정답) " + plusXP + "XP 획득");
		this.exp += plusXP;
		if(this.exp > 0 && firstXP == false) {
			this.streak++;
			firstXP = true;
		}
	}
	
	void answerFalse(int heart){
		this.heart--;
		if(this.heart < 0) this.heart = 0;
		System.out.println("-오답-\n남은 하트 수 : " + this.heart);
	}
	
	boolean noHeart(){
		System.out.println("하트가 부족합니다");
		System.out.println("여기서 학습을 종료하시겠습니까?");
		System.out.println("1.예    2.아니오");
		System.out.println("(아니오를 누르면 50 링곳으로 하트를 충전합니다)");
		System.out.println("(현재 보유 링곳 : " + this.lingot + ")");
		System.out.println(">");
		int input = ScanUtil.nextInt();
		boolean flag = false;
		switch(input) {
		case 1:
			return flag = true;
		case 2:
			useLingot();
			break;
		default:
			System.out.println("숫자를 잘못 입력했습니다.");
			break;
		}
		return false;
	}
		
	void getLingot(){
		int newLingot = (int)(Math.random() * 50) + 50;
		System.out.println("오늘의 목표 XP 달성!");		
		System.out.println(newLingot + "링곳을 받으세요");		
		this.lingot += newLingot;
	}
	
	void useLingot(){
		final int buyHeart = 50;
		if(buyHeart < this.lingot){
			this.lingot -= buyHeart;
			this.heart = this.maxHeart;
			System.out.println("하트를 충전했습니다\n현재 하트 수: " + heart);
		} else {
			System.out.println("하트를 구매하기 위한 링곳이 부족합니다");			
		}
	}
	
	void checkRank(){
		final int rankUnit = 50;
		if(this.exp < rankUnit*1){
			this.rank = "Bronze";
		} else if (this.exp < rankUnit*2) {
			this.rank = "Silver";
		} else if (this.exp < rankUnit*3) {
			this.rank = "Gold";
		} else {
			this.rank = "Diamond";
		}
		
	}
}