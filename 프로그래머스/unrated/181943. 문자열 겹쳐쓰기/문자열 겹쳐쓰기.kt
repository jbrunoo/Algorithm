class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        answer = my_string.substring(0, s) + overwrite_string
        if(answer.length == my_string.length) return answer
        else return answer + my_string.substring(answer.length)
    }
}