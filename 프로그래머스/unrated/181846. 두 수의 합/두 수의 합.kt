import java.math.BigInteger
class Solution {
    fun solution(a: String, b: String): String {
        // 배열로 나누어서 구현
        // python3, java는 담을 수 있음.
        // (to) BigInteger, BigDecimal
        val numA = BigInteger(a)
        val numB = BigInteger(b)
        val sum = numA.add(numB)
        return sum.toString()
    }
}