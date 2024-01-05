class Solution {
    fun solution(n: Long): IntArray {
        // var answer = intArrayOf(n + 1)
        return n.toString().reversed().map { it - '0' }.toIntArray()   
    }
}