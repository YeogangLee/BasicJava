package g_oop2;

public class Store {

	public static void main(String[] args) {
		Desktop d1 = new Desktop("삼성 컴퓨터", 100000);
		Desktop d2 = new Desktop("LG 컴퓨터", 100000);
		
		AirCon ac1 = new AirCon("삼성 에어컨", 200000);
		AirCon ac2 = new AirCon("LG 에어컨", 200000);
		
		TV tv1 = new TV("삼성 TV", 300000);
		TV tv2 = new TV("LG TV", 300000);
		
		Customer c = new Customer();
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		c.buy(d2);
		c.buy(ac2);
		c.buy(tv1);
		// c.buy((Product)tv1); 이렇게 형변환 되어 있는 상태
		// 이렇게 사용하는 게 다형성
		// 다형성은 자주 사용되는 개념이기 때문에, 반드시 알아둬야 한다
		
		
		
		
	}

}

class Product{
	String name; //이름
	int price;	 //가격
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	String getInfo(){
	    return name + "(" + price + "원)";
	}	
}

class Desktop extends Product{
	Desktop(String name, int price){
		super(name, price);
	}
	
	void programming(){
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(String name, int price){
		super(name, price);
	}
	
	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV(String name, int price){
		super(name, price);
	}
	
	void setChannel(){
		System.out.println("채널을 변경합니다.");
	}
}

class Customer{
	int money = 100000000;
	// 다형성의 사용 이유 : 부모를 Product로 설정하면 데스크탑, 티비 등등 다양하게 담을 수 있다.
	
	Product[] item = new Product[100];
	
	void buy(Product p){
		if(money < p.price){
			System.out.println("잔돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		for(int i = 0; i < item.length; i++){
			if(item[i] == null){
				item[i] = p;
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매했다.");
	}

}















