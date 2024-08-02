fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val s = readLine()
        val alphabet = IntArray(26)

        for(c in s) {
            if(c != ' ') alphabet[c - 'a']++
        }

        val max = alphabet.max()
        val cnt = alphabet.count { it == max }
        if(cnt != 1) println("?")
        else println((alphabet.indexOf(max) + 97).toChar())
    }
}