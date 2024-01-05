class Solution {
    fun solution(x: Int): Boolean {
        val sum = x.toString().map { it.digitToInt() }.sum()
        println(sum)
        return x % sum == 0 
    }
}