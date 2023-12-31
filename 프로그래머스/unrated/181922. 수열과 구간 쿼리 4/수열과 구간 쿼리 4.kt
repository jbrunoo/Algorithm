class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((s, e, k) in queries) {
            (s..e).forEach {
                if(it % k == 0) arr[it]++
            }
        }
        return arr
    }
}