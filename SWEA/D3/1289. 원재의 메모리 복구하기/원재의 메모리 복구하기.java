import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sb.append("#").append(test_case).append(" ");
			char[] memory = sc.next().toCharArray();
            int cnt = 0;
            
            for(int i = 0; i < memory.length; i++) {
                if(memory[i] == '1') {
                    cnt++;
                 	for(int j = i; j < memory.length; j++)  {
                       if(memory[j] == '1') memory[j] = '0';
                       else memory[j] = '1'; 
            		}
				}
			}
            
            sb.append(cnt).append("\n");
		}
        
        System.out.print(sb);
    }
}
