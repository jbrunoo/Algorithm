class Solution {
    fun solution(n: Int): IntArray {
        var answer: MutableList<Int> = mutableListOf(n)
        var x: Int = n
        while(x != 1) {
            if(x % 2 == 0) {
                x = x / 2
                answer.add(x)
            }
            else {
                x = 3 * x + 1
                answer.add(x)
            }
        }
        return answer.toIntArray()
    }
}