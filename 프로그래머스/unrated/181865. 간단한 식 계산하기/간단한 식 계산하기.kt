class Solution {
    fun solution(binomial: String): Int {
        // val op = listOf('+', '-', '*')
        val s = binomial.replace(" ", "")
        return if('+' in s) {
            val li = s.split('+').map { it.toInt() }
            li[0] + li[1]
        }
        else if ('-' in s) {
            val li = s.split('-').map { it.toInt() }
            li[0] - li[1]
        }
        else {
            val li = s.split('*').map { it.toInt() }
            li[0] * li[1]
        }
    }
}