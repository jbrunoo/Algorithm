fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var fees = 0

    repeat(n) {
        val s = readLine()
        val hh = s.substring(0..1).toInt()
        val mm = s.substring(3..4).toInt()
        val dd = s.substring(6..7).toInt()

        var overflow = 0
        var feeTime = 0
        val isOverflow = mm + dd > 60
        
        if (isOverflow) {
            overflow = mm + dd - 60
            feeTime = dd - overflow
        }

        fees += when {
            hh in 7 until 19 -> {
                if (hh == 18 && isOverflow) feeTime * 10 + overflow * 5
                else dd * 10
            }
            else -> {
                if (hh == 6 && isOverflow) feeTime * 5 + overflow * 10
                else dd * 5
            }
        }
    }

    print(fees)
}