class Solution {
    fun solution(num_list: IntArray): Int {
        val odd = (num_list.indices step 2).sumBy { num_list[it] }
        val even = (1 until num_list.size step 2).sumBy { num_list[it] }
        return if(odd > even) odd else even
    }
}