class Solution {
    fun solution(my_string: String, is_suffix: String): Int {
        val suf = my_string.indices.map { my_string.substring(it) }
            return if(suf.any { it == is_suffix }) 1 else 0
    }
}