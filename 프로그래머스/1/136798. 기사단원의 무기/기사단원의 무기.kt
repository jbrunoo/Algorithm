import kotlin.math.sqrt
class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        // 시간 초과
        var powerArr = intArrayOf()
        for(i in 1..number) {
            var numArr = intArrayOf()
            // 시간 초과(전체x, 절반 계산x) 제곱근까지 계산
            for(j in 1..sqrt(i.toDouble()).toInt()) { 
                if(i % j == 0) {
                    numArr += j
                    numArr += i / j
                }
            }
            powerArr += numArr.distinct().count() // 1 5 5 25 반례
        }
        return powerArr.map { if(it > limit) power else it }.sum()
    }
}