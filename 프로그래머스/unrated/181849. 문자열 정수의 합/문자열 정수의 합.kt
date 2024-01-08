class Solution {
    fun solution(num_str: String): Int {
        // return num_str.map { it - '0' }.sum()
        
        var answer = 0
        for(c in num_str) {
            answer += c - '0'
        }
        return answer
    }
}