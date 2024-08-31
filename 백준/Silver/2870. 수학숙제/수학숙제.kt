import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val li = mutableListOf<BigInteger>()

    repeat(n) {
        val row = readLine()

        var str = ""
        for(i in row.indices) {
            if(row[i] in '0'..'9') str += row[i]
            if(str.isNotEmpty() && (row[i] !in '0'..'9' || i == row.lastIndex)) {
                li.add(str.toBigInteger())
                str = ""
            }
        }
    }
    li.sort()
    val sb = StringBuilder()
    for(i in li) {
        sb.append(i)
        if(i != li.last()) sb.append("\n")
    }

    print(sb)
}