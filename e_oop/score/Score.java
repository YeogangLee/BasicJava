package e_oop.score;

public class Score {

	public static void main(String[] args) {
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
		
		//성적처리 프로그램을 완성해주세요.
		// 합계, 평균, 석차, 과목합계, 과목평균, 석차 순 출력
		
		// 학생 합계, 평균 
		//int[] students = new int[students.length];
		//double[] students = new double[students.length];
		for(int i = 0; i < students.length; i++){
			students[i].sum = students[i].kor + students[i].eng + students[i].math; 
			students[i].avg = Math.round((double)students[i].sum / subjects.length * 100) / 100.0;
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
		
//		int[] subSum = new int[subjects.length];
//		double[] subAvg = new double[subjects.length];
//		
//		for(int i = 0; i < subjects.length; i++){
//			switch(i){
//			case 0 : 
//				for(int j = 0; j < students.length; j++){
//					subSum[i] += students[j].kor; 
//				}
//				subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//				break;
//			case 1 : 
//				for(int j = 0; j < students.length; j++){
//					subSum[i] += students[j].eng; 
//				}
//				subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//				break;
//			case 2 : 
//				for(int j = 0; j < students.length; j++){
//					subSum[i] += students[j].math; 
//				}
//				subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
//				break;
//			}			
//		}
		
		// 석차
		for(int i = 0; i < students.length; i++){
			for(int j = 0; j < students.length; j++){
				if(students[i].sum < students[j].sum){
					students[i].rank++;
				}
			}
		}
		
		// 석차 순 정렬
		for(int i = 0; i < students.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < students.length; j++){
				if(students[j].sum > students[min].sum){
					min = j;
				}
			}
			int temp = students[i].kor;
			students[i].kor = students[min].kor;
			students[min].kor = temp;
			
			int temp2 = students[i].eng;
			students[i].eng = students[min].eng;
			students[min].eng = temp2;
			
			int temp3 = students[i].math;
			students[i].math = students[min].math;
			students[min].math = temp3;
			
			int temp4 = students[i].rank;
			students[i].rank = students[min].rank;
			students[min].rank = temp4;
			
			String temp5 = students[i].name;
			students[i].name = students[min].name;
			students[min].name = temp5;
			
			int temp6 = students[i].sum;
			students[i].sum = students[min].sum;
			students[min].sum = temp6;
			
			double temp7 = students[i].avg;
			students[i].avg = students[min].avg;
			students[min].avg = temp7;
			
		}
		
		// 출력
		System.out.print("\t");
		for(int i = 0; i < subjects.length; i++){
			System.out.print(subjects[i] + "\t");
		}
		System.out.println("합계\t평균\t석차");
		for(int i = 0; i < students.length; i++){
			System.out.println(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" + students[i].math +
					"\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
		}
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
