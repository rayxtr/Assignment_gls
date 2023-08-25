import java.util.HashMap;

public class HashMapSolution {
public static void main(String[] args) {
	HashMap<String,Integer> map = new HashMap<>();
	
	map.put("Ram", 36);
	map.put("Shyam",18);
	map.put("Chunnu", 20);
	map.put("Munnu", 33);

	
	String search1 = "Ram";
	String search2 = "Kalu";
	
	if(map.containsKey(search1)) {
		System.out.println("Name - "+search1+" Age - "+map.get(search1));
	}else {
		System.out.println("Employee not found with this name..");
	}
	
	if(map.containsKey(search2)) {
		System.out.println("Name - "+search2+" Age - "+map.get(search2));
	}else {
		System.out.println("Employee not found with this name..");
	}
	
	String[]names = {"Ankit", "Madhu","Munnu","Chunnu"};
	
	for(String n: names) {
		if(map.containsKey(n)) {
		System.out.println("Name - "+n+ " Age - "+map.get(n));
		}
	}
}
}
