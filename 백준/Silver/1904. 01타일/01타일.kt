val arr = IntArray(1000001)

fun main() = with(System.`in`.bufferedReader()) {
    arr[0] = 1
    arr[1] = 2

    val n = readLine().toInt()

    println(seq(n))
}

fun seq(n: Int): Int {
    if(n == 1) return arr[0]
    if(n == 2) return arr[1]
    if(arr[n] != 0) return arr[n]

    arr[n] = (seq(n - 1) + seq(n - 2)) % 15746
    return arr[n]
}
