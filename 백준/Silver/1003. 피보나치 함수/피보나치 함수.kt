val memo = Array(41) {  Pair(0, 0) }

fun main() = with(System.`in`.bufferedReader()){
    memo[0] = Pair(1, 0)
    memo[1] = Pair(0, 1)

    val n1 = readLine().toInt()
    repeat(n1) {
        val n = readLine().toInt()

        println("${fib(n).first} ${fib(n).second}")
    }
}

fun fib(n: Int): Pair<Int, Int> {
    if(memo[n] == Pair(0, 0)) {
        val fir = fib(n - 1).second
        val sec = fir + fib(n - 1).first
        memo[n] = Pair(fir, sec)
    }

    return memo[n]
}

