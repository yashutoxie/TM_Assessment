import java.util.*;
 
public class Main {
	private HashMap<String, Integer> stuScore = new HashMap<>();

	public void addstuscore(String name, int score) {
		stuScore.put(name, score);
	}

	public void displaysortedscores() {
		TreeMap<String, Integer> sortedScores = new TreeMap<>(stuScore);
		System.out.println("\nStudent Scores (Sorted by Name): ");
		sortedScores.forEach((name, score) -> System.out.println(name+" -> "+ score));
	}

	public void findhighestandlowestscore() {
		if(stuScore.isEmpty()) {
		    System.out.println("No Scores Available");
		    return;
		}
		
		int maxScore = Collections.max(stuScore.values());
		int minScore = Collections.min(stuScore.values());
		
		System.out.println("\nHighest Score: " + maxScore);
		stuScore.forEach((name, score) ->{
		    if(score == minScore) System.out.println("- " + name);
		});
	}
	
	public void processScore(){
	    List<Integer> scoresList = new ArrayList<>(stuScore.values());
	    System.out.println("\nProcessing Scores {List Format}:" + scoresList);
	    
	    double avg = scoresList.stream().mapToInt(Integer::intValue).average().orElse(0);
	    System.out.println("Average Score: " + avg);
	}
	
	public static void main(String[] args){
	    Main m = new Main();
	    
	    m.addstuscore("Alice", 89);
	    m.addstuscore("Babar", 90);
	    m.addstuscore("Xavier", 80);
	    m.addstuscore("Yash", 98);
	    
	    
	    m.displaysortedscores();
	    m.findhighestandlowestscore();
	    m.processScore();
	}
}
