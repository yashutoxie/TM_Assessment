import java.util.*;

class MultiLanguageDictionary<T extends String, U extends String> {
	private TreeMap<T, U> dict = new TreeMap<>();

	public void addWord(T word, U meaning) {
		dict.put(word, meaning);
	}

	public void displayDictionary() {
		if(dict.isEmpty()) {
			System.out.println("Dictionary is Empty");
			return;
		}
		System.out.println("\nDictionary Entries (Sorted Alphabetically): ");
		dict.forEach((word, meaning) -> System.out.println(word + " -> " + meaning));
	}

	public void sortByWordLength() {
		List<Map.Entry<T, U>> sortedList = new ArrayList<>(dict.entrySet());
		sortedList.sort(Comparator.comparingInt(entry -> entry.getKey().length()));


		System.out.println("\nDictionary Entries (Sorted by Word Length): ");
		for(Map.Entry<T,U> entry: sortedList) {
			System.out.println(entry.getKey()+ " -> " + entry.getValue());
		}
	}
}



public class Main{
    public static void main(String[] args){
        MultiLanguageDictionary<String, String> dict = new MultiLanguageDictionary<>();
        dict.addWord("Hola", "Hello (Spanish)");
        dict.addWord("Bonjour", "Hello (French)");
        dict.addWord("Hallo", "Hello (German)");
        dict.addWord("Ciao", "Hello (Italian)");
        dict.addWord("Namaste", "Hello (Hindi)");
        
        
        dict.displayDictionary();
        dict.sortByWordLength();
    }
}
