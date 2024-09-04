import java.util.*

private lateinit var adj: Array<MutableList<Int>>
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    adj = Array(n) { mutableListOf() }

    val st = StringTokenizer(readLine())
    var root = 0

    for (i in 0 until n) {
        val node = st.nextToken().toInt()
        if (node == -1) root = i
        else adj[node] += i
    }

    val skipNode = readLine().toInt()

    println(if(skipNode == root) 0 else dfs(root, skipNode))
}



fun dfs(node: Int, skipNode: Int): Int {
    var ret = 0
    var child = 0

    for (n in adj[node]) {
        if(n == skipNode) continue
        ret += dfs(n, skipNode)
        child++
    }
    if (child == 0) return 1

    return ret
}
