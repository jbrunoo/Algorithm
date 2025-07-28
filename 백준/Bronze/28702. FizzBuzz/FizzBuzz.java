import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 3; i > 0; i--) {
			String res = find(br.readLine(), i);
			
			if (res == "") continue;
			else System.out.println(res);
			break;
		}
	}
	
	static String find(String str, int next) {
		String res;
		
		try {
			int n = Integer.parseInt(str);
			int predict = n + next;
			if (predict % 3 == 0 && predict % 5 == 0) res = "FizzBuzz";
			else if (predict % 3 == 0 && predict % 5 != 0) res = "Fizz";
			else if (predict % 3 != 0 && predict % 5 == 0) res = "Buzz";
			else res = String.valueOf(predict);
		} catch(Exception e) {
			return "";
		}
		
		return res;
	}
}
