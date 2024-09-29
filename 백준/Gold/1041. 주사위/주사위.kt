import kotlin.math.min
fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun l():Long{nextToken();return nval.toLong()}
    val n=l();val a=LongArray(6){l()}
    val d=listOf(min(a[0],a[5]),min(a[1],a[4]),min(a[2],a[3])).sorted()
    print(when(n){
        1L->a.sum()-a.max()
        2L->d[0]*8+d[1]*8+d[2]*4
        else->d[0]*(5*n*n-8*n+4)+d[1]*8*(n-1)+d[2]*4})}