class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer: Int = 0
        val value = if(ineq == ">" && eq == "=") n >= m
        else if(ineq == "<" && eq == "=") n <= m
        else if(ineq == ">" && eq == "!") n > m
        else n < m
        
        if(value) answer = 1
        
        return answer
    }
}