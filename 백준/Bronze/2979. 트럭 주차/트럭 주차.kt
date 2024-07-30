fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(100)
    var cost = 0

    repeat(3) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        for(i in s until e) arr[i]++
    }

    for(i in arr) {
        when(i) {
            1 -> { cost += 1 * a }
            2 -> { cost += 2 * b }
            3 -> { cost += 3 * c }
        }
    }
    println(cost)
}