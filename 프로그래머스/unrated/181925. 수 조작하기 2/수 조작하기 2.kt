class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        val log = mapOf(1 to 'w', -1 to 's', 10 to 'd', -10 to 'a')
        for(i in 1 until numLog.size) {
            answer += log[numLog[i] - numLog[i - 1]]
        }
        return answer
    }
}