class Solution {
    fun solution(num_list: IntArray): Int {
            return num_list.indices.firstOrNull { num_list[it] < 0 } ?: -1
        // indexOfFirst는 null 대신 -1 
    }
}