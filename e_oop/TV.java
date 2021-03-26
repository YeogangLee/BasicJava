package e_oop;

public class TV {
	
	
	/*
	 * 과제. 임의의 사물을 대상으로 클래스를 만들어주세요.
	 * 사물이 가지고 있는 속성을 변수로 만들고,
	 * 변수와 관계된 동작들을 메서드로 만들어주시면 됩니다.
	 */

	boolean power; //전원
	int channel; //채널
	int volume; //음량
	
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	
	TV(){
		power = false;
		channel = 1;
		volume = 5;
	}
	
	void power(){
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}
	
	void changeChannel(int channel){
		if(power){
			if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL){
				this.channel = channel;
				if(this.channel >= 10){
					System.out.println("[  ch." + this.channel + "\t\t]");
				}else{
					System.out.println("[  ch." + this.channel + "\t\t\t]");
				}
			} 
			else {
				System.out.println("[  ch.xx\t\t]");
			}
		}
	}
	
	void showVolume(int volume){
		if(power){
			if(volume < MAX_VOLUME){
				volume++;
			}
			if(MIN_VOLUME < volume){
				volume--;
			}
			System.out.print("[  음량. ");
			for(int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++){
				if(i <= volume){
					System.out.print("●");
				}else{
					System.out.print("○");
				}
			}
			System.out.println("\t]");
		}
	}
	
	void showTVOff(){
		for(int i = 0; i < 4; i++){
			System.out.println("[=======================]");
		}		
	}
	
	public static void main(String[] args) {
		TV tv = new TV();		
		
		while(true){
			System.out.println("-------------------------------");
			System.out.println("1.전원  2.채널변경  3.채널업  4.채널다운");
			System.out.println("5.볼륨업  6.볼륨다운  0.종료");
			System.out.println("-------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: tv.power(); break;
				
			case 2:
				System.out.print("변경할 채널 입력>");
				tv.channel = ScanUtil.nextInt();
				break;
				
			case 3: tv.channel++; break;
			case 4: tv.channel--; break;
			case 5: tv.volume++; break;
			case 6: tv.volume--; break;
				
			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
			
			if(tv.power){
				System.out.println(" _______________________");
				tv.changeChannel(tv.channel);
				System.out.println("[\t\t\t]");
				tv.showVolume(tv.volume);
				System.out.println("[_______________________]");
			} else {
				tv.showTVOff();
			}
		}
	}	
}
