class Solution {
    fun solution(order: Array<String>): Int {
        var answer: Int = 0
        order.forEach {
            if("cafelatte" in it) answer += 5000
            else answer += 4500
        }
        return answer
        // return order.map { if(it.contains("cafelatte")) 5000 else 4500 }.sum()
    }
}