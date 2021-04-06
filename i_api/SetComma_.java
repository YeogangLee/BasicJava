package i_api;

public class SetComma_ {

	public static void main(String[] args) {
		System.out.println("숫자 입력>");
		String num = ScanUtil.nextLine();
		String num2 = "";
		
		int count = 0;
		for(int i = num.length() - 1; i >= 0; i--){
			num2 = num.charAt(i) + num2;
			count++;
			if(count % 3 == 0 && count != num.length()){
				num2 = "," + num2;
			}
		}
		System.out.println(num2);
	}

}
