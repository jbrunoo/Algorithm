class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        val (a, b) = intervals.first()
        val (c, d) = intervals.last()
        return (arr.slice(a..b) + arr.slice(c..d)).toIntArray()
    }
    // flatMap
}