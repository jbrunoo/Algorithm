fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val arr = IntArray(26)

    for(c in s) {
       arr[c.code - 97]++
    }

    for(i in arr) {
        print("$i ")
    }
}