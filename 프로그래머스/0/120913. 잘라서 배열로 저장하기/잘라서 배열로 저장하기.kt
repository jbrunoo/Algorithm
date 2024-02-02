class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        return my_str.chunked(n).toTypedArray()
    }
}