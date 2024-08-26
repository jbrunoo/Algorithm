import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toLong()
        val y = st.nextToken().toLong()

        sb.appendLine(count(y - x))
    }

    print(sb)
}

fun count(n: Long): Long {
    if (n <= 3) return n

    val a = sqrt(n.toDouble()).toLong()

    for (i in a..a + 1) {
        for (j in i..a + 1) {
            if (n <= i * j) {
                val ans = if (i == j) i * 2 - 1
                else i * 2
                return ans
            }
        }
    }

    return 0
}