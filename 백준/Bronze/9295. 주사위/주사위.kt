import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    var cnt = 0

    repeat(n) {
        cnt++
        val st = StringTokenizer(readLine(), " ")
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        sb.appendLine("Case $cnt: ${a + b}")
    }

    print(sb)
}