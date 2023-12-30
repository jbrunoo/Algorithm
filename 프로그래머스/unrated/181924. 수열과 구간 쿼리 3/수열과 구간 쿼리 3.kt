class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((first, second) in queries) {
            val temp = arr[first]
            arr[first] = arr[second]
            arr[second] = temp
        }
        return arr
    }
}