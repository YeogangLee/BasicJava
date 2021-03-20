package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		
		//입력한 숫자만큼 우리반 학생들 중 랜덤으로 뽑아서 출력하는 프로그램을 만들어주세요.
		//우리반 25명, 1~25번 랜덤
		//중요 - 중복되지 않게 뽑아야 함
		
		Scanner sc = new Scanner(System.in);
		
		// String[] names = new String[25];
		String[] names = {"강유진", "강지수", "곽재우", "구본성", "권수연", "김보영", "김소희", "김지수", "백지혜", "송유경", "신희철", "심선주",
				"오수연", "윤희중", "이경준", "이석호", "이승구", "이여강", "이영민", "이영우", "이용석", "이정범", "최기문", "최소은", "최윤지"};
		
		int num=0;
		String[] tempS = new String[25];
		
		do{
			System.out.println("학생 수 입력(0은 종료)>");
			num = Integer.parseInt(sc.nextLine());
			
			
			int[] tempN = new int[25];
			int ind=0;
			int cntDupl=0;
			
			for(int i = 0; i < num; i++){
				ind = (int)(Math.random()*25)+1;
				if(tempN[ind-1] != 0){
					cntDupl++;
					i--;
					continue;
				}
				if(cntDupl > 0) {
					ind = (int)(Math.random()*25)+1;
					cntDupl--;
					if(tempN[ind-1] != 0){
						i--;
						continue;
					}
				}
				if(ind == 25) ind = 0;
				tempN[ind] = ind;
				tempS[i] = names[ind];
				
				System.out.print(names[ind]+" "+i+"\t");
			}
			System.out.println();
			
		}while(num!=0);
	}

}
