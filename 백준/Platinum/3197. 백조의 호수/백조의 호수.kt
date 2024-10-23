import java.util.*

lateinit var arr: Array<IntArray>
lateinit var swanVisited: Array<BooleanArray>
lateinit var waterVisited: Array<BooleanArray>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var r = 0
var c = 0
lateinit var waterQ: ArrayDeque<Int>
lateinit var tempWaterQ: ArrayDeque<Int>
lateinit var swanQ: ArrayDeque<Int>
lateinit var tempSwanQ: ArrayDeque<Int>


fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    fun i() = st.nextToken().toInt()
    r = i(); c = i()
    arr = Array(r) { IntArray(c) }
    val pos = mutableListOf<Int>()
    swanQ = ArrayDeque<Int>()
    tempSwanQ = ArrayDeque<Int>()
    waterQ = ArrayDeque<Int>()
    tempWaterQ = ArrayDeque<Int>()
    swanVisited = Array(r) { BooleanArray(c) }
    waterVisited = Array(r) { BooleanArray(c) }

    repeat(r) {
        val row = readLine()
        for ((i, v) in row.withIndex()) {
            arr[it][i] = when (v) {
                '.' -> {
                    waterVisited[it][i] = true
                    waterQ.offer(10000 * it + i)
                    0
                }
                'X' -> 1
                else -> {
                    waterVisited[it][i] = true
                    waterQ.offer(10000 * it + i)
                    pos.addAll(listOf(it, i))
                    2
                }
            }
        }
    }


    val x1 = pos[0]; val y1 = pos[1]
    val n1 = 10000 * x1 + y1
    swanQ.offer(n1)
    swanVisited[x1][y1] = true

    var day = 0
    while(true) {
        if(swanBfs()) break
        waterBfs()
        swanQ.addAll(tempSwanQ)
        waterQ.addAll(tempWaterQ)
        tempSwanQ.clear()
        tempWaterQ.clear()
        day++
    }

    print(day)
}

fun swanBfs(): Boolean {
    while(swanQ.isNotEmpty()) {
        val x = swanQ.peek() / 10000; val y = swanQ.poll() % 10000

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || swanVisited[nx][ny]) continue
            swanVisited[nx][ny] = true
            if (arr[nx][ny] == 0) swanQ.offer(10000 * nx + ny)
            else if (arr[nx][ny] == 1) tempSwanQ.offer(10000 * nx + ny)
            else if (arr[nx][ny] == 2) return true
        }
    }
    return false
}

fun waterBfs() {
    while(waterQ.isNotEmpty()) {
        val x = waterQ.peek() / 10000; val y = waterQ.poll() % 10000

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || waterVisited[nx][ny]) continue
            if(arr[nx][ny] == 1) {
                waterVisited[nx][ny] = true
                tempWaterQ.offer(10000 * nx + ny)
                arr[nx][ny] = 0
            }
        }
    }
}
