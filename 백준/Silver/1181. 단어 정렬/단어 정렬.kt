fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val set = mutableSetOf<String>()

    repeat(n) {
        set.add(readLine())
    }

    val sorted = set.sortedWith(
        compareBy<String> { it.length }.thenBy { it }
    )

    val sb = StringBuilder()

    for(str in sorted) {
        sb.append(str).append("\n")
    }

    print(sb)
}