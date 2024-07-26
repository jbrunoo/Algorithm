var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val s = readLine()
        sb.appendLine(vps(s))
    }

    print(sb)
}

fun vps(s: String): String {
    val st = ArrayList<Char>()

    for(c in s) {
        if(c == '(') {
            st.add(0, c)
        } else {
            if(st.isEmpty()) return "NO"
            else if(st.last() == '(') st.removeLast()
        }
    }

    return if(st.isEmpty()) "YES" else "NO"
}