package f_game;

import java.util.Arrays;
import java.util.Scanner;

public class prc {

	public static void main(String[] args) {
		String[] arr = {"a", "b"};
		System.out.println(Arrays.toString(arr));
		String str = Arrays.toString(arr);
		String input = "";
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("문자입력>");
			input = sc.nextLine();
		} while(input.equals(str));
		
		for(int i = 0; i < 5; i++){
			for(int j = 1; j < 5; j++){
				if(i == j) continue;
				System.out.println(i + " % " + j + "=" + i%j);
			}
		}
	}

}
