fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }

    val n = i()
    val dp = IntArray(n + 1)
    val arr = IntArray(n) { i() }

    for (i in 1..n) {
        for (j in 1..i) {
            dp[i] = maxOf(dp[i], dp[i - j] + arr[j - 1])
        }
    }

    println(dp[n])
}