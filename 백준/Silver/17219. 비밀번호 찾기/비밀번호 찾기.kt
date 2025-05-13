fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sites = HashMap<String, String>()

    repeat(n) {
        val (s, p) = readLine().split(" ")
        sites[s] = p
    }

    val sb = StringBuilder()

    repeat(m) {
        val p = sites[readLine()]
        sb.append(p).append("\n")
    }

    print(sb)
}