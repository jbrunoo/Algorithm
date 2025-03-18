fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = java.util.PriorityQueue<String> { o1, o2 ->
        if (o1.length == o2.length) o1.compareTo(o2)
        else o1.length.compareTo(o2.length)
    }

    repeat(n) {
        val str = readLine()
        if (str !in pq) pq.offer(str)
    }

    val sb = StringBuilder()

    while (pq.isNotEmpty()) {
        sb.append(pq.poll()).append("\n")
    }

    print(sb)
}