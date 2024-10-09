fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun l():Long{nextToken();return nval.toLong()};val k=l();val a=l();val b=l()
    if(a==0L && b==0L){print(1);return}
    print(b/k-a/k+if(a>0&&a%k==0L)1 else if(b<0&&b%k==0L)1 else if((a<0&&b>0)||a==0L||b==0L)1 else 0)}