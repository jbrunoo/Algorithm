fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val arr = IntArray(26)

    for(c in s) {
       arr[c.code - 97]++
    }

    println(arr.joinToString(" "))
}