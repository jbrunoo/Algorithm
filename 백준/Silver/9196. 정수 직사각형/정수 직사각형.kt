import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val arr = Array(151) { Array(151) { Square(0, 0, 0.0) } }

    for (i in 1..149) {
        for (j in i + 1..150) {
            arr[i][j] = Square(i, j, sqrt(i.toDouble() * i + j * j))
        }
    }
    val flatArr = arr.flatMap { it.toList() }.sortedWith(
        compareBy({ it.area }, { it.h })
    )

    while (true) {
        val st = StringTokenizer(readLine())
        val h = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        if (h <= 0 || w <= 0) break


        val ans = flatArr.indexOf(arr[h][w])
        sb.appendLine("${flatArr[ans + 1].h} ${flatArr[ans + 1].w}")
    }
    print(sb)
}

data class Square(val h:Int = 0, val w:Int = 0, val area:Double = 0.0)