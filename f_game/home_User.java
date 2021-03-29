package f_game;

public class home_User {
	
	int grade;
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
	String[] sentences;
	home_User[] friends;
	
	home_User(int grade, int exp, int goal, int lingot, int streak, int maxHeart, int heart, 
			String name, String country, String joinDate, String rank){
		
		this.grade = 1;
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
		System.out.println("\n랭크 : " + rank);
		System.out.println("순위 : " + grade);
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
	
	//필요한 정보 : 공격 대상 = 몬스터 
	void attack(Monster m){
				
	}
	
	//몬스터 사냥 후 우리가 얻게 될 것 : 1. 경험치, 2. 아이템
	void getExp(int exp){
		
	}
	
	void levelUp(){
		
	}
	
	void getItem(Item item){
		
	}
}
