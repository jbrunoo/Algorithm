fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val set = mutableSetOf<String>()

    repeat(n) {
        set.add(readLine())
    }

    val sb = StringBuilder()

    val sorted = set.sortedWith { o1, o2 ->
        if (o1.length == o2.length) o1.compareTo(o2)
        else o1.length.compareTo(o2.length)
    }

    for(str in sorted) {
        sb.append(str).append("\n")
    }

    print(sb)
}