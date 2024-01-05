class Solution {
    fun solution(num: Int): Int {
        var answer: Long = num.toLong() // 8,000,000 미만 정수 오버플로우 가능.
        var cnt = 0 
        while(answer != 1L) {
            if(cnt > 500) {
                cnt = -1
                break
            }
            if(answer % 2 == 0L) {
                answer /= 2
            }
            else {
                answer = answer * 3 + 1
            }
            cnt++
        }
        return cnt
    }
}