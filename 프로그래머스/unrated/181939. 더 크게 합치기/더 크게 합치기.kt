class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        val sum_ab = StringBuilder().append(a).append(b).toString().toInt()
        val sum_ba = StringBuilder().append(b).append(a).toString().toInt()
        answer = if(sum_ab <= sum_ba) sum_ba else sum_ab
        return answer
        
        // "$a$b".toInt() "$b$a".toInt()
    }
}