fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val s = readLine()
    print(s.substring(n-5))
}