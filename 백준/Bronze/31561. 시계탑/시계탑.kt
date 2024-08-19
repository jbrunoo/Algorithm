fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toDouble()

    val ans = if(n <= 30) n / 2
    else (n - 30) * 3 / 2 + 15

    println(ans)
}