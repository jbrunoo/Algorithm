import java.math.BigInteger
class Solution {
    fun solution(a: String, b: String): String {
        val numA = BigInteger(a)
        val numB = BigInteger(b)
        val sum = numA.add(numB)
        return sum.toString()
    }
}