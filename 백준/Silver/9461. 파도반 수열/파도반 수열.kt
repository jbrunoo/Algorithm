val dp = LongArray(101)
var start = 4

fun main() = with(System.`in`.bufferedReader()) {
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    val n1 = readLine().toInt()
    val sb = StringBuilder()

    repeat(n1) {
        val n2 = readLine().toInt()
        sb.appendLine(pado(n2))
    }

    println(sb)
}

fun pado(n: Int): Long {
    if(n < 4 || dp[n] != 0L) return dp[n]

    for(i in start..n) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }
    start = n

    return dp[n]
}