import kotlin.math.abs
class Solution {
    fun solution(dots: Array<IntArray>): Int {
        // 01 02 03 12 13 23
        for(i in 0..3) {
            for(j in i + 1..3) {
                val a = dots[i]
                val b = dots[j]
                val (c, d) = dots.filter { it != a && it != b }
                if((b[1]-a[1]) / (b[0]-a[0]).toDouble() == (d[1]-c[1]) / (d[0]-c[0]).toDouble()) return 1
            }
        }
        return 0
    }
}
