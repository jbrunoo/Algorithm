class Solution {
    fun solution(my_string: String, k: Int): String {
        val stringBuilder = StringBuilder()

        for (i in (1..k)) {
            stringBuilder.append(my_string)
        }

        return stringBuilder.toString()
        // 
    }
}