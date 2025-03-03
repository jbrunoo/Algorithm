fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {nextToken(); return nval.toInt() }
    val sb = StringBuilder()
    repeat(i()) { sb.append((calc(i(),i(),i(),i()))).append("\n") }
    print(sb)
}

private fun calc(m: Int, n: Int, x: Int, y: Int): Int {
    var sum = x
    val lcm = m * n / gcp(m, n)

    while (lcm >= sum) {
        if ((sum - y) % n == 0) return sum
        sum += m
    }

    return -1
}

fun gcp(a: Int, b: Int): Int = if(b == 0) a else gcp(b, a % b)