class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer = arr.toMutableList()
        for(query in queries) {
            val temp = answer[query[0]]
            answer[query[0]] = answer[query[1]]
            answer[query[1]] = temp
        }
        return answer.toIntArray()
    }
}