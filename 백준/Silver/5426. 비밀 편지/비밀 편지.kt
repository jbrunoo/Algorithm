fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val encode = readLine()
        val len = kotlin.math.sqrt(encode.length.toDouble()).toInt() - 1

        for(i in len downTo 0) {
            for(j in 0..len) {
                sb.append(encode[i + j * (len + 1)])
            }
        }
        sb.append("\n")
    }

    print(sb)
}