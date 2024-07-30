import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(m + 1)
    val st = StringTokenizer(readLine())
    for(i in 1..m) {
        dp[i] = dp[i - 1] + st.nextToken().toInt()
    }

    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        sb.appendLine(dp[b] - dp[a - 1])
    }
    println(sb)
}