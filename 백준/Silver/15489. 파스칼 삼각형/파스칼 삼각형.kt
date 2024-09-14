import java.io.StreamTokenizer
private lateinit var dp:Array<IntArray>
fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    val r=i()-1;val c=i()-1;val w=i()
    dp=Array(29){ IntArray(29)}
    var cnt=0;for(i in 0.. w-1)for(j in 0..i)cnt+=p(r+i,c+j)
    print(cnt) 
}
fun p(r:Int,c:Int):Int{
    if(c==0||c==r)return 1
    if(dp[r][c]!=0)return dp[r][c]
    dp[r][c]=p(r-1,c-1)+p(r-1,c)
    return dp[r][c]
}