class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return num_list.slice(num_list.indices step n).toIntArray()
    }
}