fun main() {
    var n = readln().toInt()
    var result = 0

    while(true) {
        if(n % 5 == 0) {
            result += n / 5
            break
        }
        else {
            n -= 3
            result++
            if(n < 0){
                result = -1
                break
            }
        }
    }

    println(result)
}

