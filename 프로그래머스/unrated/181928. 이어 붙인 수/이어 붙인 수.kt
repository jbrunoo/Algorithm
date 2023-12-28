class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var even = StringBuilder()
        var odd = StringBuilder()
        for(i in num_list) {
            if(i % 2 == 0) {
                even.append("$i")
            } else {
                odd.append("$i")
            }
        }
        answer = odd.toString().toInt() + even.toString().toInt()
        return answer
    }
}