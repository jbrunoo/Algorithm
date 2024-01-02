class Solution {
    fun solution(my_string: String, is_suffix: String): Int {
        return if(my_string.endsWith(is_suffix)) 1 else 0
        // val suf = my_string.indices.map { my_string.substring(it) }
        //     return if(suf.any { it == is_suffix }) 1 else 0
    }
}