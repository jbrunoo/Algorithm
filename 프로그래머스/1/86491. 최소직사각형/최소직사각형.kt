class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxLength = 0
        var maxHeight = 0
        
        // max, min deprecated
        sizes.forEach {
            if(maxLength < it.maxOrNull()!!) maxLength = it.maxOrNull()!!
            if(maxHeight < it.minOrNull()!!) maxHeight = it.minOrNull()!!
        }
        
        return maxLength * maxHeight
    }
}