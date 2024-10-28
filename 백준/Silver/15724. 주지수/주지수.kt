    fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
        fun i(): Int { nextToken();return nval.toInt() }
        val n = i(); val m = i()
        val dp = Array(n + 1) { IntArray(m + 1) }
        repeat(n) { i -> repeat(m) { j -> dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + i() } }
        val sb = StringBuilder()
        repeat(i()) {
            val x1 = i(); val y1 = i(); val x2 = i(); val y2 = i()
            val pop = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]

            sb.append(pop).append("\n")
        }

        print(sb)
    }