import java.util.Scanner;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n - 1; i++) {
        	int sum = i;
        	int temp = i;
            
            while(true) {
            	if (temp == 0) break;
            	
            	sum += temp % 10;
            	temp /= 10;
            }
        	
        	if (sum == n) {
        		System.out.println(i);
                return;
        	}
        }

        System.out.println(0);
	}
}