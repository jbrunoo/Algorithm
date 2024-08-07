
import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val p1 = mutableListOf<Double>()
    val p2 = mutableListOf<Double>()


    repeat(n) {
        val st = StringTokenizer(readLine())

        for(i in 1..6) {
            p1.add(st.nextToken().toDouble())
        }
        for(i in 1..6) {
            p2.add(st.nextToken().toDouble())
        }

        var score1 = 0
        var score2 = 0

        for(i in 0..2) {
            val distance1 = sqrt((p1[2 * i] * p1[2 * i]) + (p1[2 * i + 1] * p1[2 * i + 1]))
            val distance2 = sqrt((p2[2 * i] * p2[2 * i]) + (p2[2 * i + 1] * p2[2 * i + 1]))

            score1 += calculate(distance1)
            score2 += calculate(distance2)
        }

        if(score1 == score2) println("SCORE: $score1 to $score2, TIE.")
        else println("SCORE: $score1 to $score2, PLAYER ${if(score1 > score2) 1 else 2} WINS.")
        
        p1.clear()
        p2.clear()
    }
}

fun calculate(distance: Double): Int {
    return when(distance) {
        in 0.0..3.0 -> 100
        in 3.0..6.0 -> 80
        in 6.0..9.0 -> 60
        in 9.0..12.0 -> 40
        in 12.0..15.0 -> 20
        else -> 0
    }
}