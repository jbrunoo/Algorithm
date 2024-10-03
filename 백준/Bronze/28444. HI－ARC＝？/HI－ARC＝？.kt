fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()}
    print(i()*i()-i()*i()*i())
}