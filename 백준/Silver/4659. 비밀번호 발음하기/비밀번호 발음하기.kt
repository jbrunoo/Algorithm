const val VOWEL = "aeiou"

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val word = readLine()
        if (word == "end") break

        val isAcceptable = rule(word)
        sb.appendLine("<$word> is ${if(isAcceptable)"acceptable" else "not acceptable"}.")
    }

    print(sb)
}

fun rule(word: String): Boolean {
    var hasVowel = false
    var vo = 0
    var co = 0
    var pre = ' '

    for (c in word) {
        if (c in VOWEL) {
            hasVowel = true
            vo++; co = 0
        } else {
            co++; vo = 0
        }
        if (vo == 3 || co == 3) return false
        if (c != 'e' && c != 'o' && pre == c) return false
        pre = c
    }

    return hasVowel
}