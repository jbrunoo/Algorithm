class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        val sum_ab = (a.toString() + b.toString()).toInt()
        val sum_ba = (b.toString() + a.toString()).toInt()
        answer = if(sum_ab <= sum_ba) sum_ba else sum_ab
        return answer
    }
}