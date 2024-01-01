class Solution {
    fun solution(number: String): Int {
        var answer: Int = 0
        for(c in number) {
            // '0' == 48 'A' == 65 'a' == 97
            answer += (c - '0').toInt() 
        }
        return answer % 9
    }
}