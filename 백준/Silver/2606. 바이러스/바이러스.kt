private lateinit var connections: Array<MutableList<Int>>
private lateinit var visited: BooleanArray
private var count = 0

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt() }
    val n = i()

    connections = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    repeat(i()) {
        val a = i(); val b = i()

        connections[a] += b
        connections[b] += a
    }

    dfs()

    print(count)
}

fun dfs(index: Int = 1) {
    visited[index] = true

    for(i in connections[index]) {
        if(visited[i]) continue
        count++
        dfs(i)
    }
}