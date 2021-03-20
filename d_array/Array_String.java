package d_array;

public class Array_String {

	public static void main(String[] args) {
		String[] arr = new String[2];
		arr[0] = "가";
		arr[1] = "나";

//		for (int i = 0; i < 2; i++) {
//			arr[i] = " ";
//		}
		
		System.out.println("배열은 : "+arr[0] + arr[1]);
		
		int[] n = new int[2];
		
		System.out.println("숫자 : "+n[0] + n[1]);
		
		int num1=0, num2=0;
		for(int i=0; i<2; i++){
			num1 = (int)(Math.random() * 25) + 1;
			num2 = (int)(Math.random() * 25) + 1;
		}
		
		System.out.println("숫자2 : "+num1+" "+num2);
	}

}
