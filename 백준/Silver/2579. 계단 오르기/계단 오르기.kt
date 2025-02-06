import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stairs = IntArray(n) { readLine().toInt() }
    val dp = IntArray(n+1)
    
    dp[0] = stairs[0]
    if(n == 1) {
        print(dp[0])
        return@with   
    }
    
    dp[1] = stairs[0] + stairs[1]
    if(n == 2) {
        print(dp[1])
        return@with
    }
    
    dp[2] = stairs[2] + max(0 + stairs[1], dp[0])
    if(n == 3) {
        print(dp[2])
        return@with
    }

    for(i in 3 until n) {
        dp[i] = stairs[i] + max(dp[i-3] + stairs[i-1], dp[i-2])
    }

    print(dp[n-1])
}