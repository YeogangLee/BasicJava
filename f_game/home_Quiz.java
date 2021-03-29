package f_game;

public class home_Quiz {
	
	int answer;
	String question;
	String meaning;
	String[] examples;
	
	home_Quiz(String question, String meaning, String example1, String example2, String example3, int answer){
		this.answer = answer;
		this.question = question;
		this.meaning = meaning;
		this.examples[0] = example1;
		this.examples[1] = example2;
		this.examples[2] = example3;
	}
	
	int showQuiz(){
		System.out.println(question);
		System.out.println(examples);
		return answer;
	}
	
	void showMeaning(int answer){
		if(this.answer == answer){
			System.out.println(meaning);
		}// 메서드 호출 후 답 비교... 	
	}
	
	void showMeaning2(){
		System.out.println(meaning); 	
	}// 메서드 호출하면 무조건 의미 보여주기
}
