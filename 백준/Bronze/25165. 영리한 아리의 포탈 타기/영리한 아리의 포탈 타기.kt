import java.io.StreamTokenizer
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()};val n=i();i();val a=i();val d=i();val s=i();val S=i()
    if(d==0) {
        if(s==1&&a<S) p(0)
        else if(s==n && n%2==1) p(0)
        else p(1)
    } else {
        if(s==1 && a>S) p(0)
        else if(s==n && n%2==0) p(0)
        else p(1)
    }
}
fun p(n:Int)=print(if(n==0)"YES!" else "NO...")