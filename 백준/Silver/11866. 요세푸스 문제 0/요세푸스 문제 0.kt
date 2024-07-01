fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val li = MutableList(N) { it + 1 }
    var k = 0
    val result = mutableListOf<Int>()

    while (li.isNotEmpty()) {
        k = (k + K - 1) % li.size
        result += li[k]
        li.removeAt(k)
    }

    println(result.joinToString(", ", prefix = "<", postfix = ">"))
}
