fun main() {
    while(true) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        if(a == b) break
        if(a > b) {
            if(a % b == 0) println("multiple")
            else println("neither")
        } else {
            if(b % a == 0) println("factor")
            else println("neither")
        }
    }
}