package home_MyGame;

public class Quiz {
	
	int answer;
	String question;
	String baseSent;
	String meanSent;	
	String[] examples = new String[3];
	
	Quiz(String question, String baseSent, String meanSent, String example1, String example2, String example3, int answer){
		this.answer = answer;
		this.question = question;
		this.baseSent = baseSent;
		this.meanSent = meanSent;
		this.examples[0] = example1;
		this.examples[1] = example2;
		this.examples[2] = example3;
	}
	
	int showQuiz(){
		System.out.println(question+"\n");
		for(int i = 0; i < examples.length; i++){
			System.out.println((i+1)+". "+examples[i]);
		}
		System.out.println();
		return answer;
	}
		
	void showMeaning(){
		System.out.println("<해설>\n" + meanSent + "\n" + baseSent + "\n"); 	
	}
	
	void showAnswer(){
		System.out.println("정답 | "+baseSent+"\n"); 	
	}
}