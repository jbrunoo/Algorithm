import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
            ArrayList<Integer> list = new ArrayList<>();
            
            for (int i = commands[c][0] - 1; i < commands[c][1]; i++) {
                list.add(array[i]);
            }
            
            Collections.sort(list);
            answer[c] = list.get(commands[c][2] - 1);
        }
        
        return answer;
    }
}