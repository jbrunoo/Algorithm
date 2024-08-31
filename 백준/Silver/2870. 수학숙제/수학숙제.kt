fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val li = mutableListOf<String>()

    repeat(n) {
        val row = readLine()

        var str = ""
        for(i in row.indices) {
            if(row[i] in '0'..'9') str += row[i]
            if(str.isNotEmpty() && (row[i] !in '0'..'9' || i == row.lastIndex)) {
                var cnt = 0
                for(c in str) {
                    if(c == '0') cnt++
                    else break
                }
                if(cnt == str.length) li.add("0")
                else li.add(str.substring(cnt until str.length))
                str = ""
            }
        }
    }
    li.sortBy { it.toBigInteger() }
    val sb = StringBuilder()
    for(i in li) {
        sb.append(i)
        if(i != li.last()) sb.append("\n")
    }

    print(sb)
}