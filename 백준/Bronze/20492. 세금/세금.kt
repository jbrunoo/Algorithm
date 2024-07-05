fun main() {
    val price = readln().toInt()
    println("${price - price * 22 / 100} ${price - price * 1/5 * 22 / 100}")
}