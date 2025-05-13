fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(50001) { 5 }
    var sqrt = 1

    for(i in 1..n) {
        while(true) {
            val square = sqrt * sqrt

            when {
                square > i -> break
                square == i -> {
                    dp[i] = 1
                    break
                }
                else -> {
                    dp[i] = kotlin.math.min(dp[i], dp[square] + dp[i-square])
                }
            }

            sqrt++
        }
        sqrt = 1
    }

    print(dp[n])
}