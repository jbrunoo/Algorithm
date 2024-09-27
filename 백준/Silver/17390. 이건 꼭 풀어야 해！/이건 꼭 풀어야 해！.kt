import java.io.StreamTokenizer

private lateinit var arr: IntArray
private lateinit var dp: IntArray

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    val sb=StringBuilder()
    fun i():Int{nextToken();return nval.toInt()}
    val n=i();val q=i()
    arr = IntArray(n) {i()}
    arr.sort()
    dp = IntArray(n)
    dp[0] = arr[0]
    repeat(q) {
        val l=i();val r=i()
        var sum = 0
        sum += sum(r-1) - sum(l-2)
        sb.append(sum).append("\n")
    }
    print(sb)
}

fun sum(n:Int):Int {
    if(n == -1) return 0
    if(dp[n] != 0) return dp[n]
    dp[n] = sum(n-1) + arr[n]
    return dp[n]
}