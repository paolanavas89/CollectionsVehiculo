
import java.util.Comparator;
import java.util.Map.Entry;

public class Ascendente implements Comparator <Entry<String,Integer>> {
	
	public int compare(Entry <String, Integer> obj1, Entry <String,Integer> obj2) {
		return obj1.getValue() - obj2.getValue();
	}
}
