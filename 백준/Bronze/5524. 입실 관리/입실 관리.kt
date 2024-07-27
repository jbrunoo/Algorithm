fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()

        for(c in s) {
            if(c.code >= 97) sb.append(c)
            else sb.append(c + 32)
        }
        sb.appendLine()
    }

    print(sb)
}

