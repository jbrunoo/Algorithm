class Solution {
    fun solution(date1: IntArray, date2: IntArray): Int {
        var answer: Int = 0
        for(i in 0..2) {
            if(date1[i] < date2[i]) {
                answer = 1
                break
            }
            else if(date1 [i] > date2[i]) {
                answer = 0
                break
            }
            else continue
        }
        return answer
    }
}