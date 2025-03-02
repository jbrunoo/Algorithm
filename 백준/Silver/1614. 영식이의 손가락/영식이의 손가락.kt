fun main() = with(System.`in`.bufferedReader()) {
    val f = readLine().toInt()
    val n = readLine().toInt()
    var sum = 0L

    if(n == 0) {
        print(f - 1)
        return@with
    }

    when (f) {
        1, 5 -> sum = 8L * n
        2 -> sum = 8L * (n / 2) + if (n % 2 != 0) 6 else 0
        4 -> sum = 8L * (n / 2) + if (n % 2 != 0) 2 else 0
        3 -> sum = 4L * n
    }

    print(f + sum - 1)
}