import java.util.Arrays;
import java.util.List;

public class InternalIterator {

	public static void main(String[] args) {
		   List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});
	         
	        for(String letter: alphabets){
	            System.out.println(letter.toUpperCase());
	        }
	        
	        
	        alphabets = Arrays.asList(new String[]{"a","b","b","d"});	         
	        alphabets.forEach(l -> l.toUpperCase());
	        alphabets.forEach(System.out::println);
	}

}
