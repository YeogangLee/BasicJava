package g_oop2.test;

public class Time {

	//시, 분, 초
	private int hour;
	private int minute;
	private int second;
	
	String getTime(){
		return hour + ":" + minute + ":" + second;
	}
	
	//1초마다 증가되는 1초를 출력하는 메서드
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000);
			setSecond(second+1);
		}
	}
	
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//surrond try/catch
	}

	public int getHour() {
		return hour;	
	}

	public void setHour(int hour) {
		if(hour < 0){
			this.hour = 0;
		} else if (23 < hour){
//			this.hour = 23;
			this.hour = hour % 24;
		} else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute < 0){
			this.minute = 0;
		} else if (59 < minute){
			this.minute = minute%60;
			setHour(this.hour + minute / 60);
		} else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second< 0){
			this.second = 0;
		} else if (59 < second){
			this.second = second%60;
			setMinute(this.minute + second / 60);
		} else {
			this.second = second;
		}
	}
	
	//접근제어자, 나중에 시험에 나오니까 기억해둬라 ...	
}
