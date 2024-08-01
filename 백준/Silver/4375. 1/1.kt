fun main() = with(System.`in`.bufferedReader()) {
    while(true) {
        val n = readLine() ?: break

        println(pow(n.toInt()))
    }
}

fun pow(n: Int, num: Long = 1, k: Int = 1): Int {
    if(num % n == 0L) return k

    val ret = pow(n, (num * 10 + 1) % n, k + 1)
    return ret
}