class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        val num1 = StringBuilder().append(a).append(b).toString().toInt() 
        val num2 = 2 * a * b
        answer = if(num1 <= num2) num2 else num1
        return answer
    }
}