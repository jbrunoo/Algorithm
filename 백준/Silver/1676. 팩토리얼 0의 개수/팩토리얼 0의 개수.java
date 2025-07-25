import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n - (n % 5);
		System.out.println(temp / 125 + temp / 25 + temp / 5);
	}
}