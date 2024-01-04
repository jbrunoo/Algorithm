class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = arr
        for((s, e) in queries) {
            (s..e).forEach { answer[it]++ }
        }
        return answer
    }
}