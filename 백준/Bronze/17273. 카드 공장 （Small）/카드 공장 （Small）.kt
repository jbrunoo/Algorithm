fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (a, b) = readLine().split(" ").map { it.toInt() }
    var ans = a

    repeat(m) {
        val k = readLine().toInt()
        if (ans < k) {
            ans = if (ans == a) b else a
        }
    }
    print(ans)
}   