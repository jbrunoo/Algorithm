var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()
        sb.appendLine(if(vps(s)) "YES" else "NO" )
    }

    print(sb)
}

fun vps(s: String): Boolean {
    var cnt = 0

    for(c in s) {
        if(c == '(') {
            cnt++
        } else {
            if(cnt == 0) return false
            else cnt--
        }
    }

    return cnt == 0
}