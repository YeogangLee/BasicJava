package e_oop.restaurant;

public class Arbeit {
	//1. 주문받는 메서드
	//2. 서빙 메서드
	//3. 계산 메서드
	
	//메서드 : 알바가 할 일 (보스가 알바에게 시킨 일)
	//파라미터 : 일을 하기 위해 필요한 것 (보스가 알바에게 주는 것)
	//리턴타입 : 일을 하고 난 후 돌려주는 것(알바가 보스에게 주는 것)
	
	//주문받기 위해 필요한 것? X
	//주문받은 후 보스에게 줄 것? 주문 내용 -> 주문서
	String[] order(){
		System.out.println("주문하시겠습니까?");
		return new String[] {"짜장면", "탕수육"};
	}
	
	//서빙하기 위해 필요한 것? 음식
	//서빙 후 보스에게 줄 것? X
	void serving(String[] foods){
		System.out.println(foods[0] + " " + foods[1]);
		System.out.println("맛있게 드세요.");
	}
	
	//계산하기 위해 필요한 것? 계산서, 사장님 -> 알바
	//계산 후 보스에게 줄 것? X
	void pay(String[] order){
		System.out.println("2만원입니다. 안녕히 가세요.");
	}
	
}
