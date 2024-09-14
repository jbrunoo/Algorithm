import java.io.StreamTokenizer
private lateinit var dp:Array<IntArray>
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    val r=i()-1;val c=i()-1;val w=i()
    dp=Array(29){ IntArray(29)}
    dp[0][0]=1;dp[1][0]=1;dp[1][1]=1
    var d=0;var cnt=0
    for(i in r until r+w) {
        d++;for(j in c until c+d)cnt+=p(i,j)
    }
    print(cnt)
}

fun p(r:Int,c:Int):Int{
    if(c==0)return 1
    if(r<=1)return dp[r][c]
    if(dp[r][c]!=0) return dp[r][c]
    dp[r][c]=p(r-1, c-1)+p(r-1,c)
    return dp[r][c]
}