class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        // return if(k % 2 == 1) arr.map { it * k}.toIntArray()
        // else arr.map { it + k }.toIntArray()
        return arr.map { if(k % 2 == 1) it * k else it + k }.toIntArray()
    }
}