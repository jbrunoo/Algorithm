fun main() = with(System.`in`.bufferedReader()){
    val len = readLine().toInt()
    val s = readLine()
    val vowel = listOf('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm')


    if(s[len-1] in vowel) println("0") else println("1")
}

