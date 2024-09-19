import java.util.*
fun main()=with(System.`in`.bufferedReader()){
    val st=StringTokenizer(readLine());val s=st.nextToken().toInt();val m=st.nextToken().toInt()
    if(s<1024)print("No thanks")else if(m and s-1023==s-1023)print("Thanks")else print("Impossible")
}