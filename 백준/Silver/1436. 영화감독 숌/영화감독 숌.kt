fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(10001)
    arr[1] = 666
    var num = 1666
    var cnt = 1

    while(true) {
        if(n == cnt) {
            print(arr[n])
            break
        }
        if("666" in num.toString()) {
            cnt++
            arr[cnt] = num
        }
        num++
    }
}