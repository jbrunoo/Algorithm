private lateinit var dp: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }

    repeat(n) { i ->
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp = IntArray(h + 1)
    dp[0] = 1

    for (i in 0 until n) {
        val temp = dp.clone()
        for (block in arr[i]) {
            for (j in block..h) {
                temp[j] = (temp[j] + dp[j - block]) % 10007
            }
        }
        dp = temp
    }

    println(dp[h])
}