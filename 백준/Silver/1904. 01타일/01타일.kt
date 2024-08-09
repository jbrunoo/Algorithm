val arr = IntArray(1000001)

fun main() = with(System.`in`.bufferedReader()) {
    arr[1] = 1
    arr[2] = 2

    val n = readLine().toInt()

    println(seq(n))
}

fun seq(n: Int): Int {
    if(n == 1) return arr[1]
    if(n == 2) return arr[2]
    if(arr[n] != 0) return arr[n]
    for(i in 3..n) {
        arr[i] = (arr[i - 1] + arr[i - 2]) % 15746
    }
    return arr[n] % 15746
}
