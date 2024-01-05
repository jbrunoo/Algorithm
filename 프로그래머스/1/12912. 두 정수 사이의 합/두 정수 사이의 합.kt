class Solution {
    fun solution(a: Int, b: Int): Long {
        return if(a <= b) (a.toLong()..b).sum() else (b.toLong()..a).sum()
    }
}