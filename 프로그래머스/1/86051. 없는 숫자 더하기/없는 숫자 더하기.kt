class Solution {
    fun solution(numbers: IntArray): Int {
        var sum = 45
        numbers.forEach {
            sum -= it
        }
        return sum
    }
}