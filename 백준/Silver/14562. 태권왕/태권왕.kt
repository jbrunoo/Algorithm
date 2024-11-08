import java.util.*
lateinit var q: ArrayDeque<Score>
fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    q=ArrayDeque()
    StringBuilder().run{
        repeat(i()){
            q.clear()
            q.offer(Score(i(),i(),0))
            appendLine(bfs())}
        print(this)
    }
}
fun bfs():Int{
    while(q.isNotEmpty()){
        val(s,t,c)=q.poll()
        if(s==t)return c
        if(s*2<=t+3)q.offer(Score(s*2,t+3,c + 1))
        if(s+1<=t)q.offer(Score(s+1,t,c+1))
    }
    return 0
}
data class Score(val s:Int, val t:Int, val c:Int)