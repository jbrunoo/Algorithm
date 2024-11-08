import java.util.*
fun main()=java.io.StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Int{nextToken();return nval.toInt()}
    StringBuilder().run{
        repeat(i()){
            val q=ArrayDeque<Score>()
            q.offer(Score(i(),i(),0))
            while(q.isNotEmpty()){
                val(s,t,c)=q.poll()
                if(s==t){appendLine(c);break}
                if(s*2<=t+3)q.offer(Score(s*2,t+3,c+1))
                if(s+1<=t)q.offer(Score(s+1,t,c+1))
            }}
        print(this)
    }
}
data class Score(val s:Int, val t:Int, val c:Int)