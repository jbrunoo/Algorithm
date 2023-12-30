class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        var temp : MutableList<Int> = mutableListOf() 
        for((s, e, k) in queries) {
            for(i in s..e) {
                if(arr[i] > k) temp.add(arr[i])
            }
            answer += temp.minOrNull() ?: -1
            temp.clear()
        }
        return answer
    }
}