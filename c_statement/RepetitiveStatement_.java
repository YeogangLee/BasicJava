package c_statement;

public class RepetitiveStatement_ {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
		System.out.println();
		
		for(int j = 1; j <= 5; j++){
			for(int i = 1; i <= j; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("*****");
		System.out.println("****");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");		
		
		for(int j = 5; j >= 1; j--){
			for(int i = 1; i <= j; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("    *");
		System.out.println("   **");
		System.out.println("  ***");
		System.out.println(" ****");
		System.out.println("*****");
		System.out.println();
		
	/*  5 12345
		4 1234
		3 123
		2 12
		1 1
*/		
		for(int j = 5; j >= 1; j--){
			for(int i = 1; i <= j; i++){
				System.out.print(" ");
			}
			for(int i = 0; i <= 5-j; i++){
				//5-j
				System.out.print("*");
			}
			System.out.println();
		}	
		System.out.println();
		
		
		// 세 번째 삼각형, 선생님 작성
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 5 - i; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}		

}
