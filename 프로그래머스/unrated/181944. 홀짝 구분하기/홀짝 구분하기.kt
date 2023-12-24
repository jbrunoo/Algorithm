fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    if(1 <= a && a <= 1000) {
        if(a%2==0) println("$a is even")
        else println("$a is odd")
    }
}