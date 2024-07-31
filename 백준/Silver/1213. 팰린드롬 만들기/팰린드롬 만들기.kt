fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val arr = IntArray(26)
    val sb = StringBuilder()

    for (c in s) {
        arr[c.code - 65]++
    }

    val oddNum = arr.filter { it % 2 != 0 }

    when (oddNum.size) {
        0, 1 -> {}
        else -> {
            println("I'm Sorry Hansoo")
            return
        }
    }

    for ((i, cnt) in arr.withIndex()) {
        val newChar = (i + 65).toChar()
        repeat(cnt / 2) {
            sb.append(newChar)
        }
    }

    if (oddNum.isNotEmpty()) sb.append((arr.indexOf(oddNum.first()) + 65).toChar())

    for ((i, cnt) in arr.withIndex().reversed()) {
        val newChar = (i + 65).toChar()
        repeat(cnt / 2) {
            sb.append(newChar)
        }
    }

    println(sb)
}