fun main() = with(System.`in`.bufferedReader()) {
    val (s1, s2, s3) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<Int, Int>()

    for(f in 1..s1) {
        for(s in 1..s2) {
            for(t in 1..s3) {
                val key = f + s + t
                map[key] = map.getOrDefault(key, 0) + 1
            }
        }
    }

    val maxValue = map.values.max()
    println(map.filterValues { it == maxValue }.keys.first())
}