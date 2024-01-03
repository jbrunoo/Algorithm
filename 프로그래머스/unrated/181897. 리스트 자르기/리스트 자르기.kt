class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): List<Int> {
        val (a, b, c) = slicer
        return when(n) {
            1 -> num_list.slice(0..b).toList()
            2 -> num_list.slice(a until num_list.size).toList()
            3 -> num_list.slice(a..b).toList()
            4 -> num_list.slice(a..b step c)
            else -> throw IllegalArgumentException("Invalid value")
        }
    }
}