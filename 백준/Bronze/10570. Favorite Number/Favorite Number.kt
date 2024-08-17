fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) {
        val arr = IntArray(1001)
        val v = readLine().toInt()

        repeat(v) {
            val s = readLine().toInt()
            arr[s]++
        }

        val max = arr.max()
        println(arr.indexOfFirst { it == max })
    }

}