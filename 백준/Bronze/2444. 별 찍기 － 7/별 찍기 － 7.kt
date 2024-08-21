fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1 until n) {
        for(j in 1..n - i) {
            sb.append(" ")
        }
        for(j in 1 until 2 * i) {
            sb.append("*")
        }
        sb.append("\n")
    }
    for(i in 1 until 2 * n) {
        sb.append("*")
    }
    sb.append("\n")
    for (i in n - 1 downTo 1) {
        for(j in 1..n - i) {
            sb.append(" ")
        }
        for(j in 1 until 2 * i) {
            sb.append("*")
        }
        if(i != 1) sb.append("\n")
    }

    print(sb)
}