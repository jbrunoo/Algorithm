class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        arr.map {
            if(answer.size < k && it !in answer) answer += it
        }
        while(answer.size < k) {
            answer += -1
        }
        return answer
    }
}