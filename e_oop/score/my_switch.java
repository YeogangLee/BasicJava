package e_oop.score;

import java.util.Arrays;

public class my_switch {

	public static void main(String[] args) {
		
		// d_array > Quiz.java
		/*
		 * [그래프 그리기]
		 * 
		 * 1~5 사이의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
		 * 
		 * [4, 3, 2, 5, 4, 1, 4, 2, 2, 2, 2, 3, 3, 1, 5, 1, 1, 3, 1, 2]
		 * 
		 * 1 : ***** 5
		 * 2 : **** 4
		 * 3 : **** 4
		 * 4 : **** 4
		 * 5 : *** 3
		 * 
		 */
		
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));		
		
		
		int[] counts = new int[5];
		for(int i = 0; i < arr.length; i++){
			counts[arr[i]-1]++;
		} // code**
		for (int i = 0; i < counts.length; i++) {
			System.out.print((i + 1) + " : " + counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		//선생님작성
		
		
		
				
//				int[] cnt = new int[5];
//				
//				for(int i=0; i < arr.length; i++){
//					switch(arr[i]){
//					case 1: cnt[0]++; break;
//					case 2: cnt[1]++; break;
//					case 3: cnt[2]++; break;
//					case 4: cnt[3]++; break;
//					case 5: cnt[4]++; break;
//					}
//				}
//				
//				
////				for(int i=0; i < cnt.length; i++){
////					System.out.print(cnt[i]);
////				}
//				
//				for (int i = 0; i < cnt.length; i++) {
//					System.out.print((i + 1) + " : " + cnt[i]);
//					for (int j = 0; j < cnt[i]; j++) {
//						System.out.print(" *");
//					}
//					System.out.println();
//				}
				
				
				/*//*/
		
				// e_oop > score > Score.java
				Student[] students = new Student[10];
				String[] subjects = {"국어", "영어", "수학"};
				
				for(int i = 0; i < students.length; i++){
					Student student = new Student();
					
					student.name = "학생" + (i + 1);
					student.rank = 1;
					student.kor = (int)(Math.random()*101);
					student.eng = (int)(Math.random()*101);
					student.math = (int)(Math.random()*101);
					
					students[i] = student;
				}
				
				// 과목 합계, 평균
				int[]subSum = new int[subjects.length];
				for(int i = 0; i < students.length; i++){
					subSum[0] += students[i].kor;
					subSum[1] += students[i].eng;
					subSum[2] += students[i].math;
				}
				double[] subAvg = new double[subjects.length];
				for(int i = 0; i < subAvg.length; i++){
					subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
				}
				
//				int[] subSum = new int[subjects.length];
//				double[] subAvg = new double[subjects.length];
//				
//				for(int i = 0; i < subjects.length; i++){
//					switch(i){
//					case 0 : 
//						for(int j = 0; j < students.length; j++){
//							subSum[i] += students[j].kor; 
//						}
//						subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//						break;
//					case 1 : 
//						for(int j = 0; j < students.length; j++){
//							subSum[i] += students[j].eng; 
//						}
//						subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//						break;
//					case 2 : 
//						for(int j = 0; j < students.length; j++){
//							subSum[i] += students[j].math; 
//						}
//						subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//						break;
//					}			
//				}
				
				
				System.out.print("과목합계");
				for(int i = 0; i < subjects.length; i++){
					System.out.print("\t" + subSum[i]);
				}
				System.out.println();
				System.out.print("과목평균");
				for(int i = 0; i < subjects.length; i++){
					System.out.print("\t" + subAvg[i]);
				}
				

	}

}
