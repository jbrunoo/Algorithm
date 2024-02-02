class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxLength = 0
        var maxHeight = 0
        
        // max, min 함수가 1.6.10에 없나봄..
        sizes.forEach {
            if(maxLength < it.maxOrNull()!!) maxLength = it.maxOrNull()!!
            if(maxHeight < it.minOrNull()!!) maxHeight = it.minOrNull()!!
        }
        
        return maxLength * maxHeight
    }
}