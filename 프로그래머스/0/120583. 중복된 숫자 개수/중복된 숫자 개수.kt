class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        answer = array.filter { it == n }.size
        return answer
    }
}