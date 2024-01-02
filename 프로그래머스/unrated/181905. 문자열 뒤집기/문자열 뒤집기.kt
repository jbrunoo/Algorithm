class Solution {
    fun solution(my_string: String, s: Int, e: Int): String {
        return my_string.slice(0 until s) + my_string.substring(s..e).reversed() + my_string.slice(e + 1 until my_string.length)
    }
}