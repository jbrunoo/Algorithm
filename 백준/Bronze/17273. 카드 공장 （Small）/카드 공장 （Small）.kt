fun main() = with(System.`in`.bufferedReader()){
    val (_, m) = readLine().split(" ").map { it.toInt() }
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val arr = intArrayOf(a, b)
    var bool = true
    repeat(m) { val k = readLine().toInt();
        if (bool && arr[0] < k || !bool && arr[1] < k) bool = !bool
    }
    print(if(bool) a else b)
}