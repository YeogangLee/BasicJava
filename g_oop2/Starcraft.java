package g_oop2;

public class Starcraft {

	public static void main(String[] args) {
		
		Marine m = new Marine();
		Tank t = new Tank();
		Dropship d = new Dropship();
		SCV scv = new SCV();
		
//		scv.repair(m); 마린은 Repairable 을 상속받지 않았기 때문에 파라미터로 넘길 수가 없다.
		scv.repair(t);
		scv.repair(d);
		
		
	}

}

class Unit{
	int hp; //현재 체력
	final int MAX_HP; //최대 체력
	
	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}	
}

class Marine extends Unit{
	Marine(){
		super(40);
	}
}

class Tank extends Unit implements Repairable{
	Tank(){
		super(150);
	}
}

class Dropship extends Unit implements Repairable{
	Dropship(){
		super(125);
	}
}

class SCV extends Unit{
	SCV(){
		super(60);
	}
	
	//누구를 수리해야 할지 알아야겠죠 -> 수리대상을 파라미터로 받기
	//여기서 유닛은 마린, 탱크, 드롭쉽 그런데 마린은 기계가 아니다. (기계만 수리 가능)
	//Unit을 이용하면, 마린까지 상속받아서, 마린까지 수리해버리면 안 된다.
	//탱크, 드롭쉽, 둘만의 새로운 관계가 필요하다.
	void repair(Repairable r){
		//Repairable 에는 아무 내용이 없다
		//그래서 Unit을 상속받는다
		if(r instanceof Unit){ // 이 조건문이 없어도 실행은 된다 --> ???????????
			//instanceof 예약어 : 형변환 가능 확인 예약어, Repairable이 Unit으로 형변환이 가능한지
			//형변환이 불가능하면 false를 출력하고 조건문을 빠져나온다
			//instanceof 는 만약에 상속을 안 했을까봐, 일종의 안전장치 같은 것
			Unit u = (Unit)r;
			
			while(u.hp < u.MAX_HP){
				u.hp++;
			}
		}
	}
}

//새로운 관계를 만들 때 인터페이스 사용
//내용이 없는대로 놔둬도 괜찮다.
interface Repairable{
	
}

