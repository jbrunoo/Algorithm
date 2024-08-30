lateinit var arr: Array<String>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    arr = Array(n) { readLine() }
    quadTree(0, 0, n)
    print(sb)
}

fun quadTree(a: Int, b: Int, size: Int) {
    val first = arr[a][b]
    var t = false

    for (i in a until a + size) {
        for (j in b until b + size) {
            if (arr[i][j] != first) { t = true }
        }
        if(t) break
    }

    if(t) {
        val new = size / 2
        sb.append("(")
        quadTree(a, b, new)
        quadTree(a, b + new, new)
        quadTree(a + new, b, new)
        quadTree(a + new, b + new, new)
        sb.append(")")
    } else {
        sb.append(first)
    }
}
