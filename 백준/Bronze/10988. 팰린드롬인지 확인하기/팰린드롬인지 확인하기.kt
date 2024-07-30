fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    if(s == s.reversed()) println(1)
    else println(0)
}