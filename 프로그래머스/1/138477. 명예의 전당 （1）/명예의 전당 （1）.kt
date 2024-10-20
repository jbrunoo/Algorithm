class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = IntArray(score.size)
        for(i in score.indices) {
            val arr = IntArray(i+1)
            for(j in 0..i) {
                arr[j] = score[j]
            }
            answer[i] = if(arr.size >= k) arr.sortedDescending()[k-1] else arr.minOf { it }

        }

        return answer
    }
}