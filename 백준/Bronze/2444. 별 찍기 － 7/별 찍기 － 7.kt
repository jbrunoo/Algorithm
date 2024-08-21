val sb = StringBuilder()

fun main() {
    val n = readln().toInt()
    
    for (i in 1 until n) {
        draw(n, i)
        sb.append("\n")
    }
    for(i in 1 until 2 * n) {
        sb.append("*")
    }
    sb.append("\n")
    for (i in n - 1 downTo 1) {
        draw(n, i)
        if(i != 1) sb.append("\n")
    }
    
    print(sb)
}

fun draw(n: Int, i: Int) {
    for(j in 1..n - i) {
        sb.append(" ")
    }
    for(j in 1 until 2 * i) {
        sb.append("*")
    }
}