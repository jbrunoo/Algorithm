val vowel = "aeiou"

fun main() = with(System.`in`.bufferedReader()) {
    val format1 = "> is acceptable."
    val format2 = "> is not acceptable."
    val sb = StringBuilder()

    while(true) {
        val word = readLine()
        if(word == "end") break

        var isAcceptable = rule1(word)
        if(!isAcceptable) {
            sb.append("<$word").appendLine(format2)
            continue
        }
        isAcceptable = rule2(word)
        if(!isAcceptable) {
            sb.append("<$word").appendLine(format2)
            continue
        }
        isAcceptable = rule3(word)
        if(!isAcceptable) {
            sb.append("<$word").appendLine(format2)
            continue
        }
        sb.append("<$word").appendLine(format1)
    }

    print(sb)
}

fun rule1(word: String): Boolean {
    for(v in vowel) if(v in word) return true
    return false
}


fun rule2(word: String): Boolean {
    val len = word.length
    if(len < 3) return true
    for(i in 0..len-3) {
        var vo = 0
        var co = 0
        for(c in word.substring(i, i+3)) {
            if(c in vowel) vo++
            if(c !in vowel) co++
        }
        if(vo == 3 || co == 3) return false
    }
    return true
}


fun rule3(word: String): Boolean {
    val len = word.length
    if(len < 2) return true
    for(i in 0..len-2) {
        if(word[i] == 'e' || word[i] == 'o') continue
        if(word[i] == word[i+1]) return false
    }
    return true
}