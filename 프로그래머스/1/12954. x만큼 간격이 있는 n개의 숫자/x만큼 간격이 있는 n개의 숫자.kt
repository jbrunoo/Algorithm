class Solution {
    fun solution(x: Int, n: Int): List<Long> {
        return (1..n).map { it * x.toLong() }
    }
}