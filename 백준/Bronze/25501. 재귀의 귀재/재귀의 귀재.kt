var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()
        val result = isPalindrome(s)
        sb.appendLine("${result.first} ${result.second}")
        cnt = 0
    }

    print(sb)
}

fun recursion(s: String, l: Int, r: Int): Pair<Int, Int> {
    cnt++
    return if(l >= r) Pair(1, cnt)
    else if(s[l] != s[r]) Pair(0, cnt)
    else recursion(s, l+1, r-1)

}

fun isPalindrome(s: String): Pair<Int, Int> {
    return recursion(s, 0, s.length -1)
}