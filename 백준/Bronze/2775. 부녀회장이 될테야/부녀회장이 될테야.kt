val arr = Array(15) { IntArray(15) }

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    for(i in 0..14) {
        arr[0][i] = i
        arr[i][1] = 1
    }

    repeat(t) {
        val k = readLine().toInt()
        val n = readLine().toInt()

        sb.appendLine(dp(k, n))
    }

    print(sb)
}

fun dp(k: Int, n: Int): Int {
    if(arr[k][n] != 0) return arr[k][n]
    arr[k][n] = dp(k-1, n) + dp(k, n-1)
    return arr[k][n]
}