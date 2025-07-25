import java.util.Scanner;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 1_000_000;
        
        for (int i = n - 1; i > 0; i--) {
        	int sum = i;
        	int temp = i;
            
            while(true) {
            	if (temp == 0) break;
            	
            	sum += temp % 10;
            	temp /= 10;
            }
        	
        	if (sum == n) {
        		min = Math.min(min, i);
        	}
        }
       
        if (min == 1_000_000)System.out.println(0); 
        else System.out.println(min);
	}
}