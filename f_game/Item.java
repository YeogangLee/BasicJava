package f_game;

//문장
//한글, 영어
//1. 문장비교
//모국어 원래문장 스트링1, 학습언어 순서랜덤 배열1, 정답 문자열 1, 입력 문자열1 
//2. 단어 짝꿍
//3. 명사 성은 나중에 ..

public class Item {
	String name;
	int hp;
	int mp;
	int att;
	int def;
	
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
	}
	
	String itemInfo(){
		String info = name + " : ";
		if(0 < hp) info += " 체력+ " + hp;
		if(0 < mp) info += " 마나+ " + mp;
		if(0 < att) info += " 공격+ " + att;
		if(0 < def) info += " 방어+ " + def;
		return info;
	}
	
	
	
}
