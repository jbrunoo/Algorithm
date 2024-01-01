class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var stringBuilder = StringBuilder()
        
        for(i in index_list) {
            stringBuilder.append(my_string[i])
        }
        return stringBuilder.toString()
    }
}