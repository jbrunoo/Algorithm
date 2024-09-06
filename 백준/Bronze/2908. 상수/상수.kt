import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    fun i(): String = st.nextToken()
    val a = i(); val b = i()
    val a1 = a[2] + a[1].toString() + a[0]
    val b1 = b[2] + b[1].toString() + b[0]

    if(a[2] > b[2]) print(a1)
    else if(a[2] < b[2]) print(b1)
    else {
        if(a[1] > b[1]) print(a1)
        else if(a[1] < b[1]) print(b1)
        else {
            if(a[0] > b[0]) print(a1)
            else print(b1)
        }
    }
}