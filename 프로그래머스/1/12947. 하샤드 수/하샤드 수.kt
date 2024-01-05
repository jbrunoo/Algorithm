class Solution {
    fun solution(x: Int): Boolean {
        val sum = x.toString().map { it - '0' }.sum() // sum & fold
        // it:char형 .toString().toInt() || .digitToInt() || -'0'
        return x % sum == 0 
    }
}