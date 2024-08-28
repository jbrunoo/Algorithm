val ret = LongArray(100001)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print(dp(n))
}

fun dp(n: Int): Long {
    if(n == 2) return 1
    if(ret[n] != 0L) return ret[n]
    ret[n] = (dp(n - 2) * (n - 1)) % 1000000007
    return ret[n]
}