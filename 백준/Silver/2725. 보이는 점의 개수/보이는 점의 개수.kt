private lateinit var dp: IntArray
fun main()=with(System.`in`.bufferedReader()){
    fun i()=readLine().toInt()
    val sb=StringBuilder()
    dp=IntArray(1001){-1}
    dp[0]=0;dp[1]=3;dp[2]=5
    repeat(i()){val n=i();sb.appendLine(count(n))}
    print(sb)
}

fun count(n:Int):Int{
    if(dp[n]!=-1)return dp[n]
    var cnt=0
    for(i in 2 until n)if(gcd(i,n)==1)cnt++
    dp[n]=count(n-1)+(cnt+1)*2
    return dp[n]
}
fun gcd(a:Int,b:Int):Int=if(b==0)a else gcd(b,a%b)