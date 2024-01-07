class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        var answer: IntArray = intArrayOf()
        arr.mapIndexed {i, v ->
            if(flag[i]) repeat(v * 2) { answer += v }
            else answer = answer.dropLast(v).toIntArray()
        }
        return answer
    }
}