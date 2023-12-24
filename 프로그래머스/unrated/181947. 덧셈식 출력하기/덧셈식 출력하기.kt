fun main(args: Array<String>) {
    val (a, b) = readln().split(' ').map(String::toInt)
    println("$a + $b = ${a+b}")
}