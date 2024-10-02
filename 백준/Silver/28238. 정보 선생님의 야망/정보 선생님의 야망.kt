fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken();return nval.toInt()
    }

    val n = i()
    val arr = Array(n) { IntArray(5) }
    repeat(n) { arr[it] = IntArray(5) { i() } }

    var max = 0
    var day = Pair(0, 0)
    for (i in 0..4) {
        for (j in i + 1..4) {
            var cnt = 0
            for(k in 0 until n) {
                if(arr[k][i] == 1 && arr[k][j] == 1) cnt++
            }
            if(cnt > max) {
                max = cnt
                day = Pair(i, j)
            }
        }
    }
    
    val sb = StringBuilder()
    sb.append(max).append("\n")
    if(day.second == 0) {
        sb.append("1 1 0 0 0")
    } else {
        repeat(5) { sb.append(if(it == day.first || it == day.second) 1 else 0).append(" ") }
    }
    print(sb)
}