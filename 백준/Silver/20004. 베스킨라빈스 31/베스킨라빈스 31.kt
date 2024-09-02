fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val a = readLine().toInt()

    for(n in 1..a) {
        val min = 30 % (n + 1)
        val win = if(min == 0) n + 1 else min
        if(win !in 1..n) sb.appendLine(n)
    }

    print(sb)
}