class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var answer: Int = 0
        for(i in board.indices) {
            for(j in board.first().indices) {
                if(i + j <= k) answer += board[i][j]
            }
        }
        return answer
    }
}