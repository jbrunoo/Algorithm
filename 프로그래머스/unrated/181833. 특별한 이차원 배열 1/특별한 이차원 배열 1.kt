class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer: Array<IntArray> = Array(n) { IntArray(n) }
        for(j in 0 until n) {
            for(i in 0 until n) {
                if(i == j) answer[i][j] = 1
            }
        }
        return answer
    }
}