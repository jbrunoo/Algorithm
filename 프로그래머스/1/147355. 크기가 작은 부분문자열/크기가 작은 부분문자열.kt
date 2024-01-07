class Solution {
    fun solution(t: String, p: String): Int {
        // 런타임 에러 : p 길이 <= 18, int는 21억 약 10자리
        val range = t.length - p.length
        return (0..range).filter {
          t.substring(it until it + p.length).toLong() <= p.toLong()
        }.count()
        
        // var cnt = 0
        // for(i in 0..t.length - p.length) {
        //     if(p.toLong() >= t.substring(i until i + p.length).toLong()) cnt++
        // }
        // return cnt
    }
}