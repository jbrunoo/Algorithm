class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        for(i in 1 until numLog.size) {
            val log = numLog[i] - numLog[i - 1]
            when(log) {
                1 -> answer += 'w'
                -1 -> answer += 's'
                10 -> answer += 'd'
                -10 -> answer += 'a'
            }
        }
        return answer
    }
}