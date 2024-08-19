import java.util.*
fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val a1 = st.nextToken().toInt()
    val a0 = st.nextToken().toInt()
    val c = readLine().toInt()
    var n = readLine().toInt()

    while(n <= 100) {
        if(a1 * n + a0 > c * n) {
            print(0)
            break
        }
        n++
    }
    if(n == 101) print(1)
}