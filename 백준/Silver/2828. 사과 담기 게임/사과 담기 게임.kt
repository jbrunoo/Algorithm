fun main() = with(System.`in`.bufferedReader()) {
    val (_, m) = readLine().split(" ").map { it.toInt() }
    val j = readLine().toInt()
    var left = 1; var right = m
    var cnt = 0

    repeat(j) {
        val apple = readLine().toInt()

        if (apple > right) {
            val d = apple - right
            cnt += d; left += d; right += d
        }
        else if (apple < left) {
            val d = left - apple
            cnt += d; left -= d; right -= d
        }
    }

    print(cnt)
}