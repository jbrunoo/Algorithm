fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var sum = 1
    var tmp = 0

    while(tmp < n){
        tmp += sum
        sum++
    }

    if(sum%2 == 0){
        val molecule = (tmp - n + 1)
        val denominator = sum - molecule
        println("$molecule/$denominator")
    }

    else{
        val denominator = (tmp - n + 1)
        val molecule = sum - denominator
        println("$molecule/$denominator")
    }
}
