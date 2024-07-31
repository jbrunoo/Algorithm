fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = HashMap<String, Int>()

    repeat(n) {
        val n2 = readLine().toInt()

        repeat(n2) {
            val (_, k) = readLine().split(" ")
            if(map.containsKey(k)) map[k] = map[k]!! + 1
            else map[k] = 2
        }
        
        println(map.values.fold(1) { i, acc -> i * acc } - 1)
        map.clear()
    }
}