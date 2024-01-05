class Solution {
    fun solution(num_list: IntArray): Int {
        // 합도 sum()보다 fold, reduce로 쓰는게 속도가 빠름.
        return if(num_list.size >= 11) num_list.fold(0) { acc, n -> acc + n} else num_list.fold(1) { acc, n -> acc * n }
    }
}