val dp = LongArray(101)
var start = 4

fun main() = with(System.`in`.bufferedReader()) {
    dp[0] = -1
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    val n1 = readLine().toInt()

    repeat(n1) {
        val n2 = readLine().toInt()
        println(pado(n2))
    }

}

fun pado(n: Int): Long {
    if(n < 4 || dp[n] != 0L) return dp[n]

    for(i in start..n) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }
    start = n

    return dp[n]
}