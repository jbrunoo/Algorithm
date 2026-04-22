class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int maxWidth = 3 + (brown - 8) / 2;
        
        for (int i = maxWidth, j = 3; i >= j; i--, j++) {
            if (i * j - brown == yellow) {
                answer[0] = i;
                answer[1] = j;
                break;
            }
        }
        return answer;
    }
}