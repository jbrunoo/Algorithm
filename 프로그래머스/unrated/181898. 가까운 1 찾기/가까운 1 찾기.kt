class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        val intArr = (idx until arr.size).filter { arr[it] == 1 }
        return if(intArr.isNotEmpty()) intArr[0] else -1
    }
}