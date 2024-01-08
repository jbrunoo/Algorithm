class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = arr
        var n = 1
        while(answer.size != n) {
            if(answer.size < n) answer += 0
            if(answer.size > n) n *= 2
        }
        return answer
    }
}