fun main()= with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val li = charArrayOf('0', '1', '2', '3', '5', '6', '8', '9')

    for (i in n downTo 4) {
        var flag = true
        for (j in li) {
            if (i.toString().contains(j)) {
                flag = false
                break
            }
        }
        if (flag) {
            print(i)
            break
        }
    }
}