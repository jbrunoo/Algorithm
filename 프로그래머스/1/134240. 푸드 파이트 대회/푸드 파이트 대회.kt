class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        var order = ""
        
        for(i in 1 until food.size) {
            val n = food[i] / 2
            if(n > 0) {
                for(j in 1..n) {
                    order += i
                }
            }
        }
        answer = order + "0" + order.reversed()     
        return answer
    }
}