class Solution {
    fun solution(n: Int): Int {
        // return n.toString().map { it - '0' }.sum()
        return n.toString().sumOf { it - '0' }// sumBy, sumOf 더 빠름
    }
}