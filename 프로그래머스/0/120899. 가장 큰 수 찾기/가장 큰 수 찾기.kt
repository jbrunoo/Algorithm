class Solution {
    fun solution(array: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val a = array.maxOrNull()!!
        answer += a
        answer += array.indexOf(a)
        return answer
    }
}