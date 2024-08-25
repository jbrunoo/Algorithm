fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map{ it.toInt() }
    val arr = IntArray(n)

    repeat(n) {
        arr[it] = readLine().toInt()
    }

    var ans = 0
    var change = k

    for(coin in arr.sortedDescending()) {
        if(change >= coin) {
            val tmp = change / coin
            ans += tmp
            change -= tmp * coin
        }
    }

    print(ans)
}