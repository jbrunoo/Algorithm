fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()
        var cnt = 0

        for(c in s) {
            if(cnt < 0) break
            if(c == '(') cnt++
            else cnt--
        }
        sb.appendLine(if(cnt==0) "YES" else "NO")
    }

    print(sb)
}