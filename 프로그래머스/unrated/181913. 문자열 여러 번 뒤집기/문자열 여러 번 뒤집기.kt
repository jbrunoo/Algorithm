class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer = StringBuilder(my_string)
        for((s, e) in queries) {
            answer.replace(s, e + 1, answer.substring(s, e + 1).reversed())
        }
        return answer.toString()
    }
}