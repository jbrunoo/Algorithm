class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var drawed: Int = section[0] - 1 
        for(s in section) {
            if(drawed < s) {
                drawed = s + m - 1 // drawed += m s부터 더해주지 않았음.
                answer++
            }
        }
        return answer
    }
}