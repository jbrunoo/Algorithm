fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    var sum=0;var prev=0;var prevValue=0
    repeat(i()){val a=i();prevValue=if(prev==a)prevValue*2 else 2;sum+=prevValue;prev=a;if(sum>=100){sum=0;prev=0;prevValue=0}};print(sum)}