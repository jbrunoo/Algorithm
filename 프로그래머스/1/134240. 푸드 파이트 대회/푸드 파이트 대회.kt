class Solution {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        for(i in 1 until food.size) {
            repeat(food[i] / 2) {
                sb.append(i)
            }
        }
        sb.append(0)    
        for(i in food.size-1 downTo 1) {
            repeat(food[i] / 2) {
                sb.append(i)
            }
        }
        return sb.toString()
    }
}