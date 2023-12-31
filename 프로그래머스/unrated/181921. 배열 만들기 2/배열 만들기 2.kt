class Solution {
    fun solution(l: Int, r: Int): IntArray {
        var answer: IntArray = intArrayOf()
        (l..r).forEach { num ->
            val bool = num.toString().all {
                it in "05"
            }
            if(bool) answer += num
        }
        if(answer.isEmpty()) answer += -1
        return answer
    }
}