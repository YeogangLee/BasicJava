package f_game;

public class Monster {
	String name;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int att;
	int def;	
	Item[] items;
	
	Monster(String name, int hp, int mp, int att, int def, Item[] items){
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.items = items;
	}
	
	//몬스터는 캐릭터를 공격 -> 파라미터를 사람으로
	//m에서 c로 변경 단축키 : Ctrl + 1
	void attack(Character c){
		int damage = att - c.def;
		damage = damage <= 0 ? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "가 공격으로 " + c.name + "에게" + damage + "만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 남은 HP : " + c.hp);		
	}
	
	//아이템 드롭 -> 리턴 타입은 아이템
	Item itemDrop(){
		return items[(int)(Math.random() * items.length)];
	}
	//몬스터가 가지고 있는 아이템 중 하나를, 인덱스 하나를 골라 반환 
	
	
	
}
