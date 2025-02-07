fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val explode = readLine()
    val len = explode.length
    val sb = StringBuilder()

    str.forEach {
        sb.append(it)

        if (sb.length >= len) {
            if (explode == sb.slice(sb.length - len until sb.length)) {
                sb.delete(sb.length - len, sb.length)
            }
        }
    }

    print(sb.ifEmpty { "FRULA" })
}