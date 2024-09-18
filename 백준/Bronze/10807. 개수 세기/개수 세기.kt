import java.io.StreamTokenizer
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{fun i():Int{nextToken();return nval.toInt()};val n=i();val a=IntArray(n){i()};val v=i();print(a.count{it==v})}
