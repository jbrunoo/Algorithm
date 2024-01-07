class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: IntArray = intArrayOf()
        var i = 0
        while(i < arr.size) {
            if(stk.isEmpty()) {
                stk += arr[i]
                i++
            } else {
                if(stk[stk.lastIndex] == arr[i]) {
                    stk = stk.dropLast(1).toIntArray()
                    i++
                } else {
                    stk += arr[i]
                    i++
                }
            }
            
        }
        return if(stk.isNotEmpty()) stk else intArrayOf(-1)
    }
}