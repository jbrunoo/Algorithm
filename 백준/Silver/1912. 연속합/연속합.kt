import java.util.*
import kotlin.math.max

val dp = IntArray(100001)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n + 1)
    val st = StringTokenizer(readLine())

    for(i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }
    dp[1] = arr[1]
    var max = dp[1]


    for(i in 2..n) {
        dp[i] = max(dp[i - 1] + arr[i], arr[i])
        max = max(max, dp[i])
    }

    println(max)
}
