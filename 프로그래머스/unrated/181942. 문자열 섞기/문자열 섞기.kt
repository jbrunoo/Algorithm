class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        (str1.indices).forEach {
                answer += str1[it] + str2[it].toString()
            }
        return answer
    }
}