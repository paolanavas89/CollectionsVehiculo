import java.util.Comparator;
import java.util.Map.Entry;

public class Descendente implements Comparator <Entry<String,Integer>>{
	
	public int compare(Entry <String, Integer> obj1, Entry <String,Integer> obj2) {
		return obj2.getValue() - obj1.getValue();
	}
}
