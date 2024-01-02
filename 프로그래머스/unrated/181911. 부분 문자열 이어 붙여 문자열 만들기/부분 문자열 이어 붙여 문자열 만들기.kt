class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        var answer = StringBuilder()
        for(i in parts.indices) {
            val (s, e) = parts[i]
            answer.append(my_strings[i].slice(s..e))
        }
        return answer.toString()
    }
}