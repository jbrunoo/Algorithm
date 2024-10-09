import java.util.*
import kotlin.math.min

private lateinit var arr: Array<CharArray>
private lateinit var fire: Array<IntArray>
private lateinit var jihun: Array<IntArray>
private val queue = ArrayDeque<Pos>()
private var r = 0
private var c = 0
private var time = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    r = st.nextToken().toInt(); c = st.nextToken().toInt()
    arr = Array(r) { CharArray(c) }

    repeat(r) {
        val row = readLine()
        for ((i, v) in row.withIndex()) {
            arr[it][i] = v
        }
    }

    fire = Array(r) { IntArray(c) }
    jihun = Array(r) { IntArray(c) }

    var jihunPos = Pos(0, 0)

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (arr[i][j] == 'F') {
                queue.offer(Pos(i, j))
                fire[i][j] = 1
            } else if (arr[i][j] == 'J') {
                jihunPos = Pos(i, j)
                jihun[i][j] = 1
                // 시작부터 벽에 있으면 탈출
                if(isEnd(i, j)) {
                    print(1)
                    return
                }
            }
        }
    }

    bfs(isFire = true)
    queue.offer(Pos(jihunPos.x, jihunPos.y))
    bfs(isFire = false)

    if (time == Int.MAX_VALUE) print("IMPOSSIBLE") else print(time)
}

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun bfs(isFire: Boolean) {
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == '#') continue
            if(isFire) {
                if (fire[nx][ny] == 0) {
                    fire[nx][ny] = fire[x][y] + 1
                    queue.offer(Pos(nx, ny))
                }
            } else {
                if (jihun[nx][ny] == 0) {
                    jihun[nx][ny] = jihun[x][y] + 1
                    queue.offer(Pos(nx, ny))

                    if(isEnd(nx, ny)) {
                        if(jihun[nx][ny] < fire[nx][ny] || fire[nx][ny] == 0) {
                            val t = jihun[nx][ny]
                            time = min(time, t)
                        }
                    }
                }
            }
        }
    }
}

fun isEnd(x:Int, y:Int) = (x == 0 || x == r-1 || y == 0 || y == c-1)
data class Pos(val x: Int, val y: Int)