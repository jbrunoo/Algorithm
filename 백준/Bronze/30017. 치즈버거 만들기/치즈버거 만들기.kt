fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }

    val ans = if(a <= b) 2 * a - 1
    else 2 * b + 1

    print(ans)
}