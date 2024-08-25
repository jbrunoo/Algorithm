import java.util.*

val arr = Array(31) { IntArray(31) }

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    for (i in 1..30) {
        arr[1][i] = i
        arr[i][i] = 1
    }

    repeat(t) {
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        sb.appendLine(dp(n, m))
    }

    print(sb)
}

fun dp(n: Int, m: Int): Int {
    if (arr[n][m] != 0) return arr[n][m]
    arr[n][m] = dp(n - 1,m - 1) + dp(n, m - 1)
    return arr[n][m]
}