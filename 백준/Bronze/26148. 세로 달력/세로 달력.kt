fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    readLine()

    var leap = 0
    if (n % 400 == 0) leap++
    else if (n % 4 == 0 && n % 100 != 0) leap++

    print(29 + leap)
}