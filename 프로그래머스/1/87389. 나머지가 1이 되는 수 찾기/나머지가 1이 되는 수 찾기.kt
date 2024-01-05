class Solution {
    fun solution(n: Int): Int {
        return (1 until n).filter { n % it == 1 }[0]
    }
}