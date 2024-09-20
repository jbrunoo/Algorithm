import java.io.StreamTokenizer

fun main()=StreamTokenizer(System.`in`.bufferedReader()).run{
    fun i():Long{nextToken();return nval.toLong()}
    val n=i().toInt();var d=i()
    val m=mutableListOf<Long>(); val e=mutableListOf<Long>()

    repeat(n){
        val a=i();val x=i()
        if(a==1L) m+=x else e+=x
    }

    var ret=0;var idxM = 0;var idxE = 0
    m.sort(); e.sort()
    while(true) {
        if(idxM < m.size && d > m[idxM]) {
            d+=m[idxM]
            idxM++
        } else if(idxE < e.size) {
            d*=e[idxE]
            idxE++
        } else break
        ret++
    }
    print(ret)
}