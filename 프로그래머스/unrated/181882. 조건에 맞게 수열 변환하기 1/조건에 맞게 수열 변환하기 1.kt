class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.map { if(it >= 50 && it % 2 == 0) it / 2 else if(it < 50 && it % 2 != 0) it * 2 else it }.toIntArray()
    }
}