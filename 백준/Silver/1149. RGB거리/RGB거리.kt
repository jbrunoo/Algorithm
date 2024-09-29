import java.io.StreamTokenizer
import kotlin.math.min

private lateinit var dp: Array<IntArray>
private lateinit var cost: Array<IntArray>

fun main()=StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()}
    val n=i()
    dp = Array(n){IntArray(3)}
    cost = Array(n){IntArray(3)}
    repeat(n) {
        cost[it][0] = i();cost[it][1] = i();cost[it][2] = i()
    }

    for(i in 0..2) dp[0][i] = cost[0][i]
    print(minOf(solve(n-1, 0), solve(n-1, 1), solve(n-1, 2)))
}

fun solve(n: Int, color: Int): Int {
    if(n == 0) return dp[0][color]
    if(dp[n][color] != 0) return dp[n][color]
    dp[n][0] = min(solve(n-1, 1), solve(n-1, 2)) + cost[n][0]
    dp[n][1] = min(solve(n-1, 0), solve(n-1, 2)) + cost[n][1]
    dp[n][2] = min(solve(n-1, 0), solve(n-1, 1)) + cost[n][2]
    return dp[n][color]
}