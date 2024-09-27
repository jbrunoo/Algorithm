import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    val sb=StringBuilder()
    fun i():Int{nextToken();return nval.toInt()}
    val n=i();val q=i()
    val arr = IntArray(1001)
    repeat(n) {arr[i()]++}
    val dp = IntArray(n+1)
    var j = 1
    for(i in 1..1000) {
        while(arr[i] > 0) {
            dp[j] = dp[j-1] + i
            j++
            arr[i]--
        }
    }
    repeat(q) {
        val l=i()-1;val r=i()
        sb.append(dp[r]-dp[l]).append("\n")
    }
    print(sb)
}