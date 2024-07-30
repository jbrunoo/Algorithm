fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val e = s.length
    for(i in 0..s.length / 2) {
        if(s[i] != s[e - i - 1]) {
            println(0)
            return
        }
    }
    println(1)
}