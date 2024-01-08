class Solution {
    fun solution(num_list: IntArray): IntArray {
        return num_list.sorted().drop(5).toIntArray()
    }
}