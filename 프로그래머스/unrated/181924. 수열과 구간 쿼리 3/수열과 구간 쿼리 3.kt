class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer = arr.toMutableList()
        for((first, second) in queries) {
            val temp = answer[first]
            answer[first] = answer[second]
            answer[second] = temp
        }
        return answer.toIntArray()
    }
}