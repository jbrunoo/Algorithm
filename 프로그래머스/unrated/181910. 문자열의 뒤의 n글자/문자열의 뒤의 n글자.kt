class Solution {
    fun solution(my_string: String, n: Int): String {
        return my_string.removeRange(0 until my_string.length - n)
    
    }
}