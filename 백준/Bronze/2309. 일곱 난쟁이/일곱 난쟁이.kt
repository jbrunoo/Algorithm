fun main() = with(System.`in`.bufferedReader()) {
    val heights = MutableList(9){ readLine().toInt() }
    val sum = heights.sum()
    val sb = StringBuilder()

    for(i in heights) {
        for(j in heights - i) {
            if (sum - i - j == 100) {
                heights.remove(i)
                heights.remove(j)
                for(h in heights.sorted()) sb.appendLine(h)
                println(sb)
                return
            }
        }
    }
}