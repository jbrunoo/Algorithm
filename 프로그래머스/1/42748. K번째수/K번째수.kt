class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for((i, j, k) in commands) {
            answer += array.sliceArray(i-1 until j).sorted()[k-1]
        }
        return answer
    }
}