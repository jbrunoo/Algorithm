import java.io.StreamTokenizer
import kotlin.math.max

private lateinit var computers: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
private lateinit var dp: IntArray


fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i(); val m = i()
    computers = Array(n + 1) { mutableListOf() }
    dp = IntArray(n + 1)

    repeat(m) {
        val a = i(); val b = i()
        computers[b].add(a)
    }

    var max = 0

    for(i in 1..n) {
        visited = BooleanArray(n + 1)
        dp[i] = dfs(i)
        max = max(max, dp[i])
    }

    val sb = StringBuilder()

    for(i in 1..n) if(max == dp[i]) sb.append(i).append(" ")

    print(sb)
}

fun dfs(node: Int): Int {
    visited[node] = true
    var ret = 1

    for(n in computers[node]) {
        if(visited[n]) continue
        ret += dfs(n)
    }

    return ret
}
