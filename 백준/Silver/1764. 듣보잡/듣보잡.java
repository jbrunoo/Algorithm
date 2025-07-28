import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		br.readLine();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		while (true) {
			String str = br.readLine();
			if (str == null) break;
			
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 0);
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
