fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map{ it.toInt() }
    val arr = IntArray(n)

    repeat(n) {
        arr[it] = readLine().toInt()
    }

    var ans = 0
    var change = k

    for(i in n - 1 downTo 0) {
        if(change >= arr[i]) {
            ans += change / arr[i]
            change %= arr[i]
        }
    }

    print(ans)
}