package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents_ {

	public static void main(String[] args) {
		String[] students = {"최기문", "이경준", "최윤지", "오수연"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 명 뽑을까요?");
		int count = Integer.parseInt(sc.nextLine());
		
		String[] pick = new String[count];
		int pickCount = 0;
		
		// 알아두면 유용한 패턴, 나중에 쓸 일이 있을 것
		do{
			int random = (int)(Math.random() * students.length);
			
			boolean flag = true;
			for(int i = 0; i < pick.length; i++){
				if(students[random].equals(pick[i])){ // 이미 뽑힌 사람들 중에 같은 사람이 있는지 비교
					flag = false;	// 중복된다면 조건문 안으로 들어와 변수값을 바꿔준다
				}
			}
			if(flag){ // 중복되지 않는다면 flag값이 true라서 실행할 수 있다
				pick[pickCount++] = students[random];
			}
		}while(pickCount < count); // 뽑은 사람이 뽑을 사람보다 적을 때 반복문 실행한다는 조건
		
		System.out.println(Arrays.toString(pick));
	}

}
