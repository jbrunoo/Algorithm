fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val sb = StringBuilder()

    for(c in s) {
        if(c.code in 65 ..65 + 25) {
            if(c.code + 13 > 65 + 25) sb.append((65 + (c.code + 13) % 91).toChar())
            else sb.append((c.code + 13).toChar())
        }
        else if(c.code in 97..97 + 25) {
            if(c.code + 13 > 97 + 25) sb.append((97 + (c.code + 13) % 123).toChar())
            else sb.append((c.code + 13).toChar())
        }
        else sb.append(c)
    }
    println(sb)
}