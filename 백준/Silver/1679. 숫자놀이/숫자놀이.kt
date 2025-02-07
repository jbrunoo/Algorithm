fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i(); val nums = IntArray(n) { i() }; val k = i()
    val dp = IntArray(1001) { 51 }
    dp[0] = 0
    dp[1] = 1

    var ret = 1001
    for(i in 2..1000) {
        for(num in nums) {
            if(i >= num) {
                dp[i] = minOf(dp[i], dp[i-num] + 1)
            }
        }

        if(dp[i] > k) {
            ret = i
            break
        }
    }

    val name = if(ret % 2 == 0) "holsoon" else "jjaksoon"

    print("$name win at $ret")
}