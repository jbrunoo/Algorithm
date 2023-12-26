class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        for(i in included.indices) {
            if(included[i]) answer += a + i * d
        }
        return answer
    }
}