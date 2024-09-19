import java.util.*
fun main()=with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = Array(n) {
        when(val c = st.nextToken().toInt()) {
            0 -> {' '}
            in 1..26 -> {'A'+c-1}
            else -> {'a'+c-27}
        }
    }
    val str = readLine()
    arr.sort()
    if(arr.joinToString()==str.toList().sorted().joinToString()) print("y") else print("n")
}