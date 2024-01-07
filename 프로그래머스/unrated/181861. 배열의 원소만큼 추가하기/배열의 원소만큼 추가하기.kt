class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        arr.forEach {n ->
            (1..n).forEach {
                answer += n
            }
        }
        return answer
    }
}