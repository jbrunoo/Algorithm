class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var total = n
        while(total > a - 1) {
            answer += total / a * b
            total = total / a * b + total % a
        }
        return answer
    }
}