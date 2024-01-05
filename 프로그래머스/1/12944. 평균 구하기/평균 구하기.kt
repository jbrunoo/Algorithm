class Solution {
    fun solution(arr: IntArray): Double {
        // return arr.sum() / arr.size.toDouble()
        var answer = 0
        for(n in arr) {
            answer += n
        }
        return answer / arr.size.toDouble()
    }
}