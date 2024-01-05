class Solution {
    fun solution(n: Long): Long {
        return n.toString().map { it }.sortedDescending().joinToString("").toLong()
    }
}