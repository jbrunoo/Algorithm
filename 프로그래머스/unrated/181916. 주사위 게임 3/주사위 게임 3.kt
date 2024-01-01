class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        val numList = listOf(a, b, c, d)
        val counts = numList.groupingBy { it }.eachCount()
        var answer: Int = 0
        when(numList.distinct().size) {
            1 -> {
                answer = 1111 * a
            }
            2 -> {
                if(counts.values.all { it == 2 }) {
                    val (p, q) = counts.filterValues { it == 2 }.keys.sorted()
                    answer = (p + q) * (q - p)
                } else {
                    val p = counts.filterValues { it == 1 }.keys.toList()[0]
                    val q = counts.filterValues { it == 3 }.keys.sorted()[0]
                    // val (p, q) = counts.filterValues { it == 1 || it == 3 }.keys.sorted() 한꺼번에 적는 바람에 세 주사위에서 나온 수 구분이 안되서 테스트 통과 못한 경우가 생겼음.
                    answer = (10 * q + p) * (10 * q + p)
                }
            }
            3 -> {
                val (q, r) = counts.filterValues { it == 1 }.keys.sorted()
                answer = q * r
            }
            4 -> {
                answer = numList.minOf { it }
            }
        }
        return answer
    }
}
