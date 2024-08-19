import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { BooleanArray(m) }
    var min = 32

    repeat(n) { i ->
        val str = readLine()
        for ((j, c) in str.withIndex()) {
            arr[i][j] = c == 'B'
        }
    }

    for (i in 0 until n - 7) {
        for (j in 0 until m - 7) {
            val tmp = count(i, j, arr)
            if (min > tmp) min = tmp
        }
    }

    print(min)
}

fun count(x: Int, y: Int, arr: Array<BooleanArray>): Int {
    val start = arr[x][y]
    val idx = (x + y) % 2
    var t1 = 0
    var t2 = 0

    for (i in x..x + 7) {
        for (j in y..y + 7) {
            if (idx == (i + j) % 2) {
                if (start == arr[i][j]) t1++
                if (start != arr[i][j]) t2++
            } else {
                if (start != arr[i][j]) t1++
                if (start == arr[i][j]) t2++
            }
        }
    }

    return min(t1, t2)
}