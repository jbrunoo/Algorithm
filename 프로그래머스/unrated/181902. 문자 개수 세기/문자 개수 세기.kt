class Solution {
    fun solution(my_string: String): IntArray {
        var answer: IntArray = IntArray(52) { 0 }
        my_string.forEach {
            if(it in 'A'..'Z') answer[it - 'A']++
            else if(it in 'a'..'z') answer[it - 'A' - 6]++
        }
        return answer
    }
}