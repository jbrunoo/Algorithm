import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<Integer> mine = new ArrayList<>();
		
		while (true) {
			if (isEmpty()) break;
			int startIdx = findMaxIdx();
			mine.add(startIdx + 1);
			bombNeighbor(startIdx);
		}
		
		mine.sort(null);
		
		for (int m : mine) {
			System.out.println(m);
		}
	}
	
	private static boolean isEmpty() {
		for (int a : arr) {
			if (a != 0) return false;
		}
		return true;
	}
	
	private static int findMaxIdx() {
		int max = 0;
		int maxIdx = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
	
	private static void bombNeighbor(int startIdx) {
		int leftBombSize = arr[startIdx];
		int rightBombSize = arr[startIdx];
		arr[startIdx] = 0;
		int left = startIdx;
		int right = startIdx;
		
		for (int i = 0; i < n; i++) {
			left--;
			right++;
			
			if (left >= 0) {
				if (arr[left] != 0 && arr[left] < leftBombSize) {
					leftBombSize = arr[left];
					arr[left] = 0;
				} else {
					left = -1;
				}
			}
			
			if (right < n) {
				if (arr[right] != 0 && arr[right] < rightBombSize) {
					rightBombSize = arr[right];
					arr[right] = 0;					
				} else {
					right = n;
				}
			}
			
			if (left < 0 && right >= n) break;
		}
	}
}