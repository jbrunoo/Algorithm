fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt(); val sb = StringBuilder()

    repeat(t) {
        val n = readLine().toInt()
        var f = 5; var cnt = 0
        while(n >= f) {
            cnt += n / f; f *= 5
        }
        sb.appendLine(cnt)
    }
    print(sb)
}