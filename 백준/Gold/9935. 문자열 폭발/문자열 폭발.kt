fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val explode = readLine()
    val len = explode.length
    val last = explode.last()
    val sb = StringBuilder()

    for (c in str) {
        sb.append(c)

        if (sb.length >= len && sb.last() == last) {
            var bool = true

            for (i in 0 until len) {
                if (sb[sb.length - 1 - i] == explode[len - 1 - i]) Unit
                else {
                    bool = false
                    break
                }
            }

            if (bool) sb.delete(sb.length - len, sb.length)
        }
    }

    print(sb.ifEmpty { "FRULA" })
}