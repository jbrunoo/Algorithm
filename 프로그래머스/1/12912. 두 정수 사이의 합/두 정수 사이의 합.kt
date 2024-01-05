class Solution {
    fun solution(a: Int, b: Int): Long {
        // return if(a <= b) (a.toLong()..b).sum() else (b.toLong()..a).sum()
        // a+b * a..b길이 / 2 로 속도 단축. double도 8byte
        return if(a <= b) ((a+b) * (b - a + 1).toDouble() / 2).toLong() else ((a+b) * (a - b + 1).toDouble() / 2).toLong()
        
    }
}