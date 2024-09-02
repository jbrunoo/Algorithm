fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder(); val a = readLine().toInt()
    for(n in 1..a) if(30 % (n + 1) == 0) sb.appendLine(n)
    print(sb)
}