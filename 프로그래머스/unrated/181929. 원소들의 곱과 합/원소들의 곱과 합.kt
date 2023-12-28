class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var sum1: Int = 1
        var sum2: Int = 0
        for(i in num_list) {
            sum1 *= i
            sum2 += i
        }
        if(sum1 < sum2*sum2) answer = 1
        else if(sum1 == sum2*sum2) null
        else answer = 0
        return answer
    }
}