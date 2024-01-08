class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        return arr.filter { it !in delete_list }.toIntArray()
    }
}