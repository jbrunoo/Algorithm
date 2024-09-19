fun main() = with(System.`in`.bufferedReader()) {
    val(s,m)=readLine().split(" ").map{it.toInt()}
    if(s<1024)print("No thanks")
    else if(m and s-1023==s-1023)print("Thanks")
    else print("Impossible")
}