import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		if (arr.length == 1) {
			System.out.println(1);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] >= arr[i + 1]) System.out.println(i + 1);
			}
			
			if (i > 0 && i < n - 1) {
				if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1]) System.out.println(i + 1);				
			}
			
			if (i == n - 1) {
				if (arr[i - 1] <= arr[i]) System.out.println(i + 1);
			}
		}
	}
}