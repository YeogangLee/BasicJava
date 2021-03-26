package e_oop;

public class Waterbottle {
	/*
	 * 과제. 임의의 사물을 대상으로 클래스를 만들어주세요.
	 * 사물이 가지고 있는 속성을 변수로 만들고,
	 * 변수와 관계된 동작들을 메서드로 만들어주시면 됩니다.
	 */

	boolean cap; //뚜껑
	int capacity; //용량
	
	final int MIN_CAPACITY = 0;
	final int MAX_CAPACITY = 5;
	
	Waterbottle(){
		cap = false;
		capacity = 0;
	}
	
	void cover(){
		cap = !cap;
		System.out.println(cap ? "물병 뚜껑 열기" : "물병 뚜껑 닫기");
	}
		
	void waterPlus(){
		if(cap){
			if(capacity < MAX_CAPACITY){
				capacity++;
			} 
		} else {
			System.out.println("물병이 이미 가득 찼습니다");
		}
		waterShow();
	}
	
	void waterMinus(){
		if(cap){
			if(MIN_CAPACITY < capacity){
				capacity--;
			} 
		} else {
			System.out.println("물병이 이미 비어있습니다");
		}
		waterShow();
	}
		
	void upsideDown(){
		if(cap){
			System.out.println("뚜껑이 닫혀있습니다");
		} else if(0 < capacity) {
			System.out.println("물병에 물이 담겨 있습니다");
		} else {
			waterShow();
		}
	}
	
	void waterShow(){
		if(!cap){
			System.out.println("■■■■■");
		}
		for(int i = MIN_CAPACITY + 1; i <= MAX_CAPACITY; i++){
			if(i <= capacity){
				System.out.println("[■■■]");
			}else{
				System.out.println("[   ]");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Waterbottle bottle = new Waterbottle();
				
		while(true){
			System.out.println("-----------------------------------------");
			System.out.println("1.뚜껑  2.물 채우기  3.물 마시기 4.물병 뒤집기 0.종료");
			System.out.println("-----------------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: bottle.cover(); break;
			case 2: bottle.waterPlus(); break;
			case 3: bottle.waterMinus(); break;
			case 4: bottle.upsideDown(); break;
				
			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
			bottle.waterShow();
		}
	}

}
