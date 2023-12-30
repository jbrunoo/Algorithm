class Solution {
    fun solution(numLog: IntArray): String {
        var answer = StringBuilder()
        for(i in 1 until numLog.size) {
            val log = numLog[i] - numLog[i - 1]
            when(log) {
                1 -> answer.append('w')
                -1 -> answer.append('s')
                10 -> answer.append('d')
                -10 -> answer.append('a')
            }
        }
        return answer.toString()
    }
}