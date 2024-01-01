class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: MutableList<Int> = mutableListOf()
        var i = 0
        while(i < arr.size) {
            if(stk.isEmpty() || stk.last() < arr[i]) {
                stk.add(arr[i]) 
                i++
            }
            else stk.removeAt(stk.size - 1)
        }
        return stk.toIntArray()
    }
}