fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine()[0] }
    val sb = StringBuilder()

    for(c in arr.toSet().sorted()) {
        if(arr.count { it == c } >= 5) sb.append(c)
    }

    if(sb.isEmpty()) print("PREDAJA") else print(sb)
}