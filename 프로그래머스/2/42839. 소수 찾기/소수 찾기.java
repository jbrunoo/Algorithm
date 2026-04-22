import java.util.*;

class Solution {

    private boolean[] visited;
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int cnt = 0;
        visited = new boolean[numbers.length()];
        
        perm("", numbers);
        for (int n : set) {
            if (isPrime(n)) cnt++;
        }
        return cnt;
    }
    
    private void perm(String str, String numbers) {
        if (!str.isEmpty()) {
            set.add(Integer.parseInt(str));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(str + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    
    
    private boolean isPrime(int a) {
        if (a < 2) return false;
        
        for (int i = a - 1; i > 1; i--) {
            if (a % i == 0) return false;
        }
        
        return true;
    }
}