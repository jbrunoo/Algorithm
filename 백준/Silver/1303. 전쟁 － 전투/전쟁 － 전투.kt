import java.util.*

private lateinit var arr: Array<CharArray>
private lateinit var Wvisited: Array<BooleanArray>
private lateinit var Bvisited: Array<BooleanArray>
var n = 0
var m = 0
val dx = listOf(-1, 0, 1, 0)
val dy = listOf(0, -1, 0, 1)
var cnt = 0

fun main()= with(System.`in`.bufferedReader()){
    val st=StringTokenizer(readLine())
    n=st.nextToken().toInt();m=st.nextToken().toInt()
    arr=Array(m){CharArray(n)}
    repeat(m){i->
        val row=readLine()
        for((j, c)in row.withIndex())arr[i][j]=c
    }

    val white = mutableListOf<Int>()
    val blue = mutableListOf<Int>()

    Wvisited = Array(m) { BooleanArray(n) }
    Bvisited = Array(m) { BooleanArray(n) }
    for(i in 0 until m ) {
        for(j in 0 until n) {
            if(arr[i][j] == 'W' && !Wvisited[i][j]) {
                white += dfs(i, j, Wvisited, 'W')
                cnt=0
            } else if(arr[i][j] == 'B' && !Bvisited[i][j]) {
                blue += dfs(i, j, Bvisited,'B')
                cnt=0
            }
        }
    }

    println("${white.sumOf { it * it }} ${blue.sumOf { it * it }}")
}

fun dfs(x: Int, y:Int, visited: Array<BooleanArray>, color: Char): Int {
    visited[x][y] = true
    cnt++

    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue
        if(!visited[nx][ny] && arr[nx][ny] == color) {
            visited[nx][ny] = true
            dfs(nx, ny, visited, color)
        }
    }

    return cnt
}