class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        // return if(arr1.size > arr2.size) 1
        // else if(arr1.size < arr2.size) -1
        // else arr1.sum().compareTo(arr2.sum())
        val n = arr1.size.compareTo(arr2.size)
        return if(n == 0) arr1.sum().compareTo(arr2.sum())
        else n
    }
}