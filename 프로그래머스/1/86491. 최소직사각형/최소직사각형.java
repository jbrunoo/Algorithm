class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int height = 0;
        int width = 0;
        for (int[] size : sizes) {
            int h = Math.max(size[0], size[1]);
            int w = Math.min(size[0], size[1]);
            height = Math.max(height, h);
            width = Math.max(width, w);
        }
        
        answer = height * width;
        return answer;
    }
}