import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val ret = when {
        a == 0 -> c * c - b
        b == 0 -> c * c - a
        c == 0 -> sqrt(a + b.toDouble()).toInt()
        else -> {0}
    }

    print(ret)
}