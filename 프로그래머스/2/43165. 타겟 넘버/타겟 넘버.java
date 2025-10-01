class Solution {
    
    private int n, cnt;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        cnt = 0;        
        dfs(numbers, 0, 0, target);
        
        return cnt;
    }
    
    private void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == n) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}