fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val s = readLine().replace(" ","")
        val alphabet = IntArray(26)

        for(c in s) {
            alphabet[c.code - 97]++
        }
        val maxValue = alphabet.max()
        val maxAlphabet = alphabet.filter { it == maxValue }
        if (maxAlphabet.count() == 1) println((alphabet.indexOf(maxValue) + 97).toChar())
        else println("?")
    }
}