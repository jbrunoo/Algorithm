class Solution {
    fun solution(my_string: String, m: Int, c: Int): String {
        var answer = StringBuilder()
        for(i in c - 1 until my_string.length step m) {
            answer.append(my_string[i])
        }
        return answer.toString()
    }
}