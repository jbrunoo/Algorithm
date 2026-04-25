class Solution {
    int N;
    boolean[] visited;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        perm(dungeons, 0, k, 0);
        return answer;
    }
    
    private void perm(int[][] dungeons, int depth, int k, int result) {
        answer = Math.max(answer, result); 
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] <= k) {
                visited[i] = true;
                perm(dungeons, depth + 1, k - dungeons[i][1], result + 1);                       visited[i] = false;
            }
        }
    }
}