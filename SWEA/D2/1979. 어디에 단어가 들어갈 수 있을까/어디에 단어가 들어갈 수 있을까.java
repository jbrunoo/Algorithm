import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
       		int[][] puzzle = new int[n][n];
            
            for(int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < n; j++) {
                 	puzzle[i][j] = Integer.parseInt(st.nextToken());  
                }
            }
                
            sb.append("#").append(t).append(" ").append(check(puzzle, k)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static int check(int[][] puzzle, int k) {
        int ret = 0;
        
    	for(int i = 0; i < puzzle.length; i++) {
            int width = 0;
            int height = 0;
            
         	for(int j = 0; j < puzzle.length; j++) {
                if (puzzle[i][j] == 1) width++; else {
                	if (width == k) {
                    	ret++; width = 0;
                    } else {
                        width = 0;
                    }
                }
                if (puzzle[j][i] == 1) height++; else {
                	if(height == k) {
                        ret++; height = 0;
                    } else {
                        height = 0;
                    }
                }
            }
            
            if (width == k) ret++; if (height == k) ret++;
      }
        
        return ret;
    }
}